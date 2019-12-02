package Practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*Given a String like i.am.terrorRuntime print the output as terrorRuntime.am.i*/
public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        String Input = sc.nextLine();
        List<String> temporary = new ArrayList<String>();

        temporary = Arrays.asList(Input.split("\\."));
        int size = temporary.size();
        for (i = size - 1; i >= 0; i--) {
            System.out.print(temporary.get(i) + ".");
        }
    }

}
