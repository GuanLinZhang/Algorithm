package Algorithm.Chapter1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<E> implements Iterable<E> {
    private int n;
    private Node first;

    private class Node {
        private E elem;
        private Node next;
    }

    public Stack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int Size() {
        return n;
    }

    public void push(E elem) {
        Node oldNode = first;
        first = new Node();
        first.elem = elem;
        first.next = oldNode;
        n++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            E elem = first.elem;
            first = first.next;
            n--;
            return elem;
        }
    }

    public void traversal() {
        for (E elem : this) {
            System.out.println(elem);
        }
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.elem;
    }

    @Override
    public String toString() {
        var stringBuilder = new StringBuilder();

        for (E elem : this) {
            stringBuilder.append(elem);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current.next == null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                E elem = current.elem;
                current = current.next;
                return elem;
            }
        }

    }
}
