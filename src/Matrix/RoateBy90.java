package Matrix;
/* Rotate the matrix by 90 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RoateBy90 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int R = Integer.parseInt(br.readLine().trim());// Row
            int C = Integer.parseInt(br.readLine().trim());// Column
            int[][] matrix = new int[R][C];
            // matrix one
            for (int i = 0; i < R; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < C; j++) {
                    matrix[i][j] = Integer.parseInt(input[j]);
                }

            }
            rotateby90(matrix, R, C);
        }
    }

    private static void rotateby90(int[][] matrix, int r, int c) {
        if (r != c) {
            System.out.println("Transpose doesnt exist");
        }
        //Transpose and reverse  individual column
        int i = 0, j = 0, temp;
        for (; i < r; i++) {
            for (j = i + 1; j < c; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        /*for (i = 0; i < r; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }*/
        for (i = 0; i < c; i++) {
            for (j = 0; j < r / 2; j++) {
                temp = matrix[j][i];
                matrix[j][i] = matrix[r - j - 1][i];
                matrix[r - j - 1][i] = temp;
            }
        }

        //  Result for printing the result
        for (i = 0; i < r; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}