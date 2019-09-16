/*Given N points on the cartesian plane.  We need to find the minimum number of steps required to traverse all points (from start to end) in the same order as given.  From a point, movement in all 8 directions are possible and every movement is counted as a step.

Input :
The first line of input contains number of test cases T. For every test case, the first line contains the number of points N and the second line contains the sequence of points represented by 2*N numbers.

Note : Points are given in the following order : x1 y1 x2 y2 x3 y3 ….. and so on)

Output :
For each test case, Print the minimum number of steps required to reach end point from starting point by traversing the sequence in order.

Constraints :
1 <= T <= 10
1 <= N <= 10^6
0 <= Value of coordinates (x,y) <= 1018

Example :
Input :
2
3
0 0 1 1 1 2
4
1 0 1 2 6 3 6 4
Output :
2
8

Explanation :
For test case 1 :
The starting point is (0,0) and the ending point is (1,2). Now, (1,1) can be reached from (0,0) in 1 step and (1,2) can be reached from (1,1) in 1 step, therefore the answer becomes 2.

For test case 2 :
The starting point is (1,0) and the ending point is (6,4). Now, (1,2) can be reached from (1,0) in 2 steps, (6,3) can be reached from (1,2) in 5 steps and (6,4) can be reached from (6,3) in 1 step, therefore the answer becomes 8.

*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class NoOfSteps {


    public static void main(String[] args) {
        int i, j;
        Scanner input = new Scanner(System.in);
        int noofTestCases = input.nextInt();
        for (i = 0; i < noofTestCases; i++) {
            noofsteps();
        }
    }

    public static void noofsteps() {
        int i, j, count = 0;
        Scanner input = new Scanner(System.in);
        int nofpoints = input.nextInt();
        int xy[][] = new int[nofpoints][2];
        for (i = 0; i < nofpoints; i++) {
            for (j = 0; j < 2; j++) {
                xy[i][j] = input.nextInt();
            }
        }

        for (i = 1; i < nofpoints; i++) {
            count += (xy[i][0] - xy[i - 1][0]) + (xy[i][1] - xy[i - 1][1]);
        }
        System.out.println(count);


    }
}



/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 Scanner input = new Scanner(System.in);
		int t = Integer.parseInt(input.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(input.readLine());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i]=Integer.parseInt(inputLine[i]);
		    }

		    AND obj = new AND();

		    System.out.println(obj.maxAND(arr, n));*/