package Competition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class GFGDay1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] string = br.readLine().trim().split(" ");
            /*String string1 = br.readLine().trim();
            String string2 = br.readLine().trim();*/
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(string[i]);
            }
            /*System.out.println(ContinousSeries(arr,n));*/
            specialPrime(arr, n);
        }
        /*manipulator(string1, string1.length(), string2, string2.length());*/


    }

    private static void specialPrime(int[] arr, int size) {
        ArrayList<Integer> listofIndex = new ArrayList<Integer>();
        ArrayList<Integer> listSpecialPrime = new ArrayList<Integer>();
        int i = 0, listsize;
        for (; i < size; i++) {
            if (isPrimeOrNot(arr[i]) && isPrimeOrNot(arr[i] - 2)) {
                listofIndex.add(i);
                listSpecialPrime.add(arr[i]);
            }
        }
        Collections.sort(listSpecialPrime);
        listsize = listSpecialPrime.size();
        for (i = 0; i < listsize; i++) {
            arr[listofIndex.get(i)] = listSpecialPrime.get(i);
        }
        StringBuilder result = new StringBuilder();
        for (i = 0; i < size; i++) {
            result.append(arr[i] + " ");
        }
        System.out.println(result.toString().trim());

    }


    private static boolean isPrimeOrNot(int number) {
        if (number < 2) {
            return false;
        }
        int i = 2;
        int limit = (int) (Math.sqrt(number) + 1);
        for (; i < limit; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void manipulator(String string1, int string1size, String string2, int string2size) {

        if (string1size == 1 && string2size == 1) {
            if (string1.equalsIgnoreCase(string2)) {
                System.out.print("Yes");
                return;
            } else {
                System.out.print("No");
                return;
            }
        }
        StringBuilder stringBuilder1 = sub(string1, string1size);
        StringBuilder stringBuilder2 = sub(string2, string2size);

        stringBuilder1 = sub(string1, string1size);
        stringBuilder2 = sub(string2, string2size);

        if (stringBuilder1.toString().equalsIgnoreCase(stringBuilder2.toString())) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }

    public static StringBuilder sub(String str, int size) {
        int i, j = 0, count = 0;
        int N = 26;
        StringBuilder returnedstring = new StringBuilder();
        for (i = 1; i < size; i++) {
            if (str.charAt(i) == '#') {
                count++;
            } else {
                returnedstring.append((char) ((((str.charAt(j) - 'A') + count) % N) + 'A'));
                j = i;
                count = 0;
            }

        }
        returnedstring.append((char) ((((str.charAt(j) - 'A') + count) % N) + 'A'));
        return returnedstring;

    }


}
