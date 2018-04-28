package main.gfg.medium;

import lib.io.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Given an array A[] of n numbers and another number x,
 * determine whether or not there exist three elements in A[] whose sum is exactly x.
 *
 * @link https://practice.geeksforgeeks.org/problems/triplet-sum-in-array/0
 * @company Samsung
 * @company CarWale
 * @company Accolite
 * @company Amazon
 */
public class TripletSumInArray {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int sum = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        boolean found = false;
        outer:
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int h = n - 1;
            int sumRequired = sum - arr[i];
            while (l < h) {
                int curSum = arr[l] + arr[h];
                if (curSum == sumRequired) {
                    found = true;
                    break outer;
                }
                if (curSum >= sumRequired) {
                    h--;
                } else {
                    l++;
                }
            }
        }
        if (found) {
            out.println("1");
        } else {
            out.println("0");
        }
    }
}
