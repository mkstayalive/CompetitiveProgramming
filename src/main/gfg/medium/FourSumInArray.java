package main.gfg.medium;

import lib.io.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Given an array A of size N, find all combination of four elements in the array
 * whose sum is equal to a given value K.
 *
 * @link https://practice.geeksforgeeks.org/problems/find-all-four-sum-numbers/0
 * @company Microsoft
 * @company Google
 * @company Amazon
 */
public class FourSumInArray {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int sum = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        TreeSet<ArrayList<Integer>> foundSet = new TreeSet<>((a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) < b.get(i)) {
                    return -1;
                } else if (a.get(i) > b.get(i)) {
                    return 1;
                }
            }
            return 0;
        });
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int l = k;
                    int h = n - 1;
                    int reqSum = sum - (arr[i] + arr[j]);
                    while (l < h) {
                        int curSum = arr[l] + arr[h];
                        if (curSum == reqSum) {
                            ArrayList<Integer> found = new ArrayList<>();
                            found.add(arr[i]);
                            found.add(arr[j]);
                            found.add(arr[l]);
                            found.add(arr[h]);
                            found.sort(Comparator.comparingInt(x -> x));
                            foundSet.add(found);
                        }
                        if (curSum >= reqSum) {
                            h--;
                        } else {
                            l++;
                        }
                    }
                }
            }
        }
        if (foundSet.isEmpty()) {
            out.println("-1");
            return;
        }
        for (ArrayList<Integer> quad : foundSet) {
            for (int x : quad) {
                out.print(x + " ");
            }
            out.print("$");
        }
        out.println();
    }
}
