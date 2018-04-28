package main.leetcode;

import lib.io.InputReader;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

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
