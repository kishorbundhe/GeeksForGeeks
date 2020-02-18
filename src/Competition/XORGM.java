package Competition;

import java.io.IOException;
import java.util.Scanner;

public class XORGM {
    public static void main(String[] args) throws IOException {
        Scanner br = new Scanner(System.in);
        int t = br.nextInt();

        while (t-- > 0) {
            int n = br.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = br.nextInt();
            }

            xorgm(arr, n);
        }
    }

    private static void xorgm(int[] arr, int n) {
        int[] brr;

    }
}
