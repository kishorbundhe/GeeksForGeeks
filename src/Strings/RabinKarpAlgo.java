package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RabinKarpAlgo {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String text = br.readLine().trim();
            String pattern = br.readLine().trim();
            rabinKarp(text, pattern);
        }
    }

    private static void rabinKarp(String text, String pattern) {
        // q = 7919 largest prime under 10000
        // d = 5


        int n = text.length();
        int m = pattern.length();
        final int q = 7919;
        final int d = 5;
        int t = 0, p = 0, i = 0, j = 0, h = 1; // hash for pattern = p and hash for text = t
        // calculating d power m-1
        for (; i < m - 1; i++) {
            h = h * d;
        }
        // calculating hash for text and pattern
        for (i = 0; i < m; i++) {
            p = p * d + pattern.charAt(i) - 'a' % q;
            t = t * d + text.charAt(i) - 'a' % q;
        }
        for (i = 0; i <= n - m; i++) {

            if (t == p) {
                boolean flag = true;
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) == pattern.charAt(j)) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("Pattern found at " + i);
                }
            }
            if (i < n - m) {
                t = ((t - (text.charAt(i) - 'a') * h) * d + (text.charAt(i + m) - 'a')) % q;
                if (t < 0) {
                    t = t + q;
                }
            }
        }

    }
}