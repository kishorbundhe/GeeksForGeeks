package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*segregate an array of elements containing two types of elements. The types are:
Segregate negative and positive elements.
Segregate even and odd elements.
Sort a binary array.
*/
public class Segreagte {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] string = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(string[i]);
            }
            /*SegreagteTwoTypes(arr, 0, arr.length - 1);
            System.out.println(Arrays.toString(arr));
            */
            System.out.println("Enter the pivot");
            int pivot = Integer.parseInt(br.readLine().trim());
            segregateThreeTypes(arr, 0, arr.length - 1, pivot);
            System.out.println(Arrays.toString(arr));
        }
    }

    /* all the values smaller than pivot to left ,
     * equal to the pivot
     * all the values greater than pivot to right
     * */
    private static void segregateThreeTypes(int[] arr, int l, int h, int pivot) {
        int mid;
        mid = 0;
        int temp;
        while (mid < h) {

            if (arr[mid] < pivot) {
                temp = arr[mid];
                arr[mid] = arr[l];
                arr[l] = temp;
                l++;
                mid++;
            } else if (arr[mid] == pivot) {
                mid++;
            } else {
                temp = arr[mid];
                arr[mid] = arr[h];
                arr[h] = temp;
                h--;
            }
        }
    }


    // assuming here we have to segregate the even and odd
    private static void SegreagteTwoTypes(int[] arr, int p, int r) {
        int i = 0, j = r, temp;

        while (i < j) {
            while (arr[i] % 2 == 0) {
                i++;
            }
            while (arr[j] % 2 != 0) {
                j--;
            }
            if (j > i) {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
