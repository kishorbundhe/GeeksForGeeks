package Matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Given a Square matrix mat[] of size NxN. Your task is to find minimum number of operation(s) that are required to make the matrix Beautiful.
A Beautiful matrix is a matrix in which sum of elements in each row and column is equal. In one operation you can only increment any value of cell of matrix by 1.*/
public class BeautifullMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());// Row
            int[][] matrix = new int[N][N];
            // matrix one
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(input[j]);
                }
            }
            System.out.println(findMinOperation(N, matrix));
        }
    }

    private static int findMinOperation(int N, int[][] matrix) {
        int[] sumOfRows = new int[N], sumOfColumns = new int[N];
        int i, j, maxSumOfRows = 0, maxSumOfColumns = 0, minOp = 0;
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                sumOfRows[i] += matrix[i][j];
                sumOfColumns[j] += matrix[i][j];
                maxSumOfColumns = Math.max(maxSumOfColumns, sumOfColumns[j]);
            }
            maxSumOfRows = Math.max(maxSumOfRows, sumOfRows[i]);

        }
        if (maxSumOfRows >= maxSumOfColumns) {
            for (int x :
                    sumOfRows) {
                minOp += maxSumOfRows - x;
            }
        } else {
            for (int x :
                    sumOfColumns) {
                minOp += maxSumOfColumns - x;
            }
        }
        return minOp;
        //Your code here
    }
}


