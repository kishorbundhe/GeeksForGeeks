package Matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Given a square matrix mat of size N x N. The task is to find the determinant of this matrix.*/
public class Determinant {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());// N
            int[][] matrix = new int[N][N];
            // matrix one
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(input[j]);
                }

            }
            System.out.println((new InnerDeterminant()).getDeterminant(matrix, N));
        }
    }
}

// No meaning for this name
class InnerDeterminant {
    public int getDeterminant(int[][] matrix, int n) {

        int D = 0, i;
        if (n == 2) {
            D = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
            return D;
        } else if (n <= 1) {
            D = matrix[0][0];
            return D;
        }
        int sign = 1;
        int[][] temp = new int[n - 1][n - 1];
        for (i = 0; i < n; i++) {

            temp = getCofactor(matrix, temp, i);
            D += sign * matrix[0][i] * getDeterminant(temp, n - 1);
            sign = -sign;
        }
        return D;
    }

    private int[][] getCofactor(int[][] matrix, int[][] temp, int c) {
        int i, j, Mn = matrix.length;
        int Ti = 0, Tj = 0, Tn = temp.length;
        for (i = 1; i < Mn; i++) {
            for (j = 0; j < Mn; j++) {
                if (Tj == Tn) {
                    Ti++;
                    Tj = 0;

                }
                if (i != 0 && j != c) {
                    temp[Ti][Tj] = matrix[i][j];
                    Tj++;
                }
            }
        }
        return temp;
    }
}

