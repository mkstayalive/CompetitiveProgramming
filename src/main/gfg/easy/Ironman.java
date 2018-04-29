package main.gfg.easy;

import lib.algo.string.PalindromeUtils;
import lib.io.InputReader;
import java.io.PrintWriter;

/**
 * You are given a string containing the alphanumeric character.
 * Find whether the string is palindrome or not.
 * Consider alphabets and numbers only for palindrome check.
 * Ignore case, symbols and whitespaces.
 *
 * @link https://practice.geeksforgeeks.org/problems/save-ironman/0
 * @company Google
 * @company Amazon
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
