package com.example.CustomAnnoatationWithAspect.customAnnotations;

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
public @interface Greeting
{
    // Marker annotation: no attributes; its presence identifies an element.
}