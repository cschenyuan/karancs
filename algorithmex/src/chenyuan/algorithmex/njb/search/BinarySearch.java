package chenyuan.algorithmex.njb.search;

/**
 * 时间复杂度O(logN)
 * @author chenyuan
 */
public class BinarySearch {

    static int search(int[] arr, int e) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (high + low)/2;
            if (e > arr[mid]) { // 在右边
                low = mid + 1;
            } else if (e < arr[mid]) { // 在左边
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 9};
        int[] arr1 = {1, 3, 5, 6, 7, 9};

        int pos = search(arr, 4);
        System.out.println("pos: " + pos);
    }
}
