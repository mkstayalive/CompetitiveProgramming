package main.leetcode;

import lib.io.InputReader;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * You're given strings J representing the types of stones that are jewels,
 * and S representing the stones you have. Each character in S is a type of stone
 * you have. You want to know how many of the stones you have are also jewels.
 * @link https://leetcode.com/problems/jewels-and-stones/description/
 */
public class Task771 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String j = in.next();
        String s = in.next();
        out.println(numJewelsInStones(j, s));
    }

    public int numJewelsInStones(String j, String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < j.length(); i++) {
            set.add(j.charAt(i));
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                res++;
            }
        }
        return res;
    }
}
