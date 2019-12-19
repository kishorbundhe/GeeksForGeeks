import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Tempstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] string1, string2;
        string1 = sc.nextLine().split(",");
        string2 = sc.nextLine().split(",");
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        for (String i :
                string1) {
            if (!i.isEmpty()) {
                list1.add(i);
            }

        }
        for (String i :
                string2) {
            if (!i.isEmpty()) {
                list2.add(i);
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);
        System.out.println(list1);
        System.out.println(list2);
        if (list1.equals(list2)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }
    }
}
