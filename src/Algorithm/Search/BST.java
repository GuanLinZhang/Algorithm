package Algorithm.Search;

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>,Value> {
    private Node root;

    private class Node {
        private Key key;           // sorted by key
        private Value value;         // associated data
        private Node left, right;  // left and right subtrees
        private int N;          // number of nodes in subtree

        public Node(Key key, Value val,int N) {
            this.key = key;
            this.value = val;
            this.N = N;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    public void put(Key key,Value value) {
        root = put(root,key,value);
    }

    private Node put(Node x, Key key, Value value) {
        if(x == null) return new Node(key,value,1);
        int cmp = key.compareTo(x.key);

        if     (cmp < 0) x.left = put(x.left,key,value);
        else if(cmp > 0) x.right = put(x.right, key, value);
        else             x.value = value;

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Value get(Key key) {
        return get(root,key);
    }

    private Value get(Node x, Key key) {
        if(x == null) return null;
        int cmp = key.compareTo(x.key);

        if     (cmp < 0) return get(x.left,key);
        else if(cmp > 0) return get(x.right,key);
        else             return x.value;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if(x.left == null) return x;
        return min(x.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if(x.right == null) return x;
        return max(x.right);
    }

    public Key floor(Key key) {
        Node x = floor(root,key);
        return x == null ? null : x.key;
    }

    private Node floor(Node x, Key key) {
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) return floor(x.left, key);
        if(cmp == 0) return x;
        //key is bigger than x.key,search in the right of subTree
        Node t = floor(x.right, key);
        //Have a node that smaller than x.right, so return this node
        if(t != null) return t;
        //return itself
        else return x;
    }

    public Key ceil(Key key) {
        Node x = ceil(root,key);
        return x == null ? null : x.key;
    }

    private Node ceil(Node x, Key key) {
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp > 0)    return floor(x.right,key);
        if(cmp == 0)   return x;
        Node t = floor(x.left,key);
        if(t != null)   return t;
        else            return x;
    }

    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("St is empty");
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);     //finalize(x.right)
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        if(isEmpty()) throw new NoSuchElementException("St is empty");
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if(x.right == null) return x.left;
        x.right = deleteMax(x.right);       //finalize(x.right)
        x.N = size(x.left) + size(x.right);
        return x;
    }

    public Key select(int k) {
        return select(root,k).key;
    }

    private Node select(Node x, int k) {
        if(x == null) return null;
        int t = size(x.left);
        if      (t > k) return select(x.left,k);
        else if (t < k) return select(x.right,k-t-1);
        else            return x;
    }

    public int rank(Key key) {
        return rank(key,root);
    }

    private int rank(Key key, Node x) {
        if(x == null) return 0;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return rank(key,x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key,x.right);
        else              return size(x.left);
    }
}
