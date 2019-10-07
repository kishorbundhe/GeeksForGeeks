 /* Given an array fo stocks on some days , you need to find buy &  sell schedule for maximum profit */

 import java.util.ArrayList;
 import java.util.Iterator;
 import java.util.List;
 import java.util.Scanner;

 public class BuyAndSellStock {

     public static void main(String[] args) {
         System.out.println("Size of the array");
         Scanner sc = new Scanner(System.in);
         int size = sc.nextInt();
         int i = 0;
         int[] arr = new int[size];
         while (i < size) {
             arr[i] = sc.nextInt();
             i++;
         }
         calMaxProfit(arr);
     }

     public static void calMaxProfit(int[] arr) {
         int i = 0, profit = 0, size = arr.length;
         List<Integer> minlist = new ArrayList<Integer>();
         List<Integer> maxlist = new ArrayList<Integer>();
         // Condition for the Start point
         if (arr[0] < arr[1]) {
             minlist.add(arr[0]);
         }/*else if(arr[0]>arr[1]){
          maxlist.add(arr[0]);
      }*/


         for (i = 1; i < size - 1; i++) {
             if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                 minlist.add(arr[i]);
             } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                 maxlist.add(arr[i]);
             }
         }
         // Condition for the End point
         if (arr[i] > arr[i - 1])
             maxlist.add(arr[i]);
       /* else if(arr[i]<arr[i-1])
            minlist.add(arr[i]);*/
         System.out.println("minlist " + minlist);
         System.out.println("maxlist " + maxlist);
         // Condition for calculating the profit
         if (minlist.isEmpty() && maxlist.isEmpty()) {
             System.out.println("No right time to buy the stock");
         } else {
             for (i = 0; i < maxlist.size(); i++) {
                 profit += maxlist.get(i) - minlist.get(i);
             }
         }
         System.out.println("The Profit " + profit);

     }
 }
