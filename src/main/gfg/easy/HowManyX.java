package main.gfg.easy;

import lib.io.InputReader;

import java.io.PrintWriter;

public class HowManyX {
    int[][] count;

    public HowManyX() {
        count = new int[10][100005];
        count[0][0] = 1;
        for (int i = 1; i < count[0].length; i++) {
            int num = i;
            while (num > 0) {
                int dig = num % 10;
                count[dig][i]++;
                num /= 10;
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < count[0].length; j++) {
                count[i][j] += count[i][j - 1];
            }
        }
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int digit = in.nextInt();
        int l = in.nextInt();
        int u = in.nextInt();
        u--; l++;
        out.println(count[digit][u] - count[digit][l - 1]);
    }
}
