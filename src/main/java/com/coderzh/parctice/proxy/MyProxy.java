package com.coderzh.parctice.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zhangwenbin on 2018/7/2.
 */
public class MyProxy implements InvocationHandler {

    private static final Logger logger = LoggerFactory.getLogger(MyProxy.class);

    private Object object;

    MyProxy(Class clazz){
        try {
            this.object = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        handleBefore();
        Object result =  method.invoke(object,args);
        handleAfter();
        return result;
    }

    private void handleBefore(){
        System.out.println("proxy handle before=========");
    }

    private void handleAfter(){
        System.out.println("proxy handle after==========");
    }

}
