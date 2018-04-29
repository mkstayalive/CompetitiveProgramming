package main.gfg.easy;

import lib.io.InputReader;

import java.io.PrintWriter;

/**
 * Given an array of N elements, you are required to find the maximum sum of lengths of
 * all non-overlapping subarrays with K as the maximum element in the subarray.
 *
 * @link https://practice.geeksforgeeks.org/problems/sum-of-lengths-of-non-overlapping-subarrays/0
 * @company Amazon
 * @author Manish Singh
 */
public class NonOverlappingSubarrayWithMax {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();
        Integer start = null, end = null;
        int res = 0, curMax = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            if (i < n && arr[i] <= k) {
                if (start == null) start = i;
                curMax = Math.max(curMax, arr[i]);
            } else if (start != null) {
                end = i;
                if (start != null && curMax == k) {
                    res += end - start;
                }
                start = null;
                curMax = Integer.MIN_VALUE;
            }
        }
        out.println(res);
    }
}
