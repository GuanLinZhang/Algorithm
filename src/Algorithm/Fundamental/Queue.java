package Algorithm.Fundamental;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<E> implements Iterable<E> {
    private class Node {
        E elem;
        Node next;
    }

    public int N;
    public Node first;
    public Node last;

    public Queue() {
        first = null;
        last = null;
        N = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enQueue(E elem) {
        Node oldNode = last;
        last = new Node();
        last.elem = elem;
        last.next = null;
        if (isEmpty()) first = last;
        else oldNode.next = last;
        N++;
    }

    public E deQueue() {
        if (isEmpty()) throw new NoSuchElementException();
        E elem = first.elem;
        first = first.next;
        N--;
        return elem;
    }

    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E> {
        private Node current = first;

        @Override
        public boolean hasNext() {
           return current != null;
        }

        @Override
        public E next() {
            E elem = current.elem;
            current = current.next;
            return elem;
        }
    }
}
