package Strings;

import java.util.Arrays;
import java.util.Scanner;

/* Given the  string  Find the left most chacracter that does repeat*/
public class LeftMostCharWhichRepeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String string = sc.nextLine();
            System.out.println(firstRepeat(string, string.length()));
        }
    }

    private static char firstRepeat(String string, int length) {
        int res = Integer.MAX_VALUE;
        int temp;
        int i;
        int[] visitedArray = new int[256];
        Arrays.fill(visitedArray, -1);
        for (i = 0; i < length; i++) {
            temp = string.charAt(i);
            if (visitedArray[temp] == -1) {
                visitedArray[temp] = 1;//visited
            } else {
                res = Math.min(res, i);
            }
        }
        return string.charAt(res);
    }
}
