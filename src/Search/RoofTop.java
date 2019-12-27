package Search;
/*You are given heights of consecutive buildings. You can move from the roof of a building to the roof of next adjacent building.
You need to find the maximum number of consecutive steps you can put forward such that you gain an increase in altitude.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Example:
Input:
2
5
1 2 2 3 2
4
1 2 3 4

Output:
1
3*/
public class RoofTop {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] string = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(string[i]);
            }
//            maxStep(arr, n);
            countRepeat(arr, n);
        }
    }

    /* You are given heights of consecutive buildings. You can move from the roof of a building to the roof of next adjacent building.
    You need to find the maximum number of consecutive steps you can put forward such that you gain an increase in altitude. */
    private static void countRepeat(int[] arr, int size) {
        int start, end, i, j, repeatedNo = 0, NoOfTimes;

        start = arr[0];
        end = arr[size - 1];
        NoOfTimes = (start + size) - end;
        for (i = 0, j = size - 1; i < j; i++, j--) {
            if (arr[i + 1] == arr[i]) {
                repeatedNo = arr[i];
                break;
            } else if (arr[j - 1] == arr[j]) {
                repeatedNo = arr[j];
                break;
            }
        }
        System.out.print(repeatedNo + " " + NoOfTimes);
    }

    private static void maxStep(int[] arr, int size) {
        int i = 0, maxCount = 0, previousCount = 0;
        for (; i < size - 1; i++) {
            if (arr[i + 1] > arr[i]) {
                previousCount++;
                if (previousCount > maxCount) {
                    maxCount = previousCount;
                }
            } else {
                previousCount = 0;
            }

        }
        System.out.println("Count=" + maxCount);
    }

}
