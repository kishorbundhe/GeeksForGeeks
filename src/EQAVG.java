/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class EQAVG {
    public static void main(String[] args) throws java.lang.Exception {


        /*
        *
        *
        *
        * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i]=Integer.parseInt(inputLine[i]);
		    }
        *
        *
        *
        *
        * */
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
//            System.out.println("n");
            int n = input.nextInt();
            System.out.println("k");
            int k = input.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }

            System.out.println(eqavg(arr, n, k));
        }
    }

    public static String eqavg(int arr[], int n, int k) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % k == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
