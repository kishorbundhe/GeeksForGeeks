package Competition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NearestPerfectSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            /* System.out.println(perfectSquare(n));*/
            System.out.println(MinimumNumOfSteps(n));
        }
    }

    private static int MinimumNumOfSteps(int n) {
        int noOfsteps = 0;
        double noOfbits;
        int closestPowerOf2, floorOfPowerOf2, CeilOfPowerOf2;
        noOfbits = Math.log(n);
        floorOfPowerOf2 = (int) Math.floor(noOfbits);
        CeilOfPowerOf2 = (int) Math.ceil(noOfbits);
        floorOfPowerOf2 = (int) Math.pow(2, floorOfPowerOf2);
        CeilOfPowerOf2 = (int) Math.pow(2, CeilOfPowerOf2);
        closestPowerOf2 = Math.max(floorOfPowerOf2, CeilOfPowerOf2);
        if (n == 1) {
            return 0;
        }
        while (n >= 1) {
            if ((n + 1 == closestPowerOf2) || (n - 1 == closestPowerOf2)) {
                noOfsteps = (noOfsteps + 1) + (int) Math.log(closestPowerOf2);
                return noOfsteps;
            } else if (n == closestPowerOf2) {
                noOfsteps = (noOfsteps) + 1 + (int) Math.log(closestPowerOf2);
                return noOfsteps;
            }
            if (n % 2 == 0) {
                noOfsteps++;
                n = n / 2;
            } else {
                n = n - 1;
                noOfsteps++;
            }
        }


        return noOfsteps;
    }

    private static long perfectSquare(long n) {
        double floor, ceil, sqrt;
        double distanceCeil, distanceFloor;
        sqrt = Math.sqrt(n);
        floor = Math.floor(sqrt);
        ceil = Math.ceil(sqrt);

        if (floor == ceil) {
            floor = floor - 1;
            return (long) (floor * floor);
        }
        floor = floor * floor;
        ceil = ceil * ceil;
        distanceCeil = ceil - n;
        distanceFloor = n - floor;
        if (distanceCeil < distanceFloor) {
            return (long) (ceil);
        } else {
            return (long) (floor);
        }


    }
}
