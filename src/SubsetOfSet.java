import java.util.ArrayList;
import java.util.Scanner;


public class SubsetOfSet {
    static ArrayList<String> subsetlist = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
        System.out.println(Subset("ABCD"));


    }

    public static ArrayList<String> Subset(String str) {
        int index = -1;
        String Current = "";
        return Subset1(str, index, Current);

    }

    public static ArrayList<String> Subset1(String str, int index, String current) {

        if (index == str.length() - 1) {
            subsetlist.add(current);
            return subsetlist;
        }
        Subset1(str, index + 1, current + str.charAt(index + 1));
        Subset1(str, index + 1, current);
        return subsetlist;
    }

}
