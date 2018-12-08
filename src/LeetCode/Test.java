package LeetCode;

import Algorithm.Search.BST;

public class Test {
    public static void main(String[] args) {
        var ts = new BST<String,Integer>();

        ts.put("hello", 1);
        ts.put("fuck",2);
        ts.put("what",4);
        ts.put("jason",3);
        ts.put("oscar", 5);
        ts.put("macan", 6);

        //ts.preOrderTraversal();
        //ts.reverse();

        for (var index : ts.keys()) {
            System.out.println(index);
        }
    }


}
