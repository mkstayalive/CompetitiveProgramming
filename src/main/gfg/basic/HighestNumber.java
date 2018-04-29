package main.gfg.basic;

import lib.io.InputReader;
import java.io.PrintWriter;

/**
 * Given an array in such a way that the elements stored in array are in increasing order
 * initially and then after reaching to a peak element , elements stored are in decreasing order.
 * Find the highest element.
 *
 * @link https://practice.geeksforgeeks.org/problems/find-the-highest-number/0
 * @company Amazon
 */
public class HighestNumber {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        out.println(findLargest(arr));
    }

    private int findLargest(int[] arr) {
        int l = 0, h = arr.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            } else if (arr[mid] > arr[mid - 1]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }
}
