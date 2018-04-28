package lib.algo.maths;

/**
 * @author Manish Singh
 */
public class SumOfDigits {

    private final int N = (int) 1e7; // upto 1e8 - 1
    private int[] sum;

    public SumOfDigits() {
        sum = new int[N];
        int counter = 0;
        for (int i6 = 0; i6 <= 9; i6++) {
            for (int i5 = 0; i5 <= 9; i5++) {
                for (int i4 = 0; i4 <= 9; i4++) {
                    for (int i3 = 0; i3 <= 9; i3++) {
                        for (int i2 = 0; i2 <= 9; i2++) {
                            for (int i1 = 0; i1 <= 9; i1++) {
                                for (int i0 = 0; i0 <= 9; i0++) {
                                    sum[counter++] = i0 + i1 + i2 + i3 + i4 + i5 + i6;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public int getSumOfDigits(int n) {
        return sum[n];
    }
}
