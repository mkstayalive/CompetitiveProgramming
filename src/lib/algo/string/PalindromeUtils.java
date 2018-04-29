package lib.algo.string;

/**
 * @author Manish Singh
 */
public class PalindromeUtils {

    public static boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i <= len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
