package com.example.CustomAnnoatationWithAspect.customAnnotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Marker annotation used to identify classes or methods for custom behavior.
 *
 * With annotation:
 * - A configured Aspect or reflection-based code can detect it and perform
 *   a defined action, such as logging or authorization checks.
 *
 * Without annotation:
 * - Annotation-dependent logic will not apply to that element.
 *
 * Other possible uses:
 * - Log method calls.
 * - Check permissions.
 * - Validate method execution.
 * - Track API requests.
 * - Trigger auditing or custom business logic.
 *
 * Note:
 * - Without @Target, this annotation can be applied to any declaration
 *   where Java permits annotations, including classes, methods, and fields.
 */

//@Target : Specifies where an annotation can be applied, such as fields, methods, classes, or constructors. Example: `@Target(ElementType.METHOD)` allows the annotation only on methods.
//@Retention : Specifies how long an annotation is retained. `SOURCE` (compile time), `CLASS` (in bytecode, default), or `RUNTIME` (available through reflection and commonly used by AOP).
//@Documented: Indicates that an annotation should appear in generated JavaDoc documentation. Without it, the annotation can still work normally, but it won't automatically appear in the generated documentation.
@Retention(RetentionPolicy.RUNTIME)
public @interface Greeting
{
    // Marker annotation: no attributes; its presence identifies an element.
}


//Note: Annotation Binding Issue in Spring AOP
//- @annotation(greeting) binds the matched annotation instance to the greeting parameter in the advice method.
//- If @Retention(RetentionPolicy.RUNTIME) is missing, Java defaults to CLASS retention, so the annotation may not be available for runtime inspection.
//- Solution: Add @Retention(RetentionPolicy.RUNTIME) to the custom annotation to enable runtime detection and binding.
//- Use argNames if Spring cannot determine advice parameter names.