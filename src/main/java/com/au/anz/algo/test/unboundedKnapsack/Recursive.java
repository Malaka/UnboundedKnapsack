package com.au.anz.algo.test.unboundedKnapsack;

public class Recursive implements Algo {

    public Integer knapsackValue(Integer[] elements, Integer target) {

        // base case if not capacity then knapsackValue = 0
        if (target.equals(0)) {
            return 0;
        }

        /*
         * Reduce problem
         * Find the knapsackValue for each element where target => (target - element[i])
         */
        Integer[] subSolutions = new Integer[elements.length];
        for (int i = 0; i < elements.length; i++) {
            if (target >= elements[i]) {
                subSolutions[i] = elements[i] + knapsackValue(elements, target - elements[i]);
            } else {
                subSolutions[i] = 0;
            }
        }

        /*
         * Find the max value out of each element
         */
        Integer result = subSolutions[0];
        for (int i = 0; i < elements.length; i++) {
            if (subSolutions[i] > result) {
                result = subSolutions[i];
            }
        }
        return result;
    }
}
