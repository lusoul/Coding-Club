package com.caden.leetcode.facebook;

import java.util.*;

/**
 * Find least number of intervals from A that can fully cover B
 For example:
 Given A=[[0,3],[3,4],[4,6],[2,7]] B=[0,6] return 2 since we can use
 [0,3] [2,7] to cover the B
 Given A=[[0,3],[4,7]] B=[0,6] return 0 since we cannot find any
 interval combination from A to cover the B
 */
public class FindCover {
    public static void main(String[] args) {
//        IntervalI i1 = new IntervalI(1,5);IntervalI i2 = new IntervalI(5,6);
//        IntervalI i3 = new IntervalI(5,6);IntervalI i4 = new IntervalI(1,5);
//        IntervalI find = new IntervalI(0, 6);
        IntervalI i1 = new IntervalI(0,4);IntervalI i2 = new IntervalI(2,8);
        IntervalI i3 = new IntervalI(9,11);IntervalI i4 = new IntervalI(11,13);
        IntervalI find = new IntervalI(1,1);
        List<IntervalI> list = new ArrayList<>();
        list.add(i1);list.add(i2);list.add(i3);list.add(i4);
        SolutionFindCover s = new SolutionFindCover();
        System.out.println(s.findCover(list, find));
    }
}
class IntervalI {
    int start, end;
    public IntervalI(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
class SolutionFindCover {
    public int findCover(List<IntervalI> inters, IntervalI inter) {
        int start = inter.start;
        int end = inter.end;
        Collections.sort(inters, new Comparator<IntervalI>() {
            @Override
            public int compare(IntervalI i1, IntervalI i2) {
                if (i1.start == i2.start) return i2.end - i1.end;
                return i1.start - i2.start;
            }
        });
        int count = 0;
        for (int i = 0; i < inters.size(); i++) {
            if (inters.get(i).start > start) break;
            if (inters.get(i).end <= start) continue;
            count++;
            if (start >= inters.get(i).start && end <= inters.get(i).end) return count;
            start = inters.get(i).end;
            if (start > end) break;
        }
        return 0;
    }
}
