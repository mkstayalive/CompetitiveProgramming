package main.gfg.easy;

import lib.io.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Given an array A[] of n numbers and another number x,
 * determine whether or not there exist two elements in A whose sum is exactly x.
 * @link https://practice.geeksforgeeks.org/problems/key-pair/0
 * @company Microsoft
 * @company Flipkart
 * @company CarWale
 * @company Amazon
 */
public class KeyPair {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int sum = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int l = 0, h = n - 1;
        boolean found = false;
        while (l <= h) {
            int curSum = arr[l] + arr[h];
            if (curSum == sum) {
                found = true;
                break;
            }
            if (curSum >= sum) {
                h--;
            } else {
                l++;
            }
        }
        if (found) {
            out.println("Yes");
        } else {
            out.println("No");
        }
    }
}
