package main.gfg.easy;

import lib.algo.maths.Prime;
import lib.io.InputReader;
import lib.utils.bits.BitUtils;

import java.io.PrintWriter;

/**
 * Given two integers ‘L’ and ‘R’, write a program that finds the count
 * of numbers having prime number of set bits in their binary representation
 * in the range [L, R].
 *
 * @link https://practice.geeksforgeeks.org/problems/prime-number-of-set-bits/0
 * @company Amazon
 * @author Manish Singh
 */
public class PrimeSetBits {
    private final int N = (int) 1e5 + 5;
    Prime prime = new Prime(100);
    int[] arr = new int[N];

    public PrimeSetBits() {
        for (int i = 0; i < N; i++) {
            arr[i] = prime.isPrimeNumber(BitUtils.countSetBits(i)) ? 1 : 0;
        }
        for (int i = 1; i < N; i++) {
            arr[i] += arr[i - 1];
        }
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int l = in.nextInt();
        int h = in.nextInt();
        out.println(arr[h] - arr[l - 1]);
    }
}
