package Competition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PSHOT {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = 2 * Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String string = br.readLine().trim();
            for (int i = 0; i < n; i++) {

                arr[i] = Character.getNumericValue(string.charAt(i));
            }

            whowins(arr, n);
        }
    }

    private static void whowins(int[] arr, int n) {
        int aScore = 0, bScore = 0, toWin, i = 0, winner = 0, remainingA = n / 2, remainingB = n / 2;
        toWin = (n / 4) + 1;

        for (; i < n - 1;
             i++) {

            if (i % 2 == 0) {
                aScore += arr[i];
                remainingA--;
            } else {
                bScore += arr[i];
                remainingB--;
            }
            if (aScore > bScore + remainingB) {
                System.out.println(i + 1);

                break;
            } else if (bScore > aScore + remainingA) {
                System.out.println(i + 1);

                break;
            }
        }
        /*if (aScore == bScore) {
            System.out.println(n);
        }*/
    }
}
