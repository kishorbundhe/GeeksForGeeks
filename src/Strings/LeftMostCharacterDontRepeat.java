package Strings;

import java.util.Arrays;
import java.util.Scanner;

public class LeftMostCharacterDontRepeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String string = sc.nextLine();
            System.out.println(firstDontRepeat(string, string.length()));
        }
    }

    private static char firstDontRepeat(String string, int length) {
        // -1 never found
        // index of the array element visited once
        //-2 repeated the visit

        int res = Integer.MAX_VALUE;
        int temp;
        int i;
        int[] visitedArray = new int[256];
        Arrays.fill(visitedArray, -1);
        for (i = 0; i < length; i++) {
            temp = string.charAt(i);
            if (visitedArray[temp] == -1) {
                visitedArray[temp] = i;
            } else {
                visitedArray[temp] = -2;
            }
        }
        //
        for (int x : visitedArray) {
            if (x != -1 && x != -2) res = Math.min(res, x);
        }
        return string.charAt(res);
    }
}
