package com.coderzh.parctice.myAnnotation;

/**
 * Created by zhangwenbin on 2018/5/16.
 */
public class BaseTest {

    @MyAnnotation
    public void test(String str){
        System.out.println("["+str+"] this is a custom anntation test!");
    }

}
