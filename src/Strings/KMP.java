package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* KMP algorithm*/
public class KMP {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String text = br.readLine().trim();
            String pattern = br.readLine().trim();
            kmp(text, pattern);
        }
    }


    private static void kmp(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] lps = new int[m];
        // create a fill lps array
        fillLPS(pattern, lps);
        int i = 0, length = 0;
        // length is pointer for pattern and i is pointer for text
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(length)) {
                i++;
                length++;
            }
            if (length == m) {
                System.out.println(i - length);
                length = lps[length - 1];
            } else if (i < n && text.charAt(i) != pattern.charAt(length)) {
                if (length == 0) {
                    i++;
                } else {
                    length = lps[length - 1];
                }
            }
        }
    }

    private static void fillLPS(String pattern, int[] lps) {
        int m = lps.length;
        int length = 0;
        lps[0] = 0;
        for (int i = 1; i < m; ) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    length = lps[length - 1];
                }
            }
        }

    }
}
