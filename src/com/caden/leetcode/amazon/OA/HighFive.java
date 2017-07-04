package com.caden.leetcode.amazon.OA;

import java.util.*;

/**
 * 给你一个Result类，其中id代表学生，value代表他的分数，也就是说id相同，value可以很多个，表示一个学生有很多分数
 * 现在让你求每个学生的top 5的分数的平均值。放入到一个HashMap<Integer, Double>里返回，key为学生id，value为top 5的平均数
 *
 * 假设每个学生至少有5个分数
 */
class Result {
    int id;
    int value;
    public Result(int id, int value) {
        this.id = id;
        this.value = value;
    }
}
public class HighFive {
    public static void main(String[] args) {
        SolutionHighFive s = new SolutionHighFive();
        Result r1 = new Result(1, 95);
        Result r2 = new Result(1, 95);
        Result r3 = new Result(1, 91);
        Result r4 = new Result(1, 91);
        Result r5 = new Result(1, 93);
        Result r6 = new Result(1, 105);
        Result r17 = new Result(1, 101);
        Result r16 = new Result(1, 99);

        Result r7 = new Result(2, 6);
        Result r8 = new Result(2, 6);
        Result r9 = new Result(2, 7);
        Result r10 = new Result(2, 6);
        Result r11 = new Result(2, 6);
        Result[] arr = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r17, r16};
        Map<Integer, Double> res = s.getHighFiveII(arr);

        System.out.println(res.get(1) + " " +res.get(2));
    }
}

class SolutionHighFive {
    //pq解法
    public Map<Integer, Double> getHighFiveII(Result[] res) {
        if (res == null || res.length == 0) return new HashMap<>();
        Map<Integer, Double> ret = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < res.length; i++) {
            int id = res[i].id;
            int val = res[i].value;
            if (!map.containsKey(id)) {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.offer(val);
                map.put(id, pq);
            } else {
                PriorityQueue<Integer> pq = map.get(id);
                if (pq.size() < 5) {
                    pq.offer(val);
                    map.put(id, pq);
                } else {
                    if (val > pq.peek()) {
                        pq.poll();
                        pq.offer(val);
                        map.put(id, pq);
                    }
                }
            }
        }

        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Integer> pq = entry.getValue();
            double sum = 0;
            while (!pq.isEmpty()) {
                sum += pq.poll();
            }
            ret.put(id, sum / 5);
        }
        return ret;
    }

    //倪敏解法 用List，复杂度较高
    public Map<Integer, Double> getHighFive(Result[] results) {
        if (results == null || results.length == 0) return new HashMap<>();

        Map<Integer, Double> res = new HashMap<>();
        Map<Integer, List<Integer>> students = new HashMap<>();

        for (Result result : results) {
            int id = result.id;
            int value = result.value;
            if (students.containsKey(id)) {
                students.get(id).add(value);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(value);
                students.put(id, list);
            }
        }

        for (Integer id : students.keySet()) {
            List<Integer> values = students.get(id);

            Collections.sort(values, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            double avg = 0;
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += values.get(i);
            }
            avg = sum / 5.0;

            res.put(id, avg);
        }
        return res;

    }
}