package com.gemini.cloud.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestThreadLocal {

    ThreadLocal<String> s = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return "3";
        }
    };

    ThreadLocal<Integer> i = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return 4;
        }
    };

    public static void main(String[] args) throws InterruptedException {

//        while (true){
//            new Thread(() -> {
//                System.out.println(new TestThreadLocal().s.get());
//                System.out.println(new TestThreadLocal().i.get());
//            }).start();
//
//            TimeUnit.SECONDS.sleep(5);
//        }

        Map<String, String> map = new HashMap<String, String>();

        map.put("s", "s");
        map.put("b", "b");



    }
}
