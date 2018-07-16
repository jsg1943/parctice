package com.coderzh.parctice.proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * Created by zhangwenbin on 2018/7/2.
 */
public class JDKDynamicProxy {

    public static void main(String[] args) {
        MyProxy myProxy = new MyProxy(TargetObjectImpl.class);
        TargetObject newProxyInstance = (TargetObject) Proxy.newProxyInstance(JDKDynamicProxy.class.getClassLoader(), new Class[]{TargetObject.class}, myProxy);
        newProxyInstance.execute();

        byte[] myProxies = ProxyGenerator.generateProxyClass("myProxy", new Class[]{TargetObject.class});

        try {
            FileOutputStream outputStream = new FileOutputStream(new File("D:\\myProxy.class"));
            outputStream.write(myProxies);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
