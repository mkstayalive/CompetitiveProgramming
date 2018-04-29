package lib.utils.maths;

/**
 * @author Manish Singh
 */
public class CombinationUtils {
    public static long ncr(int n, int r) {
        if (n < r) {
            return 0;
        }
        if (r > n / 2) {
            r = n - r;
        }
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res *= n - r + i;
            res /= i;
        }
        return res;
    }
}
