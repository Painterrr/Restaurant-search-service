package com.example.firstproject.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD}) // target of annotation
@Retention(RetentionPolicy.RUNTIME) // time annotation execute
public @interface RunningTime {

}
