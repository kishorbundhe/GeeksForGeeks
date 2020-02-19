package Matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Given a matric whose column and row are sorted and we need to find the number given */
public class SearchInSortedMatrix {
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
            int X = Integer.parseInt(br.readLine().trim());// Row
            searchTheNumber(matrix, R, C, X);
        }
    }

    private static void searchTheNumber(int[][] matrix, int r, int c, int x) {
        int i = r - 1, j = c - 1;
        boolean flag = false;
        while ((i >= 0 && i < r) && (j >= 0 && j < c)) {
            if (matrix[i][j] == x) {
                flag = true;
                break;
            } else if (x > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        i++;
        j++;
        if (flag) {
            System.out.println(" item found at pos (i,j)" + "(" + i + "," + j + ")");
        } else System.out.println(" item not found ");
    }
}

