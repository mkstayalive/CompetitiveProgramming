package lib.io;

import java.util.Collection;
import java.util.function.Function;

/**
 * @author Manish Singh
 */
public class Debug {
    public static void print(int[] arr) {
        for (int item : arr) {
            System.err.print(String.valueOf(item) + " ");
        }
        System.err.println();
    }

    public static void print(Collection c) {
        for (Object item : c) {
            System.err.print(String.valueOf(item) + " ");
        }
        System.err.println();
    }

    public static void print(Collection c, Function<Object, Object> getVal) {
        for (Object item : c) {
            System.err.print(String.valueOf(getVal.apply(item)) + " ");
        }
        System.err.println();
    }
}
