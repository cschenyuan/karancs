package chenyuan.algorithmex.njb.datastructure.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author chenyuan
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(3);
        queue.add(2);
        queue.add(4);

        System.out.println(Arrays.toString(queue.toArray(new Integer[0])));
    }
}
