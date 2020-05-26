package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Given a string S consisting of uppercase and lowercase characters.
The task is to sort uppercase and lowercase letters separately such
that if the ith place in the original string had an Uppercase character
then it should not have a lowercase character after being sorted and vice versa.
*/
public class CaseSpecificSortingStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String text = br.readLine().trim();
            System.out.println(caseSort(text));
        }
    }

    public static String caseSort(String str) {
        // Your code here
        int n = str.length();
        char[] buff = str.toCharArray();
        int[] frequencyMap = new int[256];
        for (int i = 0; i < n; i++) {
            frequencyMap[buff[i]] += 1;
        }
        int aPointer = 97, APointer = 65;
        for (int i = 0; i < n; i++) {
            if (buff[i] >= 97 && buff[i] <= 122) {
                while (frequencyMap[aPointer] == 0) {
                    aPointer++;
                }
                frequencyMap[aPointer]--;
                buff[i] = (char) aPointer;
            } else if (buff[i] >= 65 && buff[i] <= 90) {
                while (frequencyMap[APointer] == 0) {
                    APointer++;
                }
                frequencyMap[APointer]--;
                buff[i] = (char) APointer;
            }
        }
        return new String(buff);
    }

}
