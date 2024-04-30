package org.gzc.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class JoinDemo {

    public static void main(String[] args) {
        //初始化线程1，由于后续有匿名内部类调用这个局部变量，需要用final修饰
        //这里不用final修饰也不会报错的原因 是因为jdk1.8对其进行了优化
        /*
        在局部变量没有重新赋值的情况下，它默认局部变量为final类型，认为你只是忘记了加final声明了而已。
        如果你重新给局部变量改变了值或者引用，那就无法默认为final了
         */
//        Thread t1 = new Thread(() -> System.out.println("t1 is running..."));
//
//        //初始化线程二
//        Thread t2 = new Thread(() -> {
//            try {
//                t1.join();
//                System.out.println("t2 is running...");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        //初始化线程三
//        Thread t3 = new Thread(() -> {
//            try {
//                t2.join();
//                System.out.println("t3 is running...");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        t1.start();
//        t2.start();
//        t3.start();


        new Thread(new FutureTask<>(new NumThead())).start();

    }

    //1.创建一个实现Callable接口的实现类
    static class NumThead implements Callable<Integer> {
        // class  NumThead implements Callable<Integer>{
        //2.实现call方法,将此线程需要执行的操作声明在call()中
        @Override
        public Integer call() {
            //public Integer call() throws Exception {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                System.out.println(i);
                sum += i;
            }
            return sum;
        }
    }
}

