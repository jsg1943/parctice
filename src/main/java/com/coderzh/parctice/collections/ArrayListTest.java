package com.coderzh.parctice.collections;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 * Created by zhangwenbin on 2018/6/28.
 */
public class ArrayListTest {

    public static void testArrayList() throws Exception{

        List<String> myArrayList = new Vector<>();
        myArrayList.add("111");
        myArrayList.add("222");
        myArrayList.add("333");
        myArrayList.add("444");
        myArrayList.add("555");
        myArrayList.add("666");
        myArrayList.add("777");
        myArrayList.add("888");
        myArrayList.add("999");
        myArrayList.add("10");

        Method capacity = myArrayList.getClass().getDeclaredMethod("capacity", null);
        int invoke = (int)capacity.invoke(myArrayList, null);
        System.out.println("list capacity="+invoke);

        myArrayList.add("11");

        invoke = (int)capacity.invoke(myArrayList, null);
        System.out.println("list capacity="+invoke);
    }

    public static void main(String[] args) {
        try {
            testArrayList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
