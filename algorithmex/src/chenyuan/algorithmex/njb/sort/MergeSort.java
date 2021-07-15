package chenyuan.algorithmex.njb.sort;

/**
 * 时间复杂度NlogN, 空间复杂度NlogN
 * @author chenyuan
 */
public class MergeSort {


    static void merge(int[] arr, int[] tempArr, int left, int mid, int right) {

        int i = 0; // tempArr下标
        int l = left; // 左边arr的下标
        int r = mid + 1; // 右边arr的下标
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) tempArr[i++] = arr[l++];
            else tempArr[i++] = arr[r++];
        }

        while (l <= mid) {
            tempArr[i++] = arr[l++];
        }

        while (r <= right) {
            tempArr[i++] = arr[r++];
        }

        i = 0;
        while (left <= right) {
            arr[left++] = tempArr[i++];
        }
    }

    static void sort(int[] arr, int[] tempArr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        sort(arr, tempArr, left, mid);
        sort(arr, tempArr, mid+1, right);
        merge(arr, tempArr, left, mid, right);
    }

    static void sort(int[] arr) {
        int[] tempArr = new int[arr.length];
        sort(arr, tempArr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = Util.randomArray(100*10000);

        long s = System.currentTimeMillis();

        sort(arr);

        long e = System.currentTimeMillis();

//        System.out.println(Arrays.toString(arr));
        System.out.println("cost: " + (e - s));
    }
}
