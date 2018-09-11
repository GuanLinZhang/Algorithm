package Algorithm.Chapter1;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int a[] = {-11,22,11,-22,32,44,66,17,33,55};
        var example = new NSum(a);

        int result = example.ThreeSumFast();
        System.out.println(result);
    }
}
