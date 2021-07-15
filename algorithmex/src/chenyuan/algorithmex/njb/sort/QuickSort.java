package chenyuan.algorithmex.njb.sort;

import java.util.Arrays;

import static chenyuan.algorithmex.njb.sort.Util.swap;

/**
 * @author chenyuan
 */
public class QuickSort {

    static void sort(int[] arr, int low, int high) {

        int pivot = arr[low];

        int start = low;
        int end = high;

        while (end > start) { //
            // 从后往前比较
            while (end > start && arr[end] >= pivot) {
                end --;
            }
            // 遇到第一个比pivot小的，交换位置，然后从前往后找
            swap(arr, start, end);

            // 从前往后比较
            while (end > start && arr[start] <= pivot) {
                start ++;
            }
            // 遇到第一个比pivot大的，交换位置
            swap(arr, start, end);
       }

        if (start > low) sort(arr, low, start - 1);
        if (end < high) sort(arr, end + 1, high);
    }

    static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = Util.randomArray(10 * 100000);
//        System.out.println(Arrays.toString(arr));

        long s = System.currentTimeMillis();

        sort(arr);

        long e = System.currentTimeMillis();

//        System.out.println(Arrays.toString(arr));
        System.out.println("cost: " + (e - s));
    }
}
