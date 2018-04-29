package main.gfg.easy;

import lib.io.InputReader;
import java.io.PrintWriter;

/**
 * Geek has an array Arr, where Arr[i] (1-based indexing) denotes the number of chocolates
 * corresponding to each station. When he move from station i to station i+1 he get A[i] – A[i+1] chocolates for free,
 * if this number is negative, he looses that many chocolates also.
 * He can only move from station i to station i+1, if he has non-negative number of chocolates with him.
 * Given the cost of one chocolate is Rs. P, help geek to find the minimum cost incurred in
 * reaching last station from the first station (station 1).
 * Note: Initially Geek has 0 chocolate.
 *
 * @link https://practice.geeksforgeeks.org/problems/chocolate-station/0
 * @company Amazon
 * @author Manish Singh
 */
public class ChocolateStation {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int p = in.nextInt();
        int cost = arr[0];
        int bag = 0;
        for (int i = 1; i < n; i++) {
            int free = arr[i - 1] - arr[i];
            if (free >= 0) {
                bag += free;
                continue;
            } else {
                int curCost = -free;
                if (bag >= curCost) {
                    bag -= curCost;
                } else {
                    cost += (curCost - bag);
                    bag = 0;
                }
            }
        }
        out.println(cost * p);
    }
}
