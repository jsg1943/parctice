package com.coderzh.parctice.proxy;

/**
 * Created by zhangwenbin on 2018/7/2.
 */
public class TargetObjectImpl implements TargetObject {
    @Override
    public void execute() {
        System.out.println("I'am targetObject implements ========");
    }
}
