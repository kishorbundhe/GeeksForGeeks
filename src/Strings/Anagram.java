package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String text = br.readLine().trim();
            String text1 = br.readLine().trim();
            //System.out.println(isAnagram(text, text1));
            System.out.println(isRoated(text, text1));
//            System.out.println(areIsomorphic(text, text1));
            System.out.println(getMaxOccuringChar(text));
        }
    }

    public static boolean isRoated(String s1, String s2) {
        if (s1.length() == 1 && s2.length() == 1) {
            return s1.equals(s2);
        }
        s1 += s1;
        return s1.indexOf(s2) == 2 || s1.indexOf(s2) == s2.length() - 2;
    }

    public static char getMaxOccuringChar(String line) {
        int maxCharIndexFrequency = -1;
        char maxChar = 0;
        int i = 0, n = line.length();
        int[] asciiArray = new int[256];
        Arrays.fill(asciiArray, 0);
        for (; i < n; i++) {
            char temp = line.charAt(i);
            if ((asciiArray[temp] == -1)) {
                asciiArray[temp] = 1;
            } else {
                asciiArray[temp] += 1;
                if (asciiArray[temp] > maxCharIndexFrequency) {
                    maxCharIndexFrequency = asciiArray[temp];
                    maxChar = line.charAt(i);
                } else if (asciiArray[temp] == maxCharIndexFrequency) {
                    maxChar = maxChar < line.charAt(i) ? maxChar : line.charAt(i);
                }
            }
        }
        return maxChar;
    }

   /* public static boolean areIsomorphic(String s1, String s2) {
        int i = 0, n = s1.length();
        int asciiArray[] = new int[256];
        Arrays.fill(asciiArray, -1);
        if (s1.length() != s2.length()) return false;
        for (; i < n; i++) {
            char s1temp = s1.charAt(i);
            char s2temp = s2.charAt(i);
            if ((asciiArray[(int) s2temp] == -1)){
                asciiArray[(int) s2temp] = (int) s1temp;

            } else if (!(asciiArray[(int) s2temp] == -1)) {
                if ((asciiArray[(int) s2temp] == (int) s1temp)) continue;
                else return false;
            } else {
                return false;
            }
        }
        return true;
    }*/

    public static boolean isAnagram(String text, String text1) {
        int m = text.length();
        int n = text1.length();
        int i = 0, count = 0;
        int[] frequency = new int[256];
        Arrays.fill(frequency, 0);
        for (i = 0; i < m; i++) {
            frequency[text.charAt(i) - 'a'] += 1;
        }
        for (i = 0; i < n; i++) {
            frequency[text1.charAt(i) - 'a'] += -1;
        }
        for (i = 0; i < 256; i++) {
            if (frequency[i] != 0) {
                return false;

            }
        }
        return true;
    }
}
