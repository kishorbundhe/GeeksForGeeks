package Matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OperationsOnMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int R = Integer.parseInt(br.readLine().trim());// Row
            int C = Integer.parseInt(br.readLine().trim());// Column
            int[][] matrixOne = new int[R][C];
            // matrix one
            for (int i = 0; i < R; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < C; j++) {
                    matrixOne[i][j] = Integer.parseInt(input[j]);
                }
            }

            R = Integer.parseInt(br.readLine().trim());// Row
            C = Integer.parseInt(br.readLine().trim());// Column
            int[][] matrixTwo = new int[R][C];
            // matrix two
            for (int i = 0; i < R; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < C; j++) {
                    matrixTwo[i][j] = Integer.parseInt(input[j]);
                }
            }


            // matrix two
            matrixMultiply(matrixOne, matrixTwo);
            for (int i = 0; i < R; i++) {
                System.out.println(Arrays.toString(matrixOne[i]));
            }

        }

    }

    // for matrix multiplication this = one*two   !two*one
    private static void matrixMultiply(int[][] matrixOne, int[][] matrixTwo) {
        int i, j;
        int n, m; // row column for first array
        int p, q;// row column for second array
        n = matrixOne.length;
        m = matrixOne[0].length;
        p = matrixTwo.length;
        q = matrixTwo[0].length;

        if (m != p) {
            System.out.println(" Matrix are not compatible for multiplication");
        }

        int[][] resultMatrix = new int[n][q];

        for (i = 0; i < n; i++) {
            for (j = 0; j < q; j++) {
                for (int k = 0; k < p; k++) {
                    resultMatrix[i][j] += matrixOne[i][k] * matrixTwo[k][j];
                }
            }
        }
        //  Result for printing the result
        for (i = 0; i < n; i++) {
            System.out.println(Arrays.toString(resultMatrix[i]));
        }

    }
}
