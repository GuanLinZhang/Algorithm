package Algorithm.Chapter1;

import java.util.Iterator;

//根据栈空间,动态分配数组大小
public class ResizingArrayStack<T> implements Iterable<T> {
    private T[] arr = (T[]) new Object[1];
    private int stackLength = 0;

    public boolean isEmpty() {
        return stackLength == 0;
    }

    private void resize(int length) {
        if (stackLength == arr.length) {
            T[] temp = (T[]) new Object[length];

            System.arraycopy(arr,0,temp,0, stackLength);
            arr = temp;
        }
    }

    public int size() {
        return arr.length;
    }

    public void push(T value) {
        if (stackLength == arr.length) {
            resize(arr.length * 2);
        }
        arr[stackLength++] = value;
    }

    public T pop() {
        T temp = arr[--stackLength];
        arr[stackLength] = null;

        if (stackLength > 0 && stackLength < arr.length / 4) {
            resize(arr.length / 2);
        }

        return temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int i = stackLength;

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

