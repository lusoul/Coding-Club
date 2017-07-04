package com.caden.leetcode.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * 多个矩阵重合，找重合最多的点坐标
 */
public class MostRectanglePoints {
    public static void main(String[] args) {
        SolutionMostRectanglePoints s = new SolutionMostRectanglePoints();
        Rec r1 = new Rec(0,0,2,2);Rec r2 = new Rec(2,3,5,6);
        Rec r3 = new Rec(1,1,4,4);Rec r4 = new Rec(3,0,6,5);
        Rec r5 = new Rec(-1,-1,1,1);
        Rec[] recs = new Rec[5];
        recs[0] = r1;recs[1] = r2;recs[2] = r3;recs[3] = r4;recs[4]=r5;
        List<int[]> ret = s.getPoints(recs);
        for (int[] r : ret) {
            System.out.println(r[0] + " " + r[1]);
        }
    }
}
class Rec {
    int startX, startY, endX, endY;//sX,sY代表起点坐标（左下角）,eX,eY代表终点坐标（右上角）
    public Rec(int sX, int sY, int eX, int eY) {
        this.startX = sX;
        this.startY = sY;
        this.endX = eX;
        this.endY = eY;
    }
}
class SolutionMostRectanglePoints {
//    class Rec {
//        int startX, startY, endX, endY;//sX,sY代表起点坐标（左下角）,eX,eY代表终点坐标（右上角）
//        public Rec(int sX, int sY, int eX, int eY) {
//            this.startX = sX;
//            this.startY = sY;
//            this.endX = eX;
//            this.endY = eY;
//        }
//    }
    //求重合最多的坐标点
    public List<int[]> getPoints(Rec[] recs) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        List<int[]> ret = new ArrayList<>();
        //找到坐标点的最小边界和最大边界
        for (Rec rec : recs) {
            minX = Math.min(minX, rec.startX);
            minY = Math.min(minY, rec.startY);
            maxX = Math.max(maxX, rec.endX);
            maxY = Math.max(maxY, rec.endY);
        }
        //开始遍历所有点找到结果
        int maxCount = 0;
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                int count = 0;
                for (Rec rec : recs) {
                    if (x >= rec.startX && x <= rec.endX && y <= rec.endY && y >= rec.startY) {
                        count++;
                        if (count > maxCount) {//说明原ret中存放的不是重合最多的坐标点，需要清除
                            ret.clear(); //清除ret中不是最多重合的坐标点
                            maxCount = count;
                            ret.add(new int[]{x, y});
                        } else if (count == maxCount) {
                            ret.add(new int[]{x, y});
                        }
                    }
                }
            }
        }
        return ret;
    }
}


