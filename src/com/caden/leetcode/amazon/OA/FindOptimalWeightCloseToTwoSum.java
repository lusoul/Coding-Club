package com.caden.leetcode.amazon.OA;

import java.util.Arrays;

public class FindOptimalWeightCloseToTwoSum {
    public static void main(String[] args) {
        double capacity = 35;
        double[] weights = {10,24,30,9,19,23,7};
        SolutionFindOptimalWeightCloseToTwoSum s = new SolutionFindOptimalWeightCloseToTwoSum();

        SolutionFindOptimalWeightCloseToTwoSum.Container container = s.findOptimalWeights(capacity,weights,weights.length);

        System.out.println(container.first);
        System.out.println(container.second);
    }
}

class SolutionFindOptimalWeightCloseToTwoSum {
    public Container findOptimalWeights(double capacity, double[] weights, int numOfContainers) {
        if (weights == null || weights.length == 0) return null;
        Arrays.sort(weights);
        int start = 0, end = weights.length - 1, first = 0, second = 0;
        double diff = Double.MAX_VALUE;
        while (start < end) {
            if (weights[start] + weights[end] == capacity) {
                Container c = new Container(weights[start], weights[end]);
                return c;
            } else if (weights[start] + weights[end] > capacity) {
                end--;
            } else {
                if (capacity - (weights[start] + weights[end]) < diff) {
                    diff = capacity - (weights[start] + weights[end]);
                    first = start;
                    second = end;
                }
                start++;
            }
        }
        return new Container(weights[first], weights[second]);
    }

    static class Container {
        public double first;
        public double second;

        public Container(double first, double second) {
            this.first = first;
            this.second = second;

        }
    }
}