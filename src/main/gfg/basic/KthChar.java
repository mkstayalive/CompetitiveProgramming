package main.gfg.basic;

import lib.algo.bits.BitManip;
import lib.io.InputReader;
import java.io.PrintWriter;

/**
 * Given a decimal number m. Convert it in binary string and apply n iterations,
 * in each iteration 0 becomes 01 and 1 becomes 10.
 * Find kth character in the string after nth iteration.
 *
 * @link https://practice.geeksforgeeks.org/problems/find-k-th-character-in-string/0
 * @company Amazon
 */
public class KthChar {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int num = in.nextInt();
        int k = in.nextInt();
        int n = in.nextInt();
        String binary = BitManip.numberToBinary(num);
        for (int i = 0; i < n; i++) {
            binary = transform(binary);
        }
        out.println(binary.charAt(k));
    }

    public String transform(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                sb.append("01");
            } else {
                sb.append("10");
            }
        }
        return sb.toString();
    }
}
