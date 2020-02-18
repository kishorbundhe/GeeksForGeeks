package Competition;

import java.io.IOException;
import java.util.Scanner;

public class SLAB {
    public static void main(String[] args) throws IOException {
        Scanner br = new Scanner(System.in);
        int t = br.nextInt();

        while (t-- > 0) {
            int n = br.nextInt();
            slabcal(n);
        }
    }

    private static void slabcal(int salary) {
        int tax = 0, copyOfSalary = salary;

        while (true) {

            if (copyOfSalary <= 250000) {

                break;
            } else if (copyOfSalary <= 500000) {
                tax += 0.05 * (copyOfSalary - 250000);
                copyOfSalary = 250000;

            } else if (copyOfSalary <= 750000) {
                tax += (copyOfSalary - 500000) * 0.1;
                copyOfSalary = 500000;

            } else if (copyOfSalary <= 1000000) {
                tax += (copyOfSalary - 750000) * 0.15;
                copyOfSalary = 750000;

            } else if (copyOfSalary <= 1250000) {
                tax += (copyOfSalary - 1000000) * 0.2;
                copyOfSalary = 1000000;
            } else if (copyOfSalary <= 1500000) {
                tax += (copyOfSalary - 1250000) * 0.25;
                copyOfSalary = 1250000;
            } else {
                tax += (copyOfSalary - 1500000) * 0.3;
                copyOfSalary = 1500000;
            }

        }

        System.out.println(salary - tax);
    }
}
