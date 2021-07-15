package chenyuan.algorithmex.njb.sort;

import java.util.Arrays;

import static chenyuan.algorithmex.njb.sort.Util.swap;

/**
 * @author chenyuan
 */
public class ShellSort {

    static void sort(int[] arr) {
        int N = arr.length;
        int h = 1;
        while (h < N/3) {
            h = 3*h + 1; // 1, 4, 13, 40, 121, 364, 1093 ...
        }

        while (h >= 1) {
            for (int i = h; i < N; i ++) {
                for (int j = i; j >= h && arr[j] < arr[j-h]; j -= h) {
                    swap(arr, arr[j], arr[j-h]);
                }
            }
            h = h/3;
        }
    }

    public static void main(String[] args) {
        int[] arr = Util.randomArray(10*100000);

        long s = System.currentTimeMillis();

        sort(arr);

        long e = System.currentTimeMillis();

//        System.out.println(Arrays.toString(arr));
        System.out.println("cost: " + (e - s));
    }

}
