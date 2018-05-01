package main.gfg.easy;

import lib.io.InputReader;
import java.io.PrintWriter;

/**
 * Stickler is a thief and wants to loot money from a society of n houses placed in a line.
 * He is a weird person and follows a rule while looting the houses and according to the rule
 * he will never loot two consecutive houses. At the same time, he wants to maximize the
 * amount he loots. The thief knows which house has what amount of money but is unable to
 * find the maximum amount he can end up with.
 *
 * @link https://practice.geeksforgeeks.org/problems/stickler-theif/0
 * @author Manish Singh
 */
public class SticklerThief {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int dp[] = new int[n];
        dp[0] = arr[0];
        if (n > 1) dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        out.println(dp[n - 1]);
    }
}
