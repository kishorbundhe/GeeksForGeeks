package Practice;

/*Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[])
that prints all occurrences of pat[] in txt[].*/
public class RollingHash {

    public static void main(String[] args) {
        String str = "abcabcabc";
        String pattern = "abc";
        RollingHash(str, pattern);
    }

    public static void RollingHash(String str, String pattern) {
        int stringSize = str.length();
        int patternSize = pattern.length();
        int hash = 0, currentHash = 0, i;

        if (patternSize > stringSize) {
            return;
        }
        for (i = 0; i < patternSize; i++) {
            hash += (pattern.charAt(i) - 'a') + 1;
            currentHash += (str.charAt(i) - 'a') + 1;
        }
        if (hash == currentHash) {
            System.out.println(str.substring(0, patternSize));
        }
        for (i = 1; (i + patternSize - 1) < stringSize; i++) {
            currentHash += str.charAt(patternSize + i - 1) - 'a' - (str.charAt(i - 1) - 'a');
            if (currentHash == hash) {
                System.out.println(str.substring(i, i + patternSize));

            }


        }
    }
}

