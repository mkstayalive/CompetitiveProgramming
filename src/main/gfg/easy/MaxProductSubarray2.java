package main.gfg.easy;

import lib.io.InputReader;
import java.io.PrintWriter;

/**
 * Given an array that contains both positive and negative integers,
 * find the product of the maximum product subarray.
 *
 * @link https://practice.geeksforgeeks.org/problems/maximum-product-subarray/0
 * @company Morgan-Stanley
 * @company Microsoft
 * @company Amazon
 */
public class MaxProductSubarray2 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        long res = arr[0];
        long fullProduct = 1;
        int negCount = 0;
        int firstNeg = 0;
        int lastNeg = 0;
        int subStart = 0;
        for (int i = 0; i <= n; i++) {
            if (i == n || arr[i] == 0) {
                if (negCount % 2 == 0) {
                    res = Math.max(res, fullProduct);
                } else {
                    long leftProduct = 1;
                    long rightProduct = 1;
                    long midProduct = 1;
                    for (int j = subStart; j <= firstNeg; j++) {
                        leftProduct *= arr[j];
                    }
                    for (int j = firstNeg + 1; j < lastNeg; j++) {
                        midProduct *= arr[j];
                    }
                    for (int j = lastNeg; j < i; j++) {
                        rightProduct *= arr[j];
                    }
                    if (midProduct == 1) {
                        midProduct = -1;
                    }
                    if (negCount == 1) {
                        if (i == subStart + 1) {
                            res = Math.max(res, arr[firstNeg]);
                        } else {
                            res = Math.max(res, Math.max(leftProduct / arr[firstNeg], rightProduct / arr[firstNeg]));
                        }
                    } else {
                        res = Math.max(res, Math.max(leftProduct * midProduct, midProduct * rightProduct));
                    }
                }
                fullProduct = 1;
                subStart = i + 1;
                negCount = 0;
                continue;
            }
            fullProduct *= arr[i];
            if (arr[i] < 0) {
                negCount++;
                if (negCount == 1) {
                    firstNeg = i;
                    lastNeg = i;
                } else {
                    lastNeg = i;
                }
            }
        }
        out.println(res);
    }
}
