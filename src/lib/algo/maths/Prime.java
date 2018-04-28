package lib.algo.maths;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Manish Singh
 */
public class Prime {

    private final int N;
    private boolean[] isPrime;
    private List<Integer> primesList;

    public Prime(int N) {
        this.N = N;
        setIsPrimeMap();
        setPrimeNumbersList();
    }

    private void setIsPrimeMap() {
        boolean isPrimeMap[] = new boolean[N + 1];
        Arrays.fill(isPrimeMap, true);
        isPrimeMap[0] = isPrimeMap[1] = false;
        for (int i = 2; i * i <= N; ++i) {
            if (isPrimeMap[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrimeMap[j] = false;
                }
            }
        }
        this.isPrime = isPrimeMap;
    }

    public boolean[] getIsPrime() {
        return isPrime;
    }

    public boolean isPrimeNumber(int n) {
        return isPrime[n];
    }

    private void setPrimeNumbersList() {
        List<Integer> primesList = new LinkedList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primesList.add(i);
            }
        }
        this.primesList = primesList;
    }

    public List<Integer> getPrimesList() {
        return primesList;
    }

    public Map<Integer, Integer> getPrimeFactors(int n) {
        Map<Integer, Integer> factors = new HashMap<>();
        for (int p : primesList) {
            if (p > n) break;
            while (n % p == 0) {
                n /= p;
                if (factors.containsKey(p)) {
                    factors.put(p, factors.get(p) + 1);
                } else {
                    factors.put(p, 1);
                }
            }
        }
        return factors;
    }

    boolean isPrimeMillerRabin(long p, int k) {
        Mod mod = new Mod(p);
        if (p < 2) return false;
        if (p == 2) return true;
        if ((p & 1) == 0) return false;
        long s = p - 1;
        while (s % 2 == 0) s >>= 1;
        while (k-- != 0) {
            long a = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE) % (p - 1) + 1, temp = s;
            long rem = mod.power(a, temp);
            if (rem == -1 || rem == 1) continue;
            while (temp != p - 1 && rem != p - 1) {
                rem = mod.multiply(rem, rem);
                temp = mod.add(temp, temp);
            }
            if (rem != p - 1) return false;
        }
        return true;
    }
}
