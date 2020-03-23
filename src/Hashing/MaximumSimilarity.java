package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* case
* 1
S = bdacdaba
T = ababc
* we need to find how after Shuffling T , largest number String which matches with S.
* Given
* */
public class MaximumSimilarity {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < testcase; t_i++) {
            String S = br.readLine();
            String T = br.readLine();

            int out_ = Maximum(S, T);
            int out = MaximumKishor(S, T);
            System.out.println(out);
            System.out.println(out_);
        }


    }

    static int MaximumKishor(String S, String T) {
        int i = 0, sLength = S.length(), tLength = T.length(), count = 0, hashSize;
        Character temp;
        // Write your code here
        hashSize = Math.min(tLength, sLength);
        HashMap<Character, Integer> charcterMapping = new HashMap<>();
        for (; i < hashSize; i++) {
            temp = S.charAt(i);
            if (charcterMapping.containsKey(temp)) {
                charcterMapping.put(temp, charcterMapping.get(temp) + 1);
            } else {
                charcterMapping.put(temp, 1);
            }
        }
        for (i = 0; i < tLength; i++) {
            temp = T.charAt(i);
            if (charcterMapping.containsKey(temp)) {
                count++;
                if (charcterMapping.get(temp) - 1 == 0) {
                    charcterMapping.remove(temp);
                } else {
                    charcterMapping.put(temp, charcterMapping.get(temp) - 1);
                }
            }
        }
        return count;
    }

    static int Maximum(String S, String T) {
        int total = 0, up = 0, down = up, tlength = T.length();
        char swap;
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        while (down < tlength) {
            if (s[up] == t[down] && up == down) {
                total++;
                up++;
                down = up;
            } else if (s[up] == t[down] && up != down) {
                total++;
                swap = t[up];
                t[up] = t[down];
                t[down] = swap;
                up++;
                down = up;
            } else
                down++;
        }
        return total;
    }
}
