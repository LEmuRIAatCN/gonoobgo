package com.lemuria.gonoobgo.design.pattern.proxy;

import java.util.concurrent.*;

public class QueueConsume {
    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println("hahahah");
        }
    }
    public static void main(String[] args){
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(1, 1,
                10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));
        LinkedBlockingQueue<Runnable> runnables = new LinkedBlockingQueue<>();
        for(int i =0; i<10000;i++){
            try {
                runnables.put(new Task());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("queue size :"+runnables.size());
        while(runnables.peek()!=null){
            executorService.execute(runnables.poll());
            System.out.println(runnables.size());
        }
        System.out.println();
    }
}
