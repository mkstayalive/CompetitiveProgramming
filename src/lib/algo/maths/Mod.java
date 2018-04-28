package lib.algo.maths;

/**
 * @author Manish Singh
 */
public class Mod {

    private long md;

    public Mod(long md) {
        this.md = md;
    }

    public Mod(double md) {
        this.md = (long) md;
    }

    public long add(long a, long b) {
        a += b;
        if (a >= md) {
            a -= md;
        }
        return a;
    }

    public long subtract(long a, long b) {
        a -= b;
        if (a < 0) {
            a += md;
        }
        return a;
    }

    public long multiply(long a, long b) {
        return a * b % md;
    }

    public long power(long a, long b) {
        long res = 1;
        while (b != 0) {
            if (b % 2 == 0) {
                a = (a * a) % md;
                b /= 2;
            }
            res = res * a % md;
            b -= 1;
        }
        return res;
    }

    public long inverse(long x) {
        return power(x, md - 2);
    }

    public long factorial(long n) {
        long res = 1;
        for(long i = 1; i <= n; i++) {
            res = res * i % md;
        }
        return res;
    }
}
