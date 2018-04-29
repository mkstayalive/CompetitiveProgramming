package lib.utils.maths;

/**
 * @author Manish Singh
 */
public class PermutationUtils {

    public long npr(int n, int r) {
        if (n < r) {
            return 0;
        }
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res *= n - r + i;
        }
        return res;
    }
}
