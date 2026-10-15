package com.example.CustomAnnoatationWithAspect.customAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
public @interface TrackResponseTime
{
}
