package chenyuan.algorithmex.njb.sort;

import java.util.Arrays;

/**
 * @author chenyuan
 */
public class InsertSort {

    static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 1; i < arr.length; i ++) {

            int insertVal = arr[i];

            int index = i - 1;
            while (index >= 0 && insertVal < arr[index]) { // 找到要插入的位置，同时将元素向左移动
                arr[index+1] = arr[index];
                index --;
            }

            arr[index + 1] = insertVal;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 9, 1, 3, 3, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
