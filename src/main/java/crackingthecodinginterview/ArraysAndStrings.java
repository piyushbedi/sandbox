package crackingthecodinginterview;

import java.util.Arrays;

/**
 * Created by Piyush on 19/08/14.
 */
public class ArraysAndStrings {

    public static boolean allUniqueCharacters(String s) {

        if (s == null || s.length() < 0) {
            return true;
        }

        int[] existingCharacters = new int[256];
        int size = s.length();
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if (existingCharacters[c] > 0) {
                return false;
            } else {
                existingCharacters[c]++;
            }
        }
        return true;
    }

    public static boolean allUniqueCharactersInPlace(String s) {
        if (s == null || s.length() < 0) {
            return true;
        }

        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        int j = 0;
        int k = 1;

        for(; k < chars.length; j++, k++) {
            if (chars[j] == chars[k]) {
                return false;
            }
        }

        return true;
    }

    public static String reverseCStyleString(char[] s) {
        if (s == null) {
            return null;
        }

        if (s.length == 0) {
            return "";
        }

        int j = 0;
        int k = s.length - 1;

        for (; j <= k; j++, k--) {
            char tmp = s[k];
            s[k] = s[j];
            s[j] = tmp;
        }
        return new String(s);
    }

    public static String removeDuplicateCharacters(String s) {
        throw new UnsupportedOperationException("implement me");
    }
}
