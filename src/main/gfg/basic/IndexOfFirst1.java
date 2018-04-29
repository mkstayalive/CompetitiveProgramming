package main.gfg.basic;

import lib.utils.search.BinarySearchUtils;
import lib.io.InputReader;
import java.io.PrintWriter;

/**
 * Given a sorted array consisting 0’s and 1’s.
 * The task is to find the index of first ‘1’ in the sorted array.
 *
 * @link https://practice.geeksforgeeks.org/problems/index-of-first-1-in-a-sorted-array-of-0s-and-1s/0
 * @company Amazon
 */
public class IndexOfFirst1 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int pos = BinarySearchUtils.lowerBound(arr, 1);
        if (pos == arr.length) {
            out.println("-1");
        } else {
            out.println(pos);
        }
    }
}
