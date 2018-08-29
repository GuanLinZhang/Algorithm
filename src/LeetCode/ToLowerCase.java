package LeetCode;

public class ToLowerCase {
    public String toLowerCase(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int ascNum = arr[i];
            if (ascNum >= 65 && ascNum <= 90) {
                ascNum += 32;
                arr[i] = (char) ascNum;
            }
        }
        return new String(arr);
    }
}
