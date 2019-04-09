package com.fh.shop.backend.springText;

public class SingLeTonText3 implements Runnable {
    private Integer Count = 0;
    @Override
    public void run() {
        //调用下面的个数
        incountmend();
    }

    public synchronized void incountmend(){
        Count++;
        System.out.println(Count);

    }
}
