package day06;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Day06Thread {
    
    static List<Integer> numList = new LinkedList<>();
    static ExecutorService threadpool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        for (Integer i =0; i<3; i++) {
            // Create a thread
            RandomNumbers thr = new RandomNumbers("thr-"+(i), 100, numList);
            // Schedule a thread to the runnable

            // this is just a method call
            // thr.run();

            // schedule a thread to runnable
            threadpool.submit(thr);
        }
        
        System.out.println("All done");
        while (true) {
                System.out.println(">>> numlist: " + numList + ", size: " + numList.size());
            try {
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}