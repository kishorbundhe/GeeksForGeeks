package Array;

import java.util.ArrayList;

public class CreatePrefixArray {
    /*Creating Prefix Array*/
    public static int[] prefixArray(int[] array) {
        int sum = 0;
        int[] prefixArray = new int[array.length];
        prefixArray[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            prefixArray[i] = prefixArray[i - 1] + array[i];
        }
        return prefixArray;
    }

    /*Creating Prefix ArrayList*/
    public static ArrayList prefixArrayList(ArrayList<Integer> temp) {

        ArrayList<Integer> prefixList = new ArrayList<Integer>(50);
        prefixList.add(temp.get(0));
        for (int i = 1; i < temp.size(); i++) {
            prefixList.add(i, prefixList.get(i - 1) + temp.get(i));
        }
        return prefixList;
    }
}
