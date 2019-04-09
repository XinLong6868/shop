package com.fh.shop.backend.springText;

public class SingLeTonText2 {

    public static void main(String[] args) {

        SingLeTonText3 singLeTonText3 = new SingLeTonText3();

        for (int i = 0; i < 1000000; i++) {
            //创建线程
            Thread thread = new Thread(singLeTonText3);
            //线程就绪
            thread.start();
        }
    }
}
