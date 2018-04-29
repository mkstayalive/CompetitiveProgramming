package main.gfg.easy;

import lib.io.InputReader;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given an array of distinct integers,
 * print all the pairs having positive value and negative value of a number
 * that exists in the array.
 *
 * @link https://practice.geeksforgeeks.org/problems/pairs-with-positive-negative-values/0
 * @company Amazon
 * @author Manish Singh
 */
public class PairPosNeg {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int arr[] = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        Set<Integer> otherSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            if (arr[i] > 0) {
                set.add(arr[i]);
            } else {
                otherSet.add(arr[i]);
            }
        }
        boolean ok = false;
        for (int item : set) {
            if (otherSet.contains(-item)) {
                out.print(-item + " " + item + " ");
                ok = true;
            }
        }
        if (!ok) {
            out.print(0);
        }
        out.println();
    }
}
