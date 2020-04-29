package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Given a string S and a pattern P both of lowercase characters.
 The task is to check if the given pattern exists in the given string or not.*/
public class NaiveSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String text = br.readLine().trim();
            String pattern = br.readLine().trim();
            naivePatternSearch(text, pattern);
        }
    }

    private static void naivePatternSearch(String text, String pattern) {
        int i, j, textSize, patternSize;
        boolean flag = false;
        textSize = text.length();
        patternSize = pattern.length();
        for (i = 0; i <= textSize - patternSize; i++) {
            flag = true;
            for (j = 0; j < patternSize; j++) {

                if (text.charAt(j + i) != pattern.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Pattern found at index " + i);
            }
        }
    }
}
