package main.gfg.easy;

import lib.io.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author Manish Singh
 */
public class ContigiousRange {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        boolean ok = true;
        int prev = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > prev + 1) {
                ok = false;
                break;
            }
            prev = arr[i];
        }
        if (ok) {
            out.println("Yes");
        } else {
            out.println("No");
        }
    }
}
