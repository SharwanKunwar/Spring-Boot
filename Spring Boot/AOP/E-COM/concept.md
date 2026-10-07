# Spring AOP Advice Examples

A practical reference for the main Spring AOP advice types:

- `@Before`
- `@AfterReturning`
- `@AfterThrowing`
- `@After`
- `@Around`

Examples use:

```text
com.example.E_COM.service.implementation.ProductService.createProduct(..)
```

---

## 1. `@Before` — Execute Before the Method

`@Before` runs before the target method.

It is commonly used for:

- Logging
- Validation
- Authorization
- Authentication

You can inspect method arguments using `JoinPoint`.

```java
package com.example.E_COM.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.example.E_COM.service.implementation.ProductService.createProduct(..))")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("Product is going to be saved.");

        Object[] args = joinPoint.getArgs();

        System.out.println("Arguments:");

        for (Object arg : args) {
            System.out.println(arg);
        }
    }
}
```

### Important

`@Before` can inspect the arguments, but it does not give you full control over the target method execution.

If you need to modify arguments before the target method receives them, use `@Around`.

---

## 2. `@AfterReturning` — Execute After Successful Return

`@AfterReturning` runs only when the target method completes successfully.

```java
@AfterReturning(
        value = "execution(* com.example.E_COM.service.implementation.ProductService.createProduct(..))",
        returning = "res"
)
public void logAfterReturning(ProductResponseDTO res) {

    System.out.println("Product created successfully.");

    System.out.println("Returned object: " + res);
}
```

### When to use it

Good for:

- Logging successful results
- Auditing
- Inspecting the returned object

### Important

You generally should not use `@AfterReturning` when your goal is to control or transform the method's return flow.

For explicit return-value transformation, `@Around` is better.

For example, avoid using it like this:

```java
@AfterReturning(...)
public void logAfterReturning(ProductResponseDTO res) {

    res.setName("phone");
}
```

Use `@Around` when you need explicit control over the result.

---

## 3. `@AfterThrowing` — Execute When an Exception Occurs

`@AfterThrowing` runs when the target method throws an exception.

It is useful for error and exception logging.

```java
package com.example.E_COM.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @AfterThrowing(
            value = "execution(* com.example.E_COM.service.implementation.ProductService.createProduct(..))",
            throwing = "ex"
    )
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {

        System.out.println("Method failed.");

        System.out.println(
                "Method: " +
                joinPoint.getSignature().getName()
        );

        System.out.println(
                "Exception: " +
                ex.getMessage()
        );
    }
}
```

For example, if the service throws:

```java
throw new RuntimeException("Product already exists");
```

The aspect can log:

```text
Method failed.
Method: createProduct
Exception: Product already exists
```

---

## 4. `@After` — Execute After the Method

`@After` runs after the method finishes.

It runs whether the method:

- Completes successfully
- Throws an exception

```java
package com.example.E_COM.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @After("execution(* com.example.E_COM.service.implementation.ProductService.createProduct(..))")
    public void logAfter(JoinPoint joinPoint) {

        System.out.println(
                "Finished execution of: " +
                joinPoint.getSignature().getName()
        );
    }
}
```

Conceptually:

```text
                 createProduct()
                       |
             +---------+---------+
             |                   |
          success             exception
             |                   |
      @AfterReturning      @AfterThrowing
             \                   /
              \                 /
                    @After
```

Think of `@After` as being conceptually similar to a `finally` block.

---

# 5. `@Around` — Full Control Over Method Execution

`@Around` is the most powerful AOP advice.

It uses `ProceedingJoinPoint`.

With `@Around`, you can:

- Execute code before the method
- Inspect arguments
- Modify arguments
- Decide whether the target method executes
- Execute the target method using `proceed()`
- Inspect the result
- Modify the result
- Execute code after the method
- Handle exceptions

Example:

```java
package com.example.E_COM.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Around(
            "execution(* com.example.E_COM.service.implementation.ProductService.createProduct(..))"
    )
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("Before target method");

        Object[] args = joinPoint.getArgs();

        System.out.println("Arguments before execution:");

        for (Object arg : args) {
            System.out.println(arg);
        }

        // Execute actual method
        Object result = joinPoint.proceed();

        System.out.println("After target method");

        System.out.println("Result: " + result);

        return result;
    }
}
```

### Flow

```text
@Around
   |
   |-- before logic
   |
   |-- joinPoint.proceed()
   |        |
   |        v
   |   Actual method
   |        |
   |        v
   |      result
   |
   |-- after logic
   |
   v
return result
```

---

# 6. `@Around` — Modify Method Arguments

This is one of the important differences between `@Before` and `@Around`.

Suppose your service has:

```java
public ProductResponseDTO createProduct(ProductRequestDTO dto) {
    // save product
}
```

You can modify the argument before passing it to the target method:

```java
@Around(
        "execution(* com.example.E_COM.service.implementation.ProductService.createProduct(..))"
)
public Object modifyArgument(ProceedingJoinPoint joinPoint) throws Throwable {

    Object[] args = joinPoint.getArgs();

    ProductRequestDTO dto = (ProductRequestDTO) args[0];

    dto.setName("phone");

    // Target method receives the modified argument
    return joinPoint.proceed(args);
}
```

### Flow

```text
Original request
      |
      v
ProductRequestDTO
name = "laptop"
      |
      v
   @Around
      |
      | modify
      v
ProductRequestDTO
name = "phone"
      |
      v
joinPoint.proceed(args)
      |
      v
createProduct(dto)
```

---

# 7. `@Around` — Modify the Return Value

If you want to modify the return value, `@Around` is the appropriate advice.

Instead of:

```java
@AfterReturning(...)
public void logAfterReturning(ProductResponseDTO res) {

    res.setName("phone");
}
```

Use:

```java
@Around(
        "execution(* com.example.E_COM.service.implementation.ProductService.createProduct(..))"
)
public Object modifyResponse(ProceedingJoinPoint joinPoint) throws Throwable {

    Object result = joinPoint.proceed();

    ProductResponseDTO response = (ProductResponseDTO) result;

    response.setName("phone");

    return response;
}
```

The important part is:

```java
Object result = joinPoint.proceed();
```

The target method executes and returns its result.

Then you can modify the result:

```java
ProductResponseDTO response = (ProductResponseDTO) result;

response.setName("phone");

return response;
```

---

# 8. Quick Comparison

| Advice | Runs When | Main Use |
|---|---|---|
| `@Before` | Before target method | Logging, validation, authorization |
| `@AfterReturning` | After successful execution | Logging successful result |
| `@AfterThrowing` | When exception occurs | Exception/error logging |
| `@After` | After method finishes | Cleanup/final logging |
| `@Around` | Around target method | Full control over execution |

---

# 9. Easy Way to Remember

```text
@Before
    ↓
Before method


@AfterReturning
    ↓
After successful return


@AfterThrowing
    ↓
After exception


@After
    ↓
Finally / after execution


@Around
    ↓
Full control over method execution
```

---

# 10. Most Important Concept

The easiest distinction is:

```text
@Before
    |
    +-- Inspect before execution


@AfterReturning
    |
    +-- Inspect successful result


@AfterThrowing
    |
    +-- Inspect exception


@After
    |
    +-- Run after execution regardless of outcome


@Around
    |
    +-- Before
    +-- Modify arguments
    +-- Decide whether to execute
    +-- Execute with proceed()
    +-- Modify result
    +-- After
```

### Rule of Thumb

Use:

```text
@Before          → I need to do something before the method.

@AfterReturning  → I need to observe a successful result.

@AfterThrowing   → I need to observe/log an exception.

@After           → I need something to happen after execution.

@Around          → I need control over the method execution.
```

---

## Example Package Structure

A typical project can look like:

```text
src/
└── main/
    └── java/
        └── com/
            └── example/
                └── E_COM/
                    ├── aspect/
                    │   └── LoggingAspect.java
                    │
                    ├── service/
                    │   └── implementation/
                    │       └── ProductService.java
                    │
                    └── dtos/
                        ├── ProductRequestDTO.java
                        └── ProductResponseDTO.java
```

---

## Final Takeaway

`@Around` is the advice to learn carefully because it gives the most control.

The key method is:

```java
joinPoint.proceed();
```

Without calling `proceed()`, the target method does not execute.

For example:

```java
@Around("execution(* com.example.E_COM.service.implementation.ProductService.createProduct(..))")
public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

    System.out.println("Before");

    Object result = joinPoint.proceed();

    System.out.println("After");

    return result;
}
```

This gives you the basic AOP pattern:

```text
Before
   ↓
Target Method
   ↓
After
   ↓
Return
```