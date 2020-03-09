package Hashing;

import java.util.ArrayList;
import java.util.Objects;

class HashChaining {
    int BUCKETSIZE = 17;//default size
    int size = 0;
    ArrayList<Object>[] table;

    public HashChaining(int b) {
        BUCKETSIZE = b;
        table = new ArrayList[BUCKETSIZE];
    }

    public HashChaining() {
        table = new ArrayList[BUCKETSIZE];
    }

    void insert(Object key) {
        if (!search(key)) {
            size++;
            int index = hash(key);
            table[index] = new ArrayList<>();
            table[index].add(key);
        }

    }

    int hash(Object key) {
        int index = Objects.hashCode(key) % BUCKETSIZE;
        return index;
    }

    void delete(Object key) {
        if (search(key)) {
            size--;
            int index = hash(key);
            table[index].remove(key);
        }

    }

    boolean search(Object key) {
        int index = hash(key);
        ArrayList<Object> searchList = new ArrayList<>();
        searchList = table[index];
        if (Objects.isNull(searchList)) {
            return false;
        }
        for (Object o : table[index]) {
            if (o.equals(key)) {
                return true;
            }
        }
        return false;
    }

}

public class HashChainingImplementation {
    public static void main(String[] args) {
        //  Implementing the hash tabl
        HashChaining hastable = new HashChaining();
        hastable.insert(12);
        hastable.insert(20);
        hastable.insert(21);
        System.out.println(hastable.search(12));
        hastable.delete(21);
        System.out.println(hastable.search(21));
    }
}