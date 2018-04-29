package main.gfg.easy;

import lib.io.InputReader;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two strings a and b print whether they contain any common subsequence (non empty) or not.
 *
 * @link https://practice.geeksforgeeks.org/problems/common-subsequence/0
 * @company Amazon
 * @author Manish Singh
 */
public class CommonSubsequenceChar {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String a = in.next();
        String b = in.next();
        Set<Character> setA = new HashSet<>();
        for (char ch : a.toCharArray()) {
            setA.add(a.charAt(ch));
        }
        int res = 0;
        for (char ch : b.toCharArray()) {
            if (setA.contains(ch)) {
                res = 1;
                break;
            }
        }
        out.println(res);
    }
}
