package lib.algo.bits;

/**
 * @author Manish Singh
 */
public class BitManip {

    public static String numberToBinary(long x) {
        if (x < 0) throw new IllegalArgumentException();
        StringBuilder sb = new StringBuilder("");
        while (x > 0) {
            if (x % 2 == 0) {
                sb.append("0");
            } else {
                sb.append("1");
            }
            x >>= 1;
        }
        return sb.reverse().toString();
    }

    public static int countBits(long x) {
        int count = 0;
        while (x > 0) {
            count++;
            x >>= 1;
        }
        return count;
    }

    public static int countSetBits(long x) {
        int count = 0;
        while (x > 0) {
            count++;
            x = x & (x - 1);
        }
        return count;
    }

    public static boolean isPow2(long x) {
        return x != 0 && (x & (x - 1)) == 0;
    }

    public static long getLsb(long x) {
        return x & -x;
    }

    public static long unsetLsb(long x) {
        return x & (x - 1);
    }

    public static int alphaMap(char s[]) {
        int n = 0;
        for (int i = 0; s[i] != 0; i++) {
            n |= (1 << (s[i] - 'a'));
        }
        return n;
    }
}
