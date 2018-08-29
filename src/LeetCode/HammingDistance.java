package LeetCode;

public class HammingDistance {
    public int hammingDistance(int x,int y) {
        int res = x ^ y;
        String byteString = Integer.toBinaryString(res);

        int count = 0;
        for (int i = 0; i < byteString.length(); i++) {
            if (byteString.charAt(i) == '1') {
                count++;
            }
        }

        return count;
    }
}
