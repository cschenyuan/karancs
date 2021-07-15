package chenyuan.algorithmex.njb.bigdata.e1;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author chenyuan
 */
public class FindTopDuplicateWithHash {

    private final static int _NP = 16;

    static void partition(String bigdataFile) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(bigdataFile, "r");
        long length = raf.length();
        String s;
        while ((s = raf.readLine()) != null) {
        }
    }

    public static void main(String[] args) {
        /*
        1. 将大文件用hash函数分割为16个小文件
        2. 依次对每个小文件进行处理，统计出出现次数最高的数
        3. 比较16个文件中出现次数最高的数，即为出现次数最高的数
         */
    }
}
