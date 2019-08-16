import java.lang.reflect.Array;

public class Anagram {

    public static void main(String[] args) {
        boolean isanagram=Anagram("earth", "bateh");
        System.out.print(isanagram);
    }

    private static boolean Anagram(String one, String two) {
        int abcz[] = new int[26];

        one = one.toLowerCase();
        two = two.toLowerCase();
        int sum = 0;
        char[] first, second;
        first = one.toCharArray();
        second = two.toCharArray();
        if (one.length() != two.length()) {
            return false;
        } else

            for (char i : first) {
                int j = (int) i - 97;
                abcz[j] = 1;
            }

        for (char i : second) {
            int j = (int) i - 97;
            abcz[j] = 0;
        }

        for (int i :
                abcz) {
            sum += i;

        }
        if (sum == 0) {
            return true;
        } else {
            return false;
        }
    }



}

