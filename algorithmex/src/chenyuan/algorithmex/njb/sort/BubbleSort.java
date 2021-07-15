package chenyuan.algorithmex.njb.sort;

import java.util.Arrays;

/**
 * 时间复杂度O(N^2)
 * @author chenyuan
 */
public class BubbleSort {

    static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length; i ++) { /**/
            for (int j = 0;  j < arr.length - i -1; j ++) { /**/
                if (arr[j+1] < arr[j]) {
                    Util.swap(arr, j, j+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 3, 8, 7};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
