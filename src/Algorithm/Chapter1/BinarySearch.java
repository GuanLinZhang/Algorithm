package Algorithm.Chapter1;

//二分查找
// P.S. java.util.Array.sort() first
public class BinarySearch {
    //递归实现
    public int rank(int arr[],int value,int low,int high) {
        if (low <= high) {
                int mid = low + (high - low) / 2;
            if  (value > arr[mid]) {
                low = mid + 1;
                return rank(arr,value,low,high);
            } else if (value < arr[mid]) {
                high = mid - 1;
                return rank(arr,value,low,high);
            } else return mid;
        }
        return -1;
    }
}
