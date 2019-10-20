package Array;

import java.util.*;
/* By Kishor Bundhe*/
import static Array.CreatePrefixArray.prefixArrayList;

/* Given n ranges find the max element appearing in these ranges  Example l[]={1,2,5,15} and
r[]={5,8,7,18} and 0<<l[i]&&r[i] <<1000 then output will be 5 as 5 appears in the range 1 to 5 and 2to8 and 5to7
i.e is 3 times */
class Coordinate {
    int startpoint;
    int endpoint;

    Coordinate(int startpoint, int endpoint) {
        this.startpoint = startpoint;
        this.endpoint = endpoint;
    }
}


public class MaxAppearingElement {
    public static void main(String[] args) {
        System.out.println("No of ranges you want to enter");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int i = 0, left, right;
        Set<Coordinate> setsOfRanges = new HashSet<>();
        System.out.println("Enter " + size + " no of Ranges");
        while (i < size) {
            left = sc.nextInt();
            right = sc.nextInt();
            Coordinate temp = new Coordinate(left, right);
            setsOfRanges.add(temp);
            i++;
        }
        maxappearedElement(setsOfRanges);
    }



    public static void maxappearedElement(Set<Coordinate> temp) {
        int[] arr = new int[50];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : arr) {
            list.add(i);
        }

        for (Coordinate i : temp) {
            list.set(i.startpoint, list.get(i.startpoint) + 1);
            list.set(i.endpoint + 1, list.get(i.endpoint + 1) - 1);
        }
        System.out.println("list Before" + list);
        list = prefixArrayList(list);
        System.out.println("Prefix list" + list);
        int count = 0;
        List<Integer> maxlist = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++)
            if (list.get(i) == count) {
                maxlist.add(i);
                count = list.get(i);
            } else if (list.get(i) > count) {
                maxlist.clear();
                count = list.get(i);
                maxlist.add(i);
            }
        System.out.println("The list of element Occuring most i.e =" + count + " of times =" + maxlist);
    }

}

