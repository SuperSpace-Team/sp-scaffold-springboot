package com.yh.scaffold.springboot.annotation;

import java.lang.annotation.*;

/**
 * Demo自定义注解
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface DemoAnnotation {

}
