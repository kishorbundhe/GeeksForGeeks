package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
* Given two strings s1 and s2. Modify string s1 such that all the common characters of
* s1 and s2 is to be removed and the uncommon characters of s1 and s2 is to be concatenated.
Note: If no modification is possible print -1.*/
public class RemoveCommonCharactersAndConcatenate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String text = br.readLine().trim();
            String text1 = br.readLine().trim();
            System.out.println(concatenatedString(text, text1));
        }
    }

    public static String concatenatedString(String s1, String s2) {

        int i = 0, n = s1.length(), m = s2.length();

        int[] asciiArray = new int[256];
        Arrays.fill(asciiArray, -1);
        for (; i < n; i++) {
            char temp = s1.charAt(i);
            if ((asciiArray[temp] == -1)) {
                asciiArray[temp] = 1;
            }
        }
        for (i = 0; i < m; i++) {
            char temp = s2.charAt(i);
            if ((asciiArray[temp] == 1)) {
                asciiArray[temp] = -2;
            }
        }
        StringBuilder tempStr = new StringBuilder();
        for (i = 0; i < n; i++) {
            char temp1 = s1.charAt(i);
            if ((asciiArray[temp1] != -2)) {
                tempStr.append(temp1);
            }
        }
        for (i = 0; i < m; i++) {
            char temp1 = s2.charAt(i);
            if ((asciiArray[temp1] != -2)) {
                tempStr.append(temp1);
            }
        }

        if (tempStr.length() == 0) return "-1";
        else
            return tempStr.toString();
    }
}
