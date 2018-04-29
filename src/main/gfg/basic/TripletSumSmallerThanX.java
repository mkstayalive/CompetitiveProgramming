package main.gfg.basic;

import lib.io.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Given an array of distinct integers and a sum value.
 * Find count of triplets with sum smaller than given sum value.
 *
 * @link https://practice.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x/0
 * @company Amazon
 */
public class TripletSumSmallerThanX {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int sum = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int count = 0;
        outer:
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int h = n - 1;
            int sumRequired = sum - arr[i];
            while (l < h) {
                int curSum = arr[l] + arr[h];
                if (curSum < sumRequired) {
                    count += h - l;
                }
                if (curSum >= sumRequired) {
                    h--;
                } else {
                    l++;
                }
            }
        }
        out.println(count);
    }
}

