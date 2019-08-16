public class Temp {
    public static void main(String[] args) {
        String str[] = new String[2];
        int idx = 0;
        for (String s : str) {
            str[idx].concat("Element" + idx);
        }
        for (idx = 0; idx < str.length; idx++) {
            System.out.println(str[idx]);

        }
//        System.out.println(str.equals("")+"----"+str.isEmpty());
    }
}
