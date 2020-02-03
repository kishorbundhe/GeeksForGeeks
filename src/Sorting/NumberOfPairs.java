package Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*Given two arrays X and Y of positive integers,
 find number of pairs such that xy > yx (raised to power of)
 where x is an element from X and y is an element from Y.*/
public class NumberOfPairs {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);

            int[] x = new int[n];
            str = (br.readLine()).trim().split(" ");
            for (int i = 0; i < n; i++)
                x[i] = Integer.parseInt(str[i]);

            str = (br.readLine()).trim().split(" ");
            int[] y = new int[m];
            for (int i = 0; i < m; i++) {
                y[i] = Integer.parseInt(str[i]);

            }

            System.out.println(countPairs(x, y, n, m));


        }
    }


    static long countPairs(int[] x, int[] y, int n, int m) {
        long countPair = 0;
        int j, i, lowIndexOfj = 0, lowIndexOfi = 0;
        int countOfThree = 0, countFour = 0, countOne = 0;
        Arrays.sort(x);
        Arrays.sort(y);
        if (m == 0) {
            return 0;
        }
        for (i = 0; i < n; i++) {
            if (x[i] != 1)
                break;
            else
                lowIndexOfi++;
        }
        i = n - 1;
        j = m - 1;
        while (j >= 0 && i >= lowIndexOfi && y[j] > 4) {
            if (x[i] > y[j]) {
                i--;
                continue;
            } else if (y[j] > x[i]) {
                countPair += (i - lowIndexOfi) + 1;
                j--;
                continue;
            } else {
                i--;
            }
        }

      /*  while (i >= 0) {
            if (x[i] == 3)
                countOfThree++;
            i--;
        }
        while (j >= 0) {
            if (y[j] == 4) {
                countFour++;
            } else if (y[j] == 2) {
                countFour++;
            } else if (y[j] == 1) {
                countOne++;
            }
            j--;
        }
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
        System.out.println(countFour);
        System.out.println(countOfThree);
        System.out.println(countOne);*/


        countOfThree = countNumber(x, 0, i, 3);
        countFour = countNumber(y, 0, j, 4);
        countFour += countNumber(y, 0, j, 2);
        countOne = countNumber(y, 0, j, 1);
        System.out.println(countFour);
        System.out.println(countOfThree);
        System.out.println(countOne);
        countPair += countOfThree * countFour;
        countPair += (n - lowIndexOfi) * countOne;

        return countPair;
    }

    private static int countNumber(int[] arr, int start, int end, int X) {
        int mid = 0;
        int leftIndex = -1, rightIndex = -1;
        int size = arr.length;
        int copystart = start, copyEnd = end;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if ((mid - 1) >= 0 && arr[mid] == X && arr[mid - 1] != X) {
                leftIndex = mid;
                break;
            } else if (arr[mid] > X) {
                end = mid - 1;
            } else if (arr[mid] < X) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (arr[0] == X) {
            leftIndex = 0;
        }
        while (copystart <= copyEnd) {
            mid = copystart + (copyEnd - copystart) / 2;
            if ((mid + 1) < size && arr[mid] == X && arr[mid + 1] != X) {
                rightIndex = mid;
                break;
            } else if (arr[mid] > X) {
                copyEnd = mid - 1;
            } else if (arr[mid] < X) {
                copystart = mid + 1;
            } else {
                copystart = mid + 1;
            }
        }
        if (arr[size - 1] == X) {
            leftIndex = size - 1;
        }
        if (leftIndex >= 0 && rightIndex >= 0) {
            return (rightIndex - leftIndex + 1);
        } else
            return 0;

    }
}


  /* private static long countPairs(int[] x, int[] y, int n, int m) {
        long countPair = 0;
        int j, i, lowIndexOfj = 0, lowIndexOfi = 0;
        boolean countOfThree = false, countOfTwo = false, countFour = false;
        Arrays.sort(x);
        Arrays.sort(y);
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
        if(x[0]==0){}
        i = n - 1;
        j = m - 1;
        while (j >= lowIndexOfj && i >= lowIndexOfi && y[j] != 4) {
            if (x[i] > y[j]) {
                i--;
                continue;
            } else if (y[j] > x[i]) {
                countPair += (i - lowIndexOfi) + 1;
                j--;
                continue;
            } else {
                i--;
            }
        }
        if (y[lowIndexOfj] == 1) {
            countPair += n - lowIndexOfi;
        }
        if (countOfThree) {
            if (countOfTwo) {
                countPair++;
            }
            if (countFour) {
                countPair++;
            }
        }
        return countPair;
    }*/

