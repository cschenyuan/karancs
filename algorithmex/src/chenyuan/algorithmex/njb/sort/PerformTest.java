package chenyuan.algorithmex.njb.sort;

import java.util.Arrays;

/**
 * @author chenyuan
 */
public class PerformTest {

    static int[] copy(int[] src) {
        int[] arr = new int[src.length];
        System.arraycopy(src, 0, arr, 0, src.length);
        return arr;
    }

    public static void main(String[] args) {
        int[] src = Util.randomArray(10 * 100000);

        int[] arr;

        // 10W: 20s+
        arr = copy(src);
        long s = System.currentTimeMillis();
        BubbleSort.sort(arr);
        System.out.println("bubble sort cost: " + (System.currentTimeMillis() - s));

        // 10W: 1.3s+
        // 100W: 170s+
        arr = copy(src);
        s = System.currentTimeMillis();
        InsertSort.sort(arr);
        System.out.println("insert sort cost: " + (System.currentTimeMillis() - s));

        // 10W: 0.024s
        // 100W: 0.255s
        arr = copy(src);
        s = System.currentTimeMillis();
        ShellSort.sort(arr);
        System.out.println("shell sort cost: " + (System.currentTimeMillis() - s));

        // 10W: 0.022s
        // 100W: 0.196s
        arr = copy(src);
        s = System.currentTimeMillis();
        MergeSort.sort(arr);
        System.out.println("merge sort cost: " + (System.currentTimeMillis() - s));

        // 10W: 0.054s
        // 100W: 0.362s
        arr = copy(src);
        s = System.currentTimeMillis();
        Arrays.sort(arr);
        System.out.println("Dual-Pivot QuickSort cost: " + (System.currentTimeMillis() - s));

    }
}
