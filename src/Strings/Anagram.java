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
            System.out.println(isAnagram(text, text1));
        }
    }

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
