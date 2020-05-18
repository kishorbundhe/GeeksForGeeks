package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*Given a string check if it is Pangram or not.
A pangram is a sentence containing every letter in the English Alphabet*/
class Solve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String text = br.readLine().trim();
            checkPanagram(text);
        }
    }

    public static boolean checkPanagram(String s) {
        int i = 0, n = s.length(), tempPos;
        s = s.toLowerCase();
        int[] asciiArray = new int[26];
        Arrays.fill(asciiArray, 0);
        for (; i < n; i++) {
            char temp = s.charAt(i);
            tempPos = temp - 'a';
            if (tempPos >= 0 && tempPos <= 25) asciiArray[tempPos] = 1;
        }
        for (int j : asciiArray) {
            if (j == 0) return false;
        }
        return true;
    }
}