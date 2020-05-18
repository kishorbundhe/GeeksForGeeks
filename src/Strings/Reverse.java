package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Given a String of length S,
reverse the whole string without reversing the individual words in it.
Words are separated by dots.
*/
class Reverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String text = br.readLine().trim();
            reverseWords(text);
        }
    }

    public static void reverseWords(String sd) {
        String[] splitString = sd.split("\\.");
        int n = splitString.length;
        StringBuilder temp = new StringBuilder();
        for (int i = n - 1; i > 0; i--) {
            temp.append(splitString[i] + ".");
        }
        temp.append(splitString[0]);
        System.out.print(temp.toString());
    }
}