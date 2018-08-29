package LeetCode;

public class FlipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            //flip
            A[i] = flip(A[i]);
            //invert
            A[i] = invert(A[i]);
        }
        return A;
    }

    private int[] flip(int[] arr) {
        //声明两个游标,一个从数组首元素,一个从数组末尾元素开始遍历数组,直到他们相遇
        for (int i = 0, j = arr.length - 1; i < arr.length && j > 0; i++, j--) {
            //如果两个游标重叠或者左游标跑到了右边,则结束遍历
            if (i == j || i - 1 == j) {
                break;
            }
            //交换两个变量的值
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    private int[] invert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //与 1 XOR,相同为0 互异为1
            arr[i] ^= 1;
        }
        return arr;
    }
}
