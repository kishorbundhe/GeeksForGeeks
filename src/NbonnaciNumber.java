import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Print the first M N-bonnaci Number */
public class NbonnaciNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println("Enter the N-bonnacci Number");
        int N = sc.nextInt();
        System.out.println("Enter the no of terms M ");
        int M = sc.nextInt();
        bonnacci(N, M);
    }

    public static void bonnacci(int n, int m) {
        int i = 0, sum = 1;
        List<Integer> series = new ArrayList<Integer>();
        while (i < n - 1) {

            series.add(0);
            i++;
        }
        series.add(1);
        for (i = 0; i < (m - n); i++) {
            series.add(sum);
            sum += sum - series.get(i);
        }
        System.out.println(series);
    }


}
