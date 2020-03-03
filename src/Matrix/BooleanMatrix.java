package Matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*Given a boolean matrix mat[r][c] of size r X c, modify it such that if a matrix cell mat[i][j] is 1 (or true)
then make all the cells of ith row and jth column as 1.*/
public class BooleanMatrix {
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
            convertMatrix(matrix, R, C);
        }
    }

    private static void convertMatrix(int[][] matrix, int r, int c) {
        int i = 0, j = 0, flag = 0;
        StringBuilder sb = new StringBuilder();
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> Columns = new HashSet<Integer>();

        // for loop for calculating the
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                if (matrix[i][j] == 1) {
                    rows.add(i);
                    Columns.add(j);
                }
            }
        }
        int smallest, largest;
        if (r > c && r == rows.size()) {
            flag = 1;
        } else if (c > r && c == Columns.size()) {
            flag = 1;
        } else if (r == c && (r == rows.size() || c == Columns.size())) {
            flag = 1;
        }
        if (flag == 1) {
            for (i = 0; i < r; i++) {
                for (j = 0; j < c; j++) {
                    sb.append(1 + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            return;
        }

        // if(smallest==)
        for (int x :
                rows) {
            for (i = 0; i < c; i++) {
                matrix[x][i] = 1;
            }
        }
        for (int x :
                Columns) {
            for (i = 0; i < r; i++) {
                matrix[i][x] = 1;
            }

        }

        // printing the modified
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                sb.append(matrix[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
