package com.caden.leetcode.amazon.OA;

/**
 * // Overlap Rectangle
 // Rect 1: top-left(A, B), bottom-right(C, D)
 // Rect 2: top-left(E, F), bottom-right(G, H)

 给两个长方形的topLeft和bottomRight坐标, 判断这两个长方形是否重叠

 Rectangle Overlap。这题和leetcode 算相交面积的区别：它帮你定义好两个类，一个叫Point，
 一个叫Rectangle，Rectangle包括左上右下两个Point, Point包括x, y的值， 这种细节并不影响程序，总之一句判断直接通过了全部20多个case.
 */
public class OverlapRectangle {
}

class SolutionOverlapRectangle {
    public boolean overlap(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (C < E || A > G || D > F || B < H) return false;
        return true;
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = (D - B) * (C - A) + (H - F) * (G - E);
        if (C < E || A > G || D < F || B > H) return total;//没重合

        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);

        int overlap = (right - left) * (top - bottom);
        return total - overlap;
    }
}



