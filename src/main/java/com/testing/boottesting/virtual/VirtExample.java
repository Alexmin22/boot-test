//package com.testing.boottesting.virtual;
//
//public class VirtExample {
//    public static void main(String[] args) throws Exception {
//        Thread thread = Thread.ofVirtual().name("MyThread").start(() -> System.out.println("Hello " + Thread.currentThread().getName()));
//        thread.join();
//        System.out.println("-----------------------------");
//
//        Thread.Builder builder = Thread.ofVirtual().name("worker-", 0);
//        Runnable task = () -> {
//            System.out.println("Thread ID: " + Thread.currentThread().threadId());
//        };
//
//// name "worker-0"
//        Thread t1 = builder.start(task);
//        t1.join();
//        System.out.println(t1.getName() + " terminated");
//
//// name "worker-1"
//        Thread t2 = builder.start(task);
//        t2.join();
//        System.out.println(t2.getName() + " terminated");
//
//        System.out.println("-----------------------------");
//
//        for (int i = 0; i < 20; i++) {
//            int finalI = i;
//            Thread thread1 = Thread.startVirtualThread(() -> {
//                System.out.println("Virtual Thread " + (finalI + 1) + ": " + Thread.currentThread());
//            });
//            thread1.join();
//        }
//    }
//}
