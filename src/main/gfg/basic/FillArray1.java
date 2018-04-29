package main.gfg.basic;

import lib.io.InputReader;

import java.io.PrintWriter;

/**
 * Given an array of 0 and 1, in how many iterations the whole array be filled
 * with 1's if in a single iteration immediate neighbours of 1's can be filled.
 *
 * @author Manish Singh
 * @link https://practice.geeksforgeeks.org/problems/fill-array-by-1s/0
 */
public class FillArray1 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int curCount = 0;
        int res = 0;
        boolean first = true;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                curCount++;
            } else {
                if (first) {
                    first = false;
                    res = curCount;
                } else {
                    res = Math.max(res, (curCount + 1) / 2);
                }
                curCount = 0;
            }
        }
        res = Math.max(res, curCount);
        if (first) {
            out.println(-1);
        } else {
            out.println(res);
        }
    }
}
