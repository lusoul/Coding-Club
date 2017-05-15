package com.caden.leetcode.amazon.OA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 第一行包含两个整数 N和 M。
 接下来 M行，每行包含3个整数 a, b 和 k。
 列表中的数位置编号为从1到 N。

 输出格式

 单独的一行包含 最终列表里的最大值
 约束条件

 3 <= N <= 10^7
 1 <= M <= 2*10^5
 1 <= a <= b <= N
 0 <= k <= 10^9
 输入样例 #00:
 5 3
 1 2 100
 2 5 100
 3 4 100

 输出样例 #00:
 200

 解释:
 第一次更新后，列表变为 100 100 0 0 0，
 第二次更新后，列表变为 100 200 100 100 100。
 第三次更新后，列表变为 100 200 200 200 100。
 因此要求的答案是200。
 */
public class AlgorithmCrush {
    public static void main(String[] args) {
        String[] operations = {"1 3 100", "2 6 200", "3 5 100", "6 8 100", "5 8 100", "2 5 200"};
        SolutionAlgorithmCrush s = new SolutionAlgorithmCrush();
        System.out.println(s.maValue(operations));
    }
}

class SolutionAlgorithmCrush {
    class Point {
        int idx;
        boolean start;
        int sum;
        public Point(int idx, boolean start, int sum) {
            this.idx = idx;
            this.start = start;
            this.sum = sum;
        }
    }

    public int maValue(String[] operations) {
        List<Point> points = new ArrayList<>();
        for (String operation : operations) {
            String[] opers = operation.split(" ");
            Point point1 = new Point(Integer.valueOf(opers[0]), true, Integer.valueOf(opers[2]));
            Point point2 = new Point(Integer.valueOf(opers[1]), false, Integer.valueOf(opers[2]));
            points.add(point1);
            points.add(point2);
        }

        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.idx == p2.idx) {
                    if (p1.start && !p2.start) return -1;
                    else if (!p1.start && p2.start) return 1;
                    else return 0;
                }
                return p1.idx - p2.idx;
            }
        });
        int max = Integer.MIN_VALUE, count = 0;
        for (Point point : points) {
            if (point.start) {
                count += point.sum;
            } else {
                count -= point.sum;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}

