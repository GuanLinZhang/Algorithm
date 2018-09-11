package Algorithm.Chapter1;

import java.util.Iterator;

//根据栈空间,动态分配数组大小
public class ResizingArrayStack<T> implements Iterable<T> {
    private T[] arr = (T[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    private void resize(int length) {
        if (N == arr.length) {
            T[] temp = (T[]) new Object[length];

            System.arraycopy(arr,0,temp,0, N);
            arr = temp;
        }
    }

    public int size() {
        return arr.length;
    }

    public void push(T value) {
        if (N == arr.length) {
            resize(arr.length * 2);
        }
        arr[N++] = value;
    }

    public T pop() {
        T temp = arr[--N];
        arr[N] = null;

        if (N > 0 && N < arr.length / 4) {
            resize(arr.length / 2);
        }

        return temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return arr[--i];
        }
    }
}

