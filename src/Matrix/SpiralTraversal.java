package Matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Given a matric whose column and row are sorted and we need to find the number given */
public class SpiralTraversal {
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
            spiralTraversal(matrix, R, C);
        }
    }

    private static void spiralTraversal(int[][] matrix, int r, int c) {
        int top = 0, right = c - 1, left = 0, bottom = r - 1, i = 0, j = 0;
        while (top <= bottom && left <= right) {
            for (j = left; j <= right; j++) {
                System.out.print(matrix[top][j] + " ");
            }
            top++;
            for (i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;
            if (top < bottom) {
                for (j = right; j >= left; j--) {
                    System.out.print(matrix[bottom][j] + " ");
                }
                bottom--;
            }

            if (left < right) {
                for (i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
    }
}

