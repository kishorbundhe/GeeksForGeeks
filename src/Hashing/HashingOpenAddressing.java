package Hashing;

/*
 * -1 denotes empty
 * -2 denotes deleted */
class HashOpenAddress {
    int cap = 17;//default size
    int size = 0;
    int[] table;


    public HashOpenAddress() {
        table = new int[cap];
        for (int i = 0; i < cap; i++) {
            table[i] = -1;
        }
    }

    void insert(int key) {
        if (size > cap) {
            System.out.println(" Hash Table is full ");
            return;
        }
        int i;
        for (i = hash(key); table[i] != -1 && table[i] != -2 && table[i] != key; ) {
            i = (i + 1) % cap;
        }
        size++;
        table[i] = key;
    }

    int hash(int key) {
        return key % cap;
    }

    void delete(int key) {
        int i, j;
        for (i = hash(key), j = i; table[i] != -1 && j == i; ) {
            if (table[i] == key) {
                size--;
                table[i] = -2;
            }
            i = (i + 1) % cap;
        }
    }

    boolean search(int key) {
        if (size > 0) {
            int i, j;
            for (i = hash(key), j = i; table[i] != -1 && j == i; ) {
                if (table[i] == key) return true;
                i = (i + 1) % cap;
            }
        }
        return false;
    }

}

public class HashingOpenAddressing {
    public static void main(String[] args) {
        HashOpenAddress hastableo = new HashOpenAddress();
        hastableo.insert(12);
        hastableo.insert(20);
        hastableo.insert(23);
        hastableo.delete(23);
        System.out.println(hastableo.search(12));
        System.out.println(hastableo.search(23));
    }
}
