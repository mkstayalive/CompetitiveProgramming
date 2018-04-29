package main.gfg.easy;

import lib.algo.string.PalindromeUtils;
import lib.io.InputReader;
import java.io.PrintWriter;

/**
 * @author Manish Singh
 */
public class Ironman {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s = in.nextLine();
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (PalindromeUtils.isPalindrome(s)) {
            out.println("YES");
        } else {
            out.println("NO");
        }
    }
}
