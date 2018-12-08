package LeetCode;

/*
    No.905
    给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。

    你可以返回满足此条件的任何数组作为答案。

 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        sortArrayByParity(0,A.length - 1, A);
        return A;
    }

    private void sortArrayByParity(int low,int high,int[] A) {
        if(low >= high) return;
        int j = partition(low, high, A);
        sortArrayByParity(low,j - 1,A);
        sortArrayByParity(j + 1, high, A);
    }

    private void exchange(int i,int j,int[] A) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private int partition(int low,int high,int[] A) {
        int i = low - 1,j = high + 1;
        while (true) {
            while (A[++i] % 2 == 0) if(i == high) break;
            while (A[--j] % 2 != 0) if(j == low) break;
            if(i >= j) break;
            exchange(i,j,A);
        }
        return i;
    }
}
