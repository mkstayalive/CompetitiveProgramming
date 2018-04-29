package lib.utils.io;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.function.Function;

/**
 * @author Manish Singh
 */
public class PrintUtils {
    public static void print(PrintWriter out, int[] arr) {
        for (int item : arr) {
            out.print(String.valueOf(item) + " ");
        }
        out.println();
    }

    public static void print(PrintWriter out, long[] arr) {
        for (long item : arr) {
            out.print(String.valueOf(item) + " ");
        }
        out.println();
    }

    public static void print(PrintWriter out, double[] arr) {
        for (double item : arr) {
            out.print(String.valueOf(item) + " ");
        }
        out.println();
    }

    public static <T> void print(PrintWriter out, T[] arr) {
        for (T item : arr) {
            out.print(String.valueOf(item) + " ");
        }
        out.println();
    }

    public static <T> void print(PrintWriter out, Collection<T> list) {
        for (T item : list) {
            out.print(String.valueOf(item) + " ");
        }
        out.println();
    }

    public static <T> void debug(T[] arr) {
        for (T item : arr) {
            System.err.print(String.valueOf(item) + " ");
        }
        System.err.println();
    }

    public static void debug(Collection c) {
        for (Object item : c) {
            System.err.print(String.valueOf(item) + " ");
        }
        System.err.println();
    }

    public static void debug(Collection c, Function<Object, Object> getVal) {
        for (Object item : c) {
            System.err.print(String.valueOf(getVal.apply(item)) + " ");
        }
        System.err.println();
    }
}
