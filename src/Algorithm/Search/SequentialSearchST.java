package Algorithm.Search;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SequentialSearchST<Key extends Comparable<Key>,Value> {
    private int N;
    private Node first;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


    /**
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException();
        first = deleteNode(first,key);
    }

    // delete key in linked list beginning at Node x,
    // warning: function call stack too large if table is large
    private Node deleteNode(Node x,Key key) {
        if(x == null) throw new IllegalArgumentException();
        //if Node x is the first Node
        if(x.key.equals(key)) {
            N--;
            return x.next;
        }

        //Problem Solved: Massive Solution,Keep in mind about how to delete a node by traversal the Linked List
        x.next = deleteNode(x.next,key);
        return x;
    }


    public void put(Key key,Value value) {
        if (value == null) throw new IllegalArgumentException();
        for(Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                x.value = value;
                return;
            }
            first = new Node(key,value,first);
            N++;
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                return x.value; //hit
            }
        }
        return null; //miss
    }



    public Iterator<Node> keys() {
        List<Node> list = new ArrayList<>();
        for (Node x = first; x.key != null; x = x.next) {
            list.add(x);
        }

        return list.iterator();
    }

}
