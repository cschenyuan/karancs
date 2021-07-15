package chenyuan.algorithmex.njb.sort;

import java.util.Random;

/**
 * @author chenyuan
 */
public class Util {

    static int[] randomArray(int length) {
        if (length <= 0 ) return new int[0];

        int[] arr = new int[length];

        Random random = new Random();
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = random.nextInt(length);
        }

        return arr;
    }

    static int[] randomArray1W() {
        return randomArray(10000);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
