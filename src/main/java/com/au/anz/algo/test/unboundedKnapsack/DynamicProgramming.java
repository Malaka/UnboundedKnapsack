package com.au.anz.algo.test.unboundedKnapsack;

public class DynamicProgramming implements Algo {

    public Integer knapsackValue(Integer[] elements, Integer target) {

        // bottom up solution store
        Integer[] knapsack = new Integer[target + 1];
        knapsack[0] = 0; // base cse

        /*
         * Reduce problem
         * Find the knapsackValue for each element where target => (target - element[i])
         * Time Complexity O(target * elements )
         * Space Complexity O(target * elements )
         */
        for (int capacity = 1; capacity <= target; capacity++) {
            Integer[] subSolutions = new Integer[elements.length];
            for (int i = 0; i < elements.length; i++) {
                if (capacity >= elements[i]) {
                    // get the previous knapsack value from the solution array
                    subSolutions[i] = elements[i] + knapsack[capacity - elements[i]];
                } else {
                    subSolutions[i] = 0;
                }
            }
            // building the solution store
            knapsack[capacity] = subSolutions[0];
            for (int i = 0; i < elements.length; i++) {
                if (subSolutions[i] > knapsack[capacity]) {
                    knapsack[capacity] = subSolutions[i];
                }
            }
        }

        return knapsack[target];
    }
}
