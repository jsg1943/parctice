package com.coderzh.parctice.concurrent;

/**
 * 交替打印奇数和偶数
 * Created by zhangwenbin on 2018/6/29.
 */
public class PrintOddEvenNum {

    private int num = 1;
    private boolean flag = true;

    public static void main(String[] args) {

        PrintOddEvenNum printOddEvenNum = new PrintOddEvenNum();

        Thread printOddNum = new Thread(new PrintOddNumWithCAS(printOddEvenNum),"奇数线程");
        Thread printEvenNum = new Thread(new PrintEvenNumWithCAS(printOddEvenNum), "偶数线程");

        printOddNum.start();
        printEvenNum.start();

    }

    public static class PrintOddNum implements Runnable{

        PrintOddEvenNum printOddEvenNum;

        PrintOddNum(PrintOddEvenNum printOddEvenNum){
            this.printOddEvenNum = printOddEvenNum;
        }

        @Override
        public void run() {

            while (printOddEvenNum.num <= 100) {

                if (printOddEvenNum.flag) {
                    System.out.println(Thread.currentThread().getName() + " ========= "+printOddEvenNum.num);
                    printOddEvenNum.num ++;
                    printOddEvenNum.flag = false;
                }else{
                    // 防止空转
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    public static class PrintEvenNum implements Runnable{

        PrintOddEvenNum printOddEvenNum;

        PrintEvenNum(PrintOddEvenNum printOddEvenNum){
            this.printOddEvenNum = printOddEvenNum;
        }

        @Override
        public void run() {

            while (printOddEvenNum.num <= 100) {

                if (!printOddEvenNum.flag) {
                    System.out.println(Thread.currentThread().getName() + " ========= "+printOddEvenNum.num);
                    printOddEvenNum.num ++;
                    printOddEvenNum.flag = true;
                }else{
                    // 防止空转
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    public static class PrintEvenNumWithCAS implements Runnable{

        PrintOddEvenNum printOddEvenNum;

        PrintEvenNumWithCAS(PrintOddEvenNum printOddEvenNum){
            this.printOddEvenNum = printOddEvenNum;
        }

        private int tempNum = 1;

        @Override
        public void run() {
            while (printOddEvenNum.num <= 100) {
                if (tempNum + 1 == printOddEvenNum.num) {
                    System.out.println(Thread.currentThread().getName() + " ========= "+printOddEvenNum.num);
                    printOddEvenNum.num ++;
                    tempNum = printOddEvenNum.num;
                }
            }
        }
    }

    public static class PrintOddNumWithCAS implements Runnable{

        PrintOddEvenNum printOddEvenNum;

        PrintOddNumWithCAS(PrintOddEvenNum printOddEvenNum){
            this.printOddEvenNum = printOddEvenNum;
        }

        private int tempNum = 0;

        @Override
        public void run() {
            while (printOddEvenNum.num <= 100) {
                if (tempNum + 1 == printOddEvenNum.num) {
                    System.out.println(Thread.currentThread().getName() + " ========= "+printOddEvenNum.num);
                    printOddEvenNum.num ++;
                    tempNum = printOddEvenNum.num;
                }
            }
        }
    }

}

