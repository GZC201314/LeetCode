package org.gzc.juc;

public class SellTicket implements Runnable {
    //定义一个成员变量表示有100张票
    private static int tickets=100;
    @Override
    public void run(){
     while (true){
         synchronized (SellTicket.class){
             if(tickets>0){
                 try {
                     //通过sleep()方法来等待
                     Thread.sleep(100);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 System.out.println(Thread.currentThread().getName()+"正在出售第"+tickets--+"张票");
             }else{
                 break;
             }
         }
     }
    }
}
