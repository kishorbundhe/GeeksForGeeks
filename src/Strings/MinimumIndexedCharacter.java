package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*Given a string str and another string patt.
   Find the character in patt that is present at the minimum index in str.
  If no character of patt is present in str then print ‘No character present’.*/
class MinimumIndexedCharacter {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String text = br.readLine().trim();
            String patt = br.readLine().trim();
            solution(text, patt);
        }
    }

    public static void solution(String s1, String s2) {
        int i, n = s1.length(), m = s2.length();
        int res = Integer.MAX_VALUE;
        // Your code here
        int[] asciiArray = new int[256];
        Arrays.fill(asciiArray, -1);
        // putting index value at the Direct access array created
        for (i = 0; i < n; i++) {
            char temp = s1.charAt(i);
            if ((asciiArray[temp] == -1)) {
                asciiArray[temp] = i;
            }
        }
        // traversing the pattern to find  minimum index in str
        for (i = 0; i < m; i++) {
            char temp = s2.charAt(i);
            if ((asciiArray[temp]) != -1) {
                res = Math.min(res, asciiArray[temp]);
            }
        }
        if (res != Integer.MAX_VALUE) System.out.print(s1.charAt(res));
        else System.out.print("NO Character Found");
    }
}