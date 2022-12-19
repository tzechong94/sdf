package day07;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class IntList {

    public static void main(String[] args) {

        Integer max = 200;
        Integer range = 100;

        Random rnd = new SecureRandom();

        List<Integer> numList = new LinkedList<>();

        for (Integer i = 0; i < max; i++) {
            numList.add(rnd.nextInt(range));
        }

        System.out.println(">>> numList: " + numList);

        filter(numList);
        reducing(numList);
        reducing2(numList);
        // filter
    }

    public static void filter(List<Integer> numList) {
        System.out.println("========= FILTER ==========");
        List<Integer> resultList = new LinkedList<>();
        for (Integer n : numList) {
            if (0 != (n % 3)) {
                continue;
            }
            resultList.add(n);
        }
        
        System.out.println("Result List from for loop: " + resultList);

        // Optional<String> opt = numList.stream()
        //     .map(n -> "%d%d".formatted(n,n))
        //     // map; String apply(String i)
        //     .map(Integer::parseInt)
        //     .collect(
        //         Collectors.reducing((total, i) -> {
        //             System.out.printf("total %d, i: %d\n", total, i);
        //             return total + i;
        //         })
        //     );

        // System.out.println(opt.get());;

    }

    public static void reducing (List<Integer> numList) {

        System.out.println("============== REDUCING ==============");

        Optional<Integer> opt = numList.stream()
            //map: String apply(Integer i)
            .map(n -> "%d%d".formatted(n,n))
            //.map(Convert to Integer)
            .map(Integer::parseInt)
            .collect(
                //Integer apply (Integer total, Integer i)
                Collectors.reducing((total, i) -> {
                    System.out.printf("total: %d, i: %d\n", total, i);
                    return total + i;
                })
            );
            //check if we have any answer
            if (opt.isPresent())
             //Getting the answer
            System.out.println(">>> total: "+ opt.get());
            else
            System.out.println("Reducing produces no result");
    }

    public static void reducing2(List<Integer> numList) {
        System.out.println("JOINING");

        Integer result = numList.stream()
            .map(n -> "%d%d".formatted(n,n))
            .map(Integer::parseInt)
            .collect(
                Collectors.reducing(
                    0 , (total, i) -> {
                        System.out.printf("total: %d, i: %d\n", total, i);
                        return total + i;
                    }
                )
            );
    }

}
            // .filter(num -> ((num % 3) == 0))
            // .distinct()
            // .sorted()
            // .limit(5)
            // .toList();
