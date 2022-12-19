package myapp;

import java.io.Console;

public class Todo {
    public static void main(String[] args) {
        Console cons = System.console();
        Integer count = 0;
    
        String[] tasks = new String[5];

        for (int i=0; i < tasks.length; i++) {
            String task = cons.readLine("enter task %d: ", (i + 1));
            tasks[i] = task;
        }

        while (count < tasks.length) {
            System.out.printf("Task %d: %s\n", count+1, tasks[count]);
            count++;
        }
        }
}
