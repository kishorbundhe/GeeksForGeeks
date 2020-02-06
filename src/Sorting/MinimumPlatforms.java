package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*Given arrival and departure times of all trains that reach a railway station.
Your task is to find the minimum number of platforms required for the railway station so that no train waits.

Note: Consider that all the trains arrive on the same day and leave on the same day.
 Also, arrival and departure times will not be same for a train, but we can have arrival time of one train equal
  to departure of the other.*/
public class MinimumPlatforms {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String[] str = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);

            int[] arr = new int[n];
            int[] dep = new int[n];

            str = read.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);

            System.out.println(findPlatform(arr, dep, n));
        }
    }

    static int findPlatform(int[] arr, int[] dep, int n) {

        int i = 0, j = 0, count = 1;
        int firstToDepart;

// Can be done without creating classes just using Arrays.sort but used to learn concept of comparator
        ArrayList<Timings> arrivals = new ArrayList<>();
        ArrayList<Timings> departures = new ArrayList<>();
        for (; i < n; i++) {
            arrivals.add(new Timings(arr[i], dep[i]));
            departures.add(new Timings(arr[i], dep[i]));
        }
        // sorting the arraylists
        Collections.sort(arrivals, new sortArrivals());
        Collections.sort(departures, new sortDeparture());
        for (Timings time : arrivals
        ) {
            System.out.print(time.arrival + " ");
        }
        System.out.println("\n");
        for (Timings time : arrivals
        ) {
            System.out.print(time.departure + " ");
        }
        System.out.println("\n");
        for (Timings time : departures
        ) {
            System.out.print(time.departure + " ");
        }


        i = 1;
        System.out.println("\n");
        firstToDepart = departures.get(j).departure;
        for (; i < n; i++) {
            if (arrivals.get(i).arrival >= firstToDepart) {
                System.out.println(arrivals.get(i).arrival + " ------- " + firstToDepart);
                j++;
                firstToDepart = departures.get(j).departure;
            } else {
                System.out.println(arrivals.get(i).arrival + " first to departure " + firstToDepart);
                count++;
//                firstToDepart = Math.max(ar.get(i).departure, firstToDepart);
            }
        }
        // Sorting the collections
        return count;
    }
}

class Timings {

    int arrival, departure;

    Timings(int arrival, int departure) {
        this.arrival = arrival;
        this.departure = departure;
    }
}

class sortArrivals implements Comparator<Timings> {
    public int compare(Timings a, Timings b) {
        return a.arrival - b.arrival;
    }
}

class sortDeparture implements Comparator<Timings> {
    public int compare(Timings a, Timings b) {
        return a.departure - b.departure;
    }
}