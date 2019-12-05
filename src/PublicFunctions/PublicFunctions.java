package PublicFunctions;

public class PublicFunctions {

    public static int gcd(int a, int b) {

        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    /*
     *  Binary search */
    public static int binarysearch(int[] arr, int low, int high, int x) {
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (x > arr[mid]) {
                low = mid + 1;
            } else if (x < arr[mid]) {
                high = mid - 1;
            }
        }
        return -1;
    }
}
