package main.gfg.easy;

import lib.io.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Given an array of integers, find a combination of four elements in the array
 * whose sum is equal to a given value X.
 *
 * @link https://practice.geeksforgeeks.org/problems/four-elements/0
 * @company OYORooms
 * @company Amazon
 */
public class FourElements {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int sum = in.nextInt();
        ArrayList<FourElements.Node> sumList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                sumList.add(new Node(arr[i] + arr[j], i, j));
            }
        }
        sumList.sort(Comparator.comparingInt(a -> a.val));
        int l = 0;
        int h = sumList.size() - 1;
        TreeSet<ArrayList<Integer>> foundSet = new TreeSet<>((a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) < b.get(i)) {
                    return -1;
                } else if (a.get(i) > b.get(i)) {
                    return 1;
                }
            }
            return 0;
        });
        while (l <= h) {
            Node lNode = sumList.get(l);
            Node hNode = sumList.get(h);
            int curSum = lNode.val + hNode.val;
            if (curSum == sum
                    && lNode.x != hNode.x && lNode.x != hNode.y
                    && lNode.y != hNode.x && lNode.y != hNode.y) {
                ArrayList<Integer> found = new ArrayList<>(4);
                found.add(arr[lNode.x]);
                found.add(arr[lNode.y]);
                found.add(arr[hNode.x]);
                found.add(arr[hNode.y]);
                found.sort(Comparator.comparingInt(a -> a));
                foundSet.add(found);
            }
            if (curSum >= sum) {
                h--;
            } else {
                l++;
            }
        }
        if (foundSet.isEmpty()) {
            out.print("0");
        } else {
            out.print("1");
        }
        out.println();
    }

    class Node {
        int val;
        int x;
        int y;

        public Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
}
