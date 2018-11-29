package Algorithm.Search;

import java.util.NoSuchElementException;
import Algorithm.Fundamental.Queue;

// In Ordered
public class BinarySearchST<Key extends Comparable<Key>,Value> {
    private static int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST() {
        this(INIT_CAPACITY);
    }

    public BinarySearchST(int INIT_CAPACITY) {
        keys = (Key[]) new Comparable[INIT_CAPACITY];
        values = (Value[]) new Object[INIT_CAPACITY];
    }

    // resize the underlying arrays
    private void resize(int capacity) {
/*      Key[] tempk = (Key[]) new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        values = tempv;
        keys = tempk;
*/
        Key[] tempK = (Key[]) new Comparable[capacity];
        Value[] tempV = (Value[]) new Object[capacity];
        System.arraycopy(keys,0,tempK,0,N);
        keys = tempK;
        System.arraycopy(values,0,tempV,0,N);
        values = tempV;
    }

    public int size() {
        return N;
    }

    public int size(Key low,Key high) {
        if(low == null || high == null) throw new IllegalArgumentException();

        if (low.compareTo(high) > 0) return 0;
        if(contains(high)) return rank(high) - rank(low) + 1;
        else return rank(high) - rank(low);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException();
        return get(key) != null;
    }

    public Value get(Key key) {
        if(key == null) throw new IllegalArgumentException();

        if(isEmpty()) return null;
        int i = rank(key);
        if(i < N && keys[i].equals(key)) return values[i];
        return null;
    }

    public void put(Key key,Value value) {
        if(key == null) throw new IllegalArgumentException();

        if (value == null) {
            delete(key);
            return;
        }
        //get the position of key
        int i = rank(key);


        //if has the same key,then update the value;
        if(i < N && keys[i].compareTo(key) == 0) {
            values[i]= value;
            return;
        }

        if(N == keys.length) resize(INIT_CAPACITY * 2);

        for(int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }

        keys[i] = key;
        values[i] = value;
        N++;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException();

        int i = rank(key);
        if (i == N || keys[i].compareTo(key) == 0) {
            return;
        }

        for(int j = i; j < N; j--) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }

        N--;
        keys[i] = null;
        values[i] = null;

        if(N > 0 && N == keys.length / 4) resize(keys.length / 2);
    }

    public void deleteMax() {
        if (isEmpty()) throw new IllegalArgumentException();
        delete(max());
    }

    public void deleteMin() {
        if (isEmpty()) throw new IllegalArgumentException();
        delete(min());
    }

    public Key select(int k) {
        if(k < 0 || k > size()) throw new IllegalArgumentException();
        return keys[k];
    }

    private int rank(Key key) {
        int low = 0,high = N - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = keys[mid].compareTo(key);

            switch (cmp) {
                case 0:
                    return mid;
                case 1:
                    low = mid + 1;
                    continue;
                case 2:
                    high = mid - 1;
            }
        }
        return low;
    }

    public Key max() {
        if (isEmpty()) throw new IllegalArgumentException();
        return keys[N - 1];
    }

    public Key min() {
        if (isEmpty()) throw new IllegalArgumentException();
        return keys[0];
    }

    /**
     * Returns the largest key in this symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in this symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        if(key == null) throw new IllegalArgumentException("argument to floor() is null");
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0) return keys[i];
        if(i == 0) return null;
        else return keys[i - 1];
    }

    /**
     * Returns the smallest key in this symbol table greater than or equal to {@code key}.
     *
     * @param  key the key
     * @return the smallest key in this symbol table greater than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null} y
     */
    public Key ceil(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceil() is null");
        int i = rank(key);
        //TODO:Why don't need this sentence;
        //if(i < N && keys[i].compareTo(key) == 0) return keys[i];
        if(i == 0) return null;
        else return keys[i];
    }


    public Iterable<Key> keys(Key low,Key high) {
        var queue = new Queue<Key>();

        var highIndex = rank(high);

        for (int i = rank(low); i < highIndex ; i++) {
            queue.enQueue(keys[i]);
            if (contains(high)) {
                queue.enQueue(keys[highIndex]);
            }
        }
        return queue;
    }
}
