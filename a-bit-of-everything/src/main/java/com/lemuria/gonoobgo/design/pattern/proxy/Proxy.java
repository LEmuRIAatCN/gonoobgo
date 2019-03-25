package com.lemuria.gonoobgo.design.pattern.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.ReactiveListCommands;

@Slf4j
public class Proxy {
    static class Bird implements Flyable {
        public void fly(){
            while(true){
                try {
                    log.info("bird flying");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    interface Flyable{
        void fly();
    }
    @Slf4j
    static class BirdLogger implements Flyable{
        private Flyable b;

        public BirdLogger(Flyable b){
            this.b = b;
        }

        @Override
        public void fly() {
            long start = System.currentTimeMillis();
            b.fly();
            long stop = System.currentTimeMillis();
            log.info("Time is "+(stop-start));
        }
    }

    @Slf4j
    static class BirdLocater implements Flyable{
        private Flyable b;

        public BirdLocater(Flyable b){
            this.b = b;
        }

        @Override
        public void fly() {
            log.info("Locate!!!!!!! ");
            b.fly();
            log.info("Locate!!!!!!! ");
        }
    }

    public static void main(String[] args){
        Bird b = new Bird();
        BirdLogger bl = new BirdLogger(b);
        BirdLocater bc = new BirdLocater(bl);
        bc.fly();
    }
}
