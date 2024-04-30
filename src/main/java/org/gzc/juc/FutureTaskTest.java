package org.gzc.juc;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTaskTest {
    public static void main(String[] args) throws Exception{
        FutureTask futureTask = new FutureTask(()->{
            try { TimeUnit.SECONDS.sleep(3);  } catch (InterruptedException e) {e.printStackTrace();}
            System.out.println(Thread.currentThread().getName()+"\t"+"coming......");
            return 1024;
        });
        new Thread(futureTask).start();
        //1.果futureTask.get()放到main线程前面,会导致main线程阻塞
        //Object o = futureTask.get();

        /*Object o = futureTask.get();//不见不散,只要出现了get()方法就会阻塞
        System.out.println("不见不散,只要出现了get()方法就会阻塞,获取到的值为:"+o);*/
        //2.过时不候
//        System.out.println(Thread.currentThread().getName()+"\t"+"线程来了.....");
//        Object o2 = futureTask.get(2L, TimeUnit.SECONDS);
        //3.使用轮询
        while(true){
            if(futureTask.isDone()){
                System.out.println("使用轮询来解决,值为:"+futureTask.get());
                break;
            }else{
                System.out.println("阻塞中**********");
            }
        }
    }
}