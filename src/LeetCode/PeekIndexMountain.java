package LeetCode;

public class PeekIndexMountain {
    public int peekIndexMountainArray(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                return i - 1;
            }
        }
        return 0;
    }
}
