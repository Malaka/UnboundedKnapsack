package com.au.anz.algo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UnboundedKnapsack {

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
        System.out.println(problemData);
    }

    private static ProblemData buildProblem(String firstLine, String secondLine) {

        Iterator<String> first = Arrays.stream(firstLine.split(" ")).collect(Collectors.toList()).iterator();
        Integer elementCount = Integer.valueOf(first.next());
        Integer target = Integer.valueOf(first.next());
        List<Integer> elements = Arrays.stream(secondLine.split(" ")).map(Integer::valueOf).collect(Collectors.toList());

        return ProblemData.builder()
                .valid(elements.size() == elementCount)
                .target(target)
                .elements(new HashSet<>(elements))
                .build();

    }
}
