package com.coderzh.parctice.algorithm;

/**
 * Created by zhangwenbin on 2018/7/13.
 */
public class Bitmap {

    /**
     * @param datas
     */
    public static void bitmapSort(int[] datas, int size) {

        byte[] bytes = new byte[size];
        for (int i : datas) {
            bytes[i] = 1;
        }

        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == 1) {
                System.out.println(i);
            }
        }

    }

    public static void main(String[] args) {
        int[] datas = {4, 7, 8, 5, 3, 1};
        bitmapSort(datas, 9);
    }

}
