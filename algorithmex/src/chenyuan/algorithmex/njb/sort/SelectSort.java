package chenyuan.algorithmex.njb.sort;

import java.util.Arrays;

import static chenyuan.algorithmex.njb.sort.Util.swap;

/**
 * 选择排序，时间复杂度O(n^2)，空间复杂度O(1)
 * @author chenyuan
 */
public class SelectSort {

    static void sort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }

        for (int i = 0; i < arr.length; i ++) {
            int min = i;

            // 寻找最小值
            for (int j = i; j < arr.length; j ++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // 交换
            swap(arr, min, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 9, 1, 3, 3, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
