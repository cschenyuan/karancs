package chenyuan.algorithmex.njb.datastructure.heap;

import chenyuan.algorithmex.njb.datastructure.bitmap.GetNumberAtBigIntArray;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用小根堆求TopK
 * @author chenyuan
 */
public class TopKWithMinHeap {

    private static final String DIR = "./algorithmex/src/" + GetNumberAtBigIntArray.class.getPackage().getName().replaceAll("\\.", "/");

    public static void main(String[] args) throws IOException {
        final int k = 100;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        RandomAccessFile raf = new RandomAccessFile(DIR + "/big_int_array.txt", "r");

        long st = System.currentTimeMillis();
        String s;
        while ((s = raf.readLine()) != null) {
            int number = Integer.parseInt(s);
            if (minHeap.size() < k) {
                minHeap.add(number);
            } else {
                if (number > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(number);
                }
            }
        }

        ConcurrentHashMap
        System.out.println("cost: " + (System.currentTimeMillis() - st));
        System.out.println(Arrays.toString(minHeap.toArray(new Integer[0])));
    }
}
