# 🔧 Spring Boot Configuration

### `application.properties` · `@Value` · `@ConfigurationProperties` · Runner Interfaces

> Externalizing config so you don't have to recompile your app every time a payment provider changes its mind.

---

## 📑 Table of Contents

1. [Why Do We Need Configuration?](#1-why-do-we-need-configuration)
2. [What Is `application.properties`?](#2-what-is-applicationproperties)
3. [Is `application.properties` Really External?](#3-is-applicationproperties-really-external)
4. [Externalized Configuration](#4-what-is-externalized-configuration)
5. [Using Config Values with `@Value`](#5-using-configuration-values-with-value)
6. [Default Values with `@Value`](#6-default-value-with-value)
7. [The Problem with Too Many `@Value`s](#7-problem-with-too-many-value-annotations)
8. [`@ConfigurationProperties`](#8-what-is-configurationproperties)
9. [Relaxed Binding](#9-why-does-paymentretry-count-map-to-retrycount)
10. [`@Value` vs `@ConfigurationProperties`](#10-value-vs-configurationproperties)
11. [Why Runner Interfaces?](#11-why-do-we-need-runner-interfaces)
12. [Why Not Just Call the Bean from `main()`?](#12-why-not-call-the-bean-manually-from-main)
13. [`CommandLineRunner`](#13-commandlinerunner)
14. [Passing Arguments to `CommandLineRunner`](#14-passing-arguments-to-commandlinerunner)
15. [`ApplicationRunner`](#15-applicationrunner)
16. [Complete Startup Flow](#16-complete-startup-flow)
17. [Exam-Style Q&A](#17-exam-style-qa)
18. [Revision Checklist](#18-revision-checklist)

---

## 1. Why Do We Need Configuration?

In real applications, **not every value should be hardcoded** inside Java classes.

```java
@Component
public class PaymentService {

    private String providerName = "Razorpay";
    private int retryCount = 3;

    public void pay() {
        System.out.println("Payment done using " + providerName);
        System.out.println("Retry count: " + retryCount);
    }
}
```

This *works* — but if the provider changes from `Razorpay` → `Stripe`, a hardcoded value forces you to:

1. Change the Java code
2. Recompile the project
3. Rebuild the application
4. Redeploy the application

That's a lot of ceremony for one string. 😩

### Values that shouldn't be hardcoded

| Category | Example |
|---|---|
| Payment provider name | `Razorpay`, `Stripe` |
| Retry count | `3` |
| Timeout value | `5000` ms |
| Feature flags | `enabled=true/false` |
| Database URL | `jdbc:postgresql://...` |
| API key | secrets |
| Server port | `8080` |
| External service URL | `https://api.example.com` |

> 💡 **Principle:** Keep changeable values *outside* Java business logic so the code stays clean and flexible.

---

## 2. What Is `application.properties`?

A **key-value configuration file** that Spring Boot automatically reads by convention.

**Default location:**
```
src/main/resources/application.properties
```

**Example:**
```properties
payment.provider=Razorpay
payment.retry-count=3
payment.enabled=true
payment.timeout=5000
```

Spring Boot also supports **YAML** via `application.yml`:

```yaml
payment:
  provider: Razorpay
  retry-count: 3
  enabled: true
  timeout: 5000
```

> Both formats do the same job — the difference is just writing style (flat key-value vs. nested/indented).

---

## 3. Is `application.properties` Really External?

Here's the twist most beginners miss:

When `application.properties` lives inside `src/main/resources`, it gets **packaged inside the final JAR file**. So technically, changing *only* this file still requires a rebuild.

**But** Spring Boot supports **externalized configuration** — meaning these values can also be supplied or *overridden* from **outside** the packaged app, via:

```
application.properties
application.yml
environment variables
command-line arguments
system properties
external config files
```

> ✅ **Takeaway:** Keep changeable values outside Java business logic — but understand that true runtime flexibility comes from overriding via env vars / CLI args / external files, not just editing the bundled file.

---

## 4. What Is Externalized Configuration?

Instead of:
```java
private String providerName = "Razorpay";
```

Write the value into a config file:
```properties
payment.provider=Razorpay
```

...then **inject** it into the Java class. This makes the app trivially portable across environments — same code, different config.

| Environment | `payment.provider` | `payment.retry-count` |
|---|---|---|
| Development | `TestProvider` | `1` |
| Production | `Razorpay` | `3` |

Java code stays identical. Only the configuration changes. 🎯

---

## 5. Using Configuration Values with `@Value`

Inject a single config value directly into a field or constructor parameter.

```java
@Component
public class PaymentService {

    private final String providerName;
    private final int retryCount;

    public PaymentService(
            @Value("${payment.provider}") String providerName,
            @Value("${payment.retry-count}") int retryCount) {
        this.providerName = providerName;
        this.retryCount = retryCount;
    }

    public void pay() {
        System.out.println("Payment done using " + providerName);
        System.out.println("Retry count: " + retryCount);
    }
}
```

| Expression | Meaning |
|---|---|
| `@Value("${payment.provider}")` | Go to the Spring `Environment`, find `payment.provider`, inject its value here |
| `@Value("${payment.retry-count}")` | Find `payment.retry-count` and inject it into this parameter |

---

## 6. Default Value with `@Value`

If a property is **missing** and no default is given, the app can **fail at startup**.

**Fix — provide a default using `:`**

```java
@Value("${payment.provider:DefaultProvider}")
private String providerName;
```

| Syntax | Meaning |
|---|---|
| `${payment.provider:DefaultProvider}` | Use `payment.provider` if available; otherwise fall back to `DefaultProvider` |

**Constructor version:**
```java
@Component
public class PaymentService {

    private final String providerName;

    public PaymentService(
            @Value("${payment.provider:DefaultProvider}") String providerName) {
        this.providerName = providerName;
    }
}
```

> Useful when a property is genuinely optional.

---

## 7. Problem with Too Many `@Value` Annotations

Given a properties file with several related keys:

```properties
payment.provider=Razorpay
payment.retry-count=3
payment.enabled=true
payment.timeout=5000
```

Using `@Value` for each one gets repetitive fast:

```java
@Value("${payment.provider}")
private String provider;

@Value("${payment.retry-count}")
private int retryCount;

@Value("${payment.enabled}")
private boolean enabled;

@Value("${payment.timeout}")
private int timeout;
```

It works — but it's **messy** as property count grows. For grouped configuration, Spring Boot offers a cleaner option: **`@ConfigurationProperties`**.

---

## 8. What Is `@ConfigurationProperties`?

Binds a **group of related properties** to a single Java object, instead of injecting each one separately.

**`application.properties`:**
```properties
payment.provider=Razorpay
payment.retry-count=3
payment.enabled=true
payment.timeout=5000
```

**Configuration class:**
```java
package in.strikes.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "payment")
public class PaymentProperties {

    private String provider;
    private int retryCount;
    private boolean enabled;
    private int timeout;

    public String getProvider() { return provider; }
    public void setProvider(String provider) { this.provider = provider; }

    public int getRetryCount() { return retryCount; }
    public void setRetryCount(int retryCount) { this.retryCount = retryCount; }

    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public int getTimeout() { return timeout; }
    public void setTimeout(int timeout) { this.timeout = timeout; }
}
```

`@ConfigurationProperties(prefix = "payment")` tells Spring Boot: *"look for all properties starting with `payment` and bind them to this class."*

**Mapping:**

| Property Key | Java Field |
|---|---|
| `payment.provider` | `provider` |
| `payment.retry-count` | `retryCount` |
| `payment.enabled` | `enabled` |
| `payment.timeout` | `timeout` |

**Inject and use it anywhere:**
```java
@Component
public class PaymentService {

    private final PaymentProperties paymentProperties;

    public PaymentService(PaymentProperties paymentProperties) {
        this.paymentProperties = paymentProperties;
    }

    public void pay() {
        System.out.println("Payment done using " + paymentProperties.getProvider());
        System.out.println("Retry count: " + paymentProperties.getRetryCount());
        System.out.println("Enabled: " + paymentProperties.isEnabled());
        System.out.println("Timeout: " + paymentProperties.getTimeout());
    }
}
```

> ✅ All payment-related config now lives in **one object** — much cleaner.

---

## 9. Why Does `payment.retry-count` Map to `retryCount`?

Thanks to **relaxed binding** — Spring Boot is flexible about property-naming styles and auto-converts them into Java's camelCase convention.

Spring Boot understands all of these as equivalent:

```
retry-count
retryCount
retry_count
RETRY_COUNT
```

| Style | Where it's used |
|---|---|
| `retryCount` (camelCase) | Java field names |
| `retry-count` (kebab-case) | Properties files |

> 🧠 **Mnemonic:** *"Kebab in the file, camel in the class — Spring bridges the gap."*

---

## 10. `@Value` vs `@ConfigurationProperties`

### `@Value`
```java
@Value("${payment.provider}")
private String provider;
```

✅ Good for:
- Single value
- Small demo
- Simple property injection

⚠️ Becomes repetitive with many related properties.

### `@ConfigurationProperties`
```properties
payment.provider=Razorpay
payment.retry-count=3
payment.enabled=true
payment.timeout=5000
```

✅ Good for:
- Grouped configuration
- Cleaner code
- Large applications
- Better readability

### Comparison Table

| Aspect | `@Value` | `@ConfigurationProperties` |
|---|---|---|
| Best for | 1–2 simple values | Groups of related values |
| Verbosity | Repetitive at scale | Compact, one class |
| Type safety | Per-field | Whole object |
| Default values | `${key:default}` syntax | Set in field or setter |
| Readability at scale | Poor | Excellent |

> 📏 **Simple rule:** One or two values → `@Value`. A related group → `@ConfigurationProperties`.

---

## 11. Why Do We Need Runner Interfaces?

In a **web app**, code typically runs in response to an HTTP request:

```
Browser/Postman sends request
        ↓
Controller receives request
        ↓
Service method executes
```

But without `spring-boot-starter-web` — no controller, no endpoint, no browser/Postman request — there's nothing to trigger your code.

**Solution:** run code automatically right after the Spring Boot application starts, using:

- `CommandLineRunner`
- `ApplicationRunner`

---

## 12. Why Not Call the Bean Manually from `main()`?

Technically you *can* do this:

```java
public static void main(String[] args) {
    ConfigurableApplicationContext context =
            SpringApplication.run(SpringBootCoreDemoApplication.class, args);

    PaymentService paymentService = context.getBean(PaymentService.class);
    paymentService.pay();
}
```

It works — but it's **not idiomatic Spring Boot**, because it drags you back into a manual style:

```
start context manually
fetch bean manually
call method manually
```

> ✅ **Better Spring Boot style:** Let Spring create a bean that runs automatically after startup — that's exactly what runner interfaces are for.

---

## 13. `CommandLineRunner`

A Spring Boot interface used to run code **after** the application has started.

```java
package in.strikes.runner;

import in.strikes.service.PaymentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private final PaymentService paymentService;

    public AppRunner(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void run(String... args) {
        paymentService.pay();
    }
}
```

**What happens under the hood:**

```
Spring creates AppRunner as a bean
        ↓
Spring injects PaymentService into AppRunner
        ↓
Spring Boot sees AppRunner implements CommandLineRunner
        ↓
Spring Boot calls run() after startup
        ↓
paymentService.pay() executes
```

Method signature:
```java
public void run(String... args)
```

`String... args` means the method can receive **multiple command-line arguments** as raw strings.

---

## 14. Passing Arguments to `CommandLineRunner`

Run from terminal:
```bash
java -jar app.jar hello world
```

Inside the runner:
```java
@Override
public void run(String... args) {
    for (String arg : args) {
        System.out.println(arg);
    }
}
```

**Output:**
```
hello
world
```

> `CommandLineRunner` receives arguments as a plain string array — no parsing, no structure.

---

## 15. `ApplicationRunner`

Similar to `CommandLineRunner`, but provides arguments in a more **structured** form via `ApplicationArguments`.

```java
package in.strikes.runner;

import in.strikes.service.PaymentService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunner implements ApplicationRunner {

    private final PaymentService paymentService;

    public AppStartupRunner(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void run(ApplicationArguments args) {
        paymentService.pay();
    }
}
```

Run with named options:
```bash
java -jar app.jar --provider=Razorpay --retry=3
```

Read them as structured options:
```java
@Override
public void run(ApplicationArguments args) {
    System.out.println(args.getOptionValues("provider"));
    System.out.println(args.getOptionValues("retry"));
}
```

### `CommandLineRunner` vs `ApplicationRunner`

| Interface | Argument Type | Signature |
|---|---|---|
| `CommandLineRunner` | Raw `String[]` | `run(String... args)` |
| `ApplicationRunner` | Structured `ApplicationArguments` | `run(ApplicationArguments args)` |

---

## 16. Complete Startup Flow

```
main() method starts
        ↓
SpringApplication.run() executes
        ↓
Spring Boot prepares the Environment
        ↓
Configuration values are loaded
(application.properties, application.yml, env vars, CLI args, etc.)
        ↓
ApplicationContext is created
        ↓
@SpringBootApplication is processed
        ↓
@ComponentScan scans the package
        ↓
@Component / @Service / @Repository / @Controller classes discovered
        ↓
@EnableAutoConfiguration checks dependencies on the classpath
        ↓
Matching auto-configurations are applied
        ↓
Beans are created
        ↓
Dependencies are injected
        ↓
Configuration values are injected or bound (@Value / @ConfigurationProperties)
        ↓
CommandLineRunner / ApplicationRunner executes
        ↓
Application either exits or keeps running (depending on app type)
```

> **In one sentence:** Spring Boot starts the container, loads configuration, scans classes, creates beans, injects dependencies, applies auto-configuration, and finally runs startup logic.

---

## 17. Exam-Style Q&A

<details>
<summary><strong>Q1. Why shouldn't configuration values be hardcoded in Java classes?</strong></summary>

Because changing them requires editing the Java code, recompiling, rebuilding, and redeploying the application — expensive for values that change across environments (e.g. dev vs. prod) or over time.
</details>

<details>
<summary><strong>Q2. Is `application.properties` truly "external" configuration?</strong></summary>

Not entirely — when placed in `src/main/resources`, it's packaged inside the JAR, so editing it alone still requires a rebuild. True externalization comes from Spring Boot's ability to override values via environment variables, CLI arguments, system properties, or external config files.
</details>

<details>
<summary><strong>Q3. What does `@Value("${payment.provider:DefaultProvider}")` mean?</strong></summary>

Use the value of `payment.provider` if it exists in the environment; otherwise fall back to the literal default `DefaultProvider`.
</details>

<details>
<summary><strong>Q4. When should you prefer `@ConfigurationProperties` over `@Value`?</strong></summary>

When there are many related properties belonging to the same group — it avoids repetitive `@Value` injections and keeps configuration in one cohesive, readable object.
</details>

<details>
<summary><strong>Q5. What is relaxed binding?</strong></summary>

Spring Boot's ability to match differently-styled property names (kebab-case, camelCase, snake_case, UPPER_CASE) to the corresponding camelCase Java field — e.g. `retry-count` → `retryCount`.
</details>

<details>
<summary><strong>Q6. Why use `CommandLineRunner`/`ApplicationRunner` instead of calling a bean manually in `main()`?</strong></summary>

Manually fetching the context and bean in `main()` works but breaks Spring Boot's idiomatic style (manual context/bean/method calls). Runner interfaces let Spring automatically create a bean and execute its logic right after startup — no web request needed.
</details>

<details>
<summary><strong>Q7. What's the key difference between `CommandLineRunner` and `ApplicationRunner`?</strong></summary>

`CommandLineRunner.run(String... args)` gives raw string arguments. `ApplicationRunner.run(ApplicationArguments args)` gives structured, named-option arguments (e.g. `--provider=Razorpay`).
</details>

---

## 18. Revision Checklist

- [ ] Explain why hardcoded values are bad (recompile/rebuild/redeploy cycle)
- [ ] Know the default location of `application.properties`
- [ ] Understand `application.properties` vs `application.yml`
- [ ] Explain why bundling in `src/main/resources` isn't *fully* external
- [ ] List the sources Spring Boot can read externalized config from
- [ ] Write a `@Value` injection with and without a default (`:default`)
- [ ] Explain the problem with too many `@Value` annotations
- [ ] Write a `@ConfigurationProperties` class with `prefix`
- [ ] Explain relaxed binding with an example (`retry-count` → `retryCount`)
- [ ] Compare `@Value` vs `@ConfigurationProperties` (when to use which)
- [ ] Explain why runner interfaces exist (no web request scenario)
- [ ] Implement `CommandLineRunner` and describe its `run(String... args)`
- [ ] Implement `ApplicationRunner` and describe `run(ApplicationArguments args)`
- [ ] Trace the complete Spring Boot startup flow from `main()` to runner execution

---

<p align="center"><sub>📘 Spring Boot Configuration — application.properties, @Value, @ConfigurationProperties, and Runner Interfaces</sub></p>