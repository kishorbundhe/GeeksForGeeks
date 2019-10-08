import java.util.Scanner;

/* Find the subarray having length=k with max and min of the sum with */
public class MaxSubArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println("What is the size of the SubArray of k ");
        int k = sc.nextInt();
        System.out.println("Enter the size of the Array");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the value for the array");
        while (i < size) {
            arr[i] = sc.nextInt();
            i++;
        }
        maxSubArray(arr, k);
        minSubArray(arr, k);
    }

    /*This function calculates the maximun sum of the subArray */
    public static void maxSubArray(int[] arr, int k) {
        int size, i = 0, sum = 0, temp = 0, start, end;
        size = arr.length;
        while (i < k) {
            sum += arr[i];
            i++;
        }
        start = 0;
        end = k - 1;
        for (i = k; i < size; i++) {
            temp = sum;
            sum = sum + arr[i] - arr[i - k];
            if (sum > temp) {
                start = i - k + 1;
                end = i;

            }


        }
        System.out.println("The max sum =" + sum + " is from index [i,j]=[" + start + "," + end + "]");


    }

    /*This function calculates the minimum sum of the subArray */
    public static void minSubArray(int[] arr, int k) {
        int size, i = 0, sum = 0, temp = 0, start, end;
        size = arr.length;
        while (i < k) {
            sum += arr[i];
            i++;
        }
        start = 0;
        end = k - 1;
        for (i = k; i < size; i++) {
            temp = sum;
            sum = sum + arr[i] - arr[i - k];
            if (sum < temp) {
                start = i - k + 1;
                end = i;
            } else {
                sum = temp;

            }

        }
        System.out.println("The min sum =" + sum + " is from index [i,j]=[" + start + "," + end + "]");

    }
}
