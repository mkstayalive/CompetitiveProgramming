package main.gfg;

import lib.io.InputReader;

import java.io.PrintWriter;

/**
 * @link https://practice.geeksforgeeks.org/problems/maximum-product-subarray/0
 */
public class MaxProductSubarray2 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        Long arr[] = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        long res = arr[0];
        Long curMax = 0L;
        Long curMin = 0L;
        for (int i = 0; i < n; i++) {
            Long prevMin = curMin;
            Long prevMax = curMax;
            if (arr[i] > 0) {
                curMax = Math.max(arr[i], prevMax * arr[i]);
                curMin = Math.min(arr[i], prevMin * arr[i]);
            } else {
                curMax = Math.max(arr[i], prevMin * arr[i]);
                curMin = Math.min(arr[i], prevMax * arr[i]);
            }
            System.err.println(arr[i] + ": " + curMin + ", " + curMax);
            res = Math.max(res, curMax);
        }
        out.println(res);
    }
}
