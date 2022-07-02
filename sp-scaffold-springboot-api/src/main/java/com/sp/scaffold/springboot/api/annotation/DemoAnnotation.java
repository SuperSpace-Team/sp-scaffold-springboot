package com.sp.scaffold.springboot.api.annotation;

import java.lang.annotation.*;

/**
 * [示例]自定义注解
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface DemoAnnotation {

}
