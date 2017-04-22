package com.caden.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lusoul on 2017/3/29.
 */
public class Test7 {
    public static int lenghtOfLongestAP(int set[])
    {
        int n = set.length;
        int[][] F = new int[set.length][set.length];
        int llap = 2;  // Initialize the result
        for (int i = 0; i < set.length; i++)
            F[i][n-1] = 2;

        for (int j=n-2; j>=1; j--)
        {
            int i = j-1, k = j+1;
            while (i >= 0 && k <= n-1)
            {
                if (set[i] + set[k] < 2*set[j])
                    k++;
                else if (set[i] + set[k] > 2*set[j])
                {   F[i][j] = 2;
                    i--;
                }

                else
                {
                    F[i][j] = F[j][k] + 1;
                    llap = Math.max(llap, F[i][j]);
                    i--; k++;
                }
            }
            while (i >= 0)
            {
                F[i][j] = 2;
                i--;
            }
        }
        return llap;
    }

    public static void main(String[] args) {
        int[] A = {0, 5, 8, 10, 12, 15};
        System.out.println(lenghtOfLongestAP(A));

    }
}
class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}


