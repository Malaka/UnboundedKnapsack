package com.au.anz.algo.test;

import com.au.anz.algo.test.unboundedKnapsack.Algo;
import com.au.anz.algo.test.unboundedKnapsack.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TestRunner {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer problems = Integer.valueOf(scan.nextLine().trim());
        Integer count = 0;

        List<ProblemData> problemData = new ArrayList<>();

        while (scan.hasNext() && count < problems) {
            String firstLine = scan.nextLine();
            String secondLine = scan.nextLine();
            problemData.add(buildProblem(firstLine, secondLine));
            ++count;
        }

        // Change the algorithm here
        // Algo recursiveCalculate = new Recursive();
        Algo recursiveCalculate = new DynamicProgramming();

        problemData.stream().map(a -> recursiveCalculate.knapsackValue(a.getElements(), a.getTarget())).forEach(System.out::println);
    }

    private static ProblemData buildProblem(String firstLine, String secondLine) {

        Iterator<String> first = Arrays.stream(firstLine.split(" ")).parallel().collect(Collectors.toList()).iterator();
        Integer elementCount = Integer.valueOf(first.next());
        Integer target = Integer.valueOf(first.next());

        // remove duplicates
        Integer[] elements = Arrays.stream(secondLine.split(" ")).map(Integer::valueOf).distinct().toArray(Integer[]::new);

        return ProblemData.builder()
                .target(target)
                .elements(elements)
                .build();

    }
}
