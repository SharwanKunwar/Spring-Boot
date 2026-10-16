package com.example.CustomAnnoatationWithAspect.customAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker annotation used to track the execution time of a field or method
 * when processed by an Aspect (AOP).
 *
 * With annotation:
 * - An Aspect can intercept the annotated method and measure execution time,
 *   if pointcut and advice are configured.
 *
 * Without annotation:
 * - The Aspect will not intercept the element through this annotation-based
 *   pointcut.
 *
 * Other possible uses:
 * - Log method execution time.
 * - Monitor performance.
 * - Record metrics for monitoring tools.
 * - Detect slow methods.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackResponseTime
{
    // Marker annotation: no attributes; its presence identifies an element.
    long warnAfter() default 1000;
    String operation() default "";
}
