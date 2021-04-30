package upgrad;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;


public class FindAllCommonMatrixElement {
    static int row;
    static int column;

    public static void printElementInAllRows(int[][] mat) {
        int noOfRows = mat.length;
        int noOfColumns = mat[0].length;
        TreeSet<Integer> firstRow = new TreeSet<>();
        TreeSet<Integer> interSectionSet = new TreeSet<>();

        for (int i = 0; i < noOfColumns; i++) {
            firstRow.add(mat[0][i]);
        }
        int j = 1;
        while (j < noOfRows) {
            for (int i = 0; i < noOfColumns; i++) {
                interSectionSet.add(mat[j][i]);
            }
            firstRow.retainAll(interSectionSet);
            interSectionSet.clear();
            j++;
        }
        for (int x : firstRow) {
            System.out.print(x + " ");
        }

    }

    public static void printElementInAllRows1(int[][] mat) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int j = 0; j < column; j++)
            map.put(mat[0][j], 1);

        for (int i = 1; i < row; i++) {

            for (int j = 0; j < column; j++) {
                if (map.containsKey(mat[i][j]) && map.get(mat[i][j]) == i) {
                    map.put(mat[i][j], map.get(mat[i][j]) + 1);
                    if (i == row - 1) {
                        System.out.println(mat[i][j] + " ");
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        column = sc.nextInt();

        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        printElementInAllRows(matrix);
    }
}
