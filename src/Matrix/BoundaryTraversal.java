package Matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Given a matrix we need to traverse the boundaries of it*/
public class BoundaryTraversal {
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
            boundaryTraversal(matrix);
        }
    }

    /*   private static void boundaryTraversal(int[][] matrixOne) {

           int i = 0, j = 0, noOfRows, nofColumns;
           noOfRows = matrixOne.length - 1;
           nofColumns = matrixOne[0].length - 1;
           int flag = 0;
           while (true) {
               if (i == 0 && j != nofColumns) {
                   if (flag == 3) {
                       break;
                   }
                   System.out.print(matrixOne[i][j] + " ");
                   //System.out.println(Arrays.toString(matrixOne[0]));
                   j++;
               } else if (j == (nofColumns) && i < (noOfRows)) {

                   System.out.print(matrixOne[i][j] + " ");
                   i++;

               } else if (i == (noOfRows) && j > 0) {

                   System.out.print(matrixOne[i][j] + " ");
                   j--;
               } else if (j == 0 && i > 0) {

                   System.out.print(matrixOne[i][j] + " ");
                   i--;
                   flag = 3;
               }
           }

       }*/
    // Submitted Solution
    private static void boundaryTraversal(int[][] matrix) {
        int top, right, left, bottom, i, j;
        int r = matrix.length - 1, c = matrix[0].length - 1;
        top = 0;
        left = 0;
        right = c;
        bottom = r;
        for (j = 0; j <= right; j++) {
            System.out.print(matrix[0][j] + " ");
        }
        top++;
        for (i = top; i <= bottom; i++) {
            System.out.print(matrix[i][right] + " ");
        }
        right--;
        if (top <= bottom) {
            for (j = right; j >= left; j--) {
                System.out.print(matrix[bottom][j] + " ");
            }
        }
        bottom--;
        if (right >= left) {
            for (i = bottom; i >= top; i--) {
                System.out.print(matrix[i][left] + " ");
            }
        }

    }

}