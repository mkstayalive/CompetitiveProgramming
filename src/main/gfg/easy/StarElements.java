package main.gfg.easy;

import lib.io.InputReader;
import lib.utils.io.PrintUtils;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an unsorted array. The task is to find all the star and super star elements in the array.
 * Star are those elements which are strictly greater than all the elements on its right side.
 * Super star are those elements which are strictly greater than all the elements on its left and right side.
 *
 * @link https://practice.geeksforgeeks.org/problems/start-elements/0
 * @author Manish Singh
 */
public class StarElements {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int right[] = new int[n];
        int left[] = new int[n];
        right[n - 1] = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i + 1], right[i + 1]);
        }
        left[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(arr[i - 1], left[i - 1]);
        }
        List<Integer> stars = new LinkedList<>();
        List<Integer> superStars = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] > right[i]) {
                stars.add(arr[i]);
                if (arr[i] > left[i]) {
                    superStars.add(arr[i]);
                }
            }
        }
        PrintUtils.print(out, stars);
        if (superStars.isEmpty()) {
            out.println(-1);
        } else {
            PrintUtils.print(out, superStars);
        }
    }
}
