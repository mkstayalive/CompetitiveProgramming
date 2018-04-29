package main.gfg.easy;

import lib.io.InputReader;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Given N numbers in an array. Your task is to keep at-most K numbers at the top
 * (According to their frequency).  We basically need to print top k numbers when
 * input stream has included k distinct elements, else need to print all distinct
 * elements sorted by frequency.
 * See the Example and its explanation to make problem statement more clear.
 *
 * @link https://practice.geeksforgeeks.org/problems/top-k-numbers/0
 * @company Amazon
 * @author Manish Singh
 */
public class TopKInStream {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        TreeSet<Node> set = new TreeSet<>((x, y) -> {
            int cmp = y.frequency - x.frequency;
            if (cmp != 0) return cmp;
            return x.num - y.num;
        });
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Node prevVal, newVal;
            if (countMap.containsKey(arr[i])) {
                int prev = countMap.get(arr[i]);
                prevVal = new Node(arr[i], prev);
                set.remove(prevVal);
                countMap.put(arr[i], prev + 1);
            } else {
                countMap.put(arr[i], 1);
            }
            newVal = new Node(arr[i], countMap.get(arr[i]));
            set.add(newVal);
            int j = 0;
            for (Node x : set) {
                out.print(x.num + " ");
                if (++j == k) break;
            }
        }
        out.println();
    }

    static class Node {
        int num;
        int frequency;

        public Node(int num, int frequency) {
            this.num = num;
            this.frequency = frequency;
        }
    }
}
