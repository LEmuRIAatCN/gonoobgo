package com.lemuria.gonoobgo.javalocklearning;

public class LockLearning {
    private final Object lock = new Object();

    public void dTh() {
        new Thread(new Test1("1"), "T1").start();
        new Thread(new Test1("2"), "T2").start();
        new Thread(new Test2("3"), "T3").start();
        new Thread(new Test2("4"), "T4").start();
        // new Test1("1").run();
        //new Test1("2").run();
    }

    public static void main(String[] ar) {
        new LockLearning().dTh();
    }

    class Test1 implements Runnable {
        String name = "";

        public Test1(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            synchronized (lock) {
                // while(true) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Got The LOck name is :" + name + "," + i+".ThreadName:"+Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //}
                }
            }
        }
    }

    class Test2 implements Runnable {
        String name = "";

        public Test2(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            //synchronized (lock) {
                // while(true) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Non synchronized name is :" + name + "," + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //}
                }
            //}
        }
    }

}
