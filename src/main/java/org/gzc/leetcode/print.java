package org.gzc.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author GZC
 * @create 2022-02-21 16:41
 * @desc
 */
public class print {
    private static Thread t1 = null;
    private static Thread t2 = null;

    public static void main(String[] args) {
        char[] aChars = "ABCDE".toCharArray();
        char[] bChars = "12345".toCharArray();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Object o = new Object();
        new Thread(() -> {
            lock.lock();
            try {
                for (char a :
                        aChars) {

                    System.out.print(a);
                    condition.signal();
                    condition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(() -> {
            synchronized (o) {
                for (char a :
                        bChars) {
                    System.out.print(a);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                o.notify();
            }
        }).start();
    }
}
//        t1 = new Thread(() -> {
//            for (char a : aChars) {
//                System.out.print(a);
//                //叫醒t2
//                LockSupport.unpark(t2);
//                //t1 阻塞
//                LockSupport.park();
//            }
//        }, "t1");
//        t2 = new Thread(() -> {
//            for (char a : bChars) {
//                //t2挂起
//                LockSupport.park();
//                System.out.print(a);
//                // 叫醒t1
//                LockSupport.unpark(t1);
//            }
//        }, "t2");
//
//
//        t1.start();
//        t2.start();


//    TransferQueue<Character> queue = new LinkedTransferQueue<>();
//        t1 = new Thread(() -> {
//                for (char a : aChars) {
//                try {
//                queue.transfer(a);
//                System.out.print(queue.take());
//                } catch (InterruptedException e) {
//                e.printStackTrace();
//                }
//
//                }
//                }, "t1");
//                t2 = new Thread(() -> {
//                for (char a : bChars) {
//                try {
//                System.out.print(queue.take());
//                } catch (InterruptedException e) {
//                e.printStackTrace();
//                }
//                try {
//                queue.transfer(a);
//                } catch (InterruptedException e) {
//                e.printStackTrace();
//                }
//                }
//                }, "t2");
//
//
//                t1.start();
//                t2.start();


//    char[] aChars = "ABCDE".toCharArray();
//    char[] bChars = "12345".toCharArray();
//
//    Object o = new Object();
//        new Thread(()->{
//synchronized (o){
//        for (char a :
//        aChars) {
//        System.out.print(a);
//        try {
//        o.notify();
//        o.wait();
//        } catch (InterruptedException e) {
//        e.printStackTrace();
//        }
//        }
//        o.notify();
//        }
//        }).start();
//
//        new Thread(() ->{
//synchronized (o){
//        for (char a :
//        bChars) {
//        System.out.print(a);
//        try {
//        o.notify();
//        o.wait();
//        } catch (InterruptedException e) {
//        e.printStackTrace();
//        }
//
//        }
//        o.notify();
//        }
//        }).start();
//        }