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

    public static char[] removeDuplicateCharactersInPlace(char[] str) {
        if(str == null) {
            return null;
        }

        if(str.length < 2) {
            return str;
        }

        int j;
        int k;
        char replacementChar = str[0];
        int nDuplicates = 0;

        for (j = 0; j < str.length; j++) {
            for (k = j + 1; k < str.length; k++) {
                if (str[k] == str[j]) {
                    str[k] = replacementChar;
                    nDuplicates++;
                }
            }
        }

        char[] withoutDuplicates = new char[str.length - nDuplicates];

        withoutDuplicates[0] = str[0];

        for (j = 1, k = 1; j < str.length; j++) {
            if (str[j] != replacementChar) {
                withoutDuplicates[k] = str[j];
                k++;
            }
        }

        return withoutDuplicates;
    }

    public static void main(String[] args) {
        int k = 23;
        System.out.println("k = " + k + " = " + Integer.toBinaryString(k));
        int index = 0;
        while (k > 0) {
            System.out.println("k & 1 = " + (k & 1));
            if ((k & 1) > 0) {
                System.out.println("index = " + index);
            }
            index++;
            k >>= 1;
            System.out.println("k = " + k + " = " + Integer.toBinaryString(k));
        }
    }
}
