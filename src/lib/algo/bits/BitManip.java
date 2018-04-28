package lib.algo.bits;

/**
 * @author Manish Singh
 */
public class BitManip {

    int countBits(long x) {
        int count = 0;
        while (x > 0) {
            count++;
            x >>= 1;
        }
        return count;
    }

    int countSetBits(long x) {
        int count = 0;
        while (x > 0) {
            count++;
            x = x & (x - 1);
        }
        return count;
    }

    boolean isPow2(long x) {
        return x != 0 && (x & (x - 1)) == 0;
    }

    long getLsb(long x) {
        return x & -x;
    }

    long unsetLsb(long x) {
        return x & (x - 1);
    }

    int alphaMap(char s[]) {
        int n = 0;
        for (int i = 0; s[i] != 0; i++) {
            n |= (1 << (s[i] - 'a'));
        }
        return n;
    }
}
