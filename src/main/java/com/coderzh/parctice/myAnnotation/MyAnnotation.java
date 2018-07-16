package com.coderzh.parctice.myAnnotation;

import java.lang.annotation.*;

/**
 * Created by zhangwenbin on 2018/5/10.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
//@Inherited
public @interface MyAnnotation {
}
