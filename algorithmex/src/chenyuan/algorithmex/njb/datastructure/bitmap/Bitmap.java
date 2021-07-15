package chenyuan.algorithmex.njb.datastructure.bitmap;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyuan
 */
public class Bitmap {

    public static Bitmap loadFromFile(File bitmapFile, int length) {
        Bitmap bm = new Bitmap(length);
        byte[] buff = new byte[8192];
        int len;
        int n = 0;
        try (InputStream input = new FileInputStream(bitmapFile)) {
            while ((len = input.read(buff)) != -1) {
                System.arraycopy(buff, 0, bm.bits, n, len);
                n += len;
            }
//            bm.length = n*8192*8;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bm;
    }

    private byte[] bits;

    private int length;

    private Bitmap() {}

    public Bitmap(int length) {
        this.length = length;
        this.bits = new byte[length%8 == 0 ? length/8 : length/8 + 1];
    }

    public boolean get(int n) {
        int row = n >> 3;
        int temp = bits[row];
        int i = n & 7;

        if (((temp >>> (7-i)) & 1) == 0) {
            return false;
        }
        return true;
    }

    public void set(int n, boolean value) {
        int row = n >>> 3;
        byte temp = bits[row];
        int i = n & 7;
        byte comp = (byte) (1 << (7-i));
        if (value) {
            bits[row] = (byte) (comp | temp);
        } else {
            comp = (byte) ~ comp;
            bits[row] = (byte)(comp & temp);
        }
    }

    public void add(int n) {
        set(n, true);
    }

    public void delete(int n) {
        set(n, false);
    }

    public void display(int row){
        System.out.println("BitMap位图展示");
        for(int i=0;i<row;i++){
            List<Integer> list = new ArrayList<Integer>();
            int temp = bits[i];
            for(int j=0;j<8;j++){
                list.add(temp & 1);
                temp >>= 1;
            }
            System.out.println("a["+i+"]" + list);
        }
    }

    public void saveAsFile(String filePath) {
        File file = new File(filePath);
        try {
            Files.deleteIfExists(file.toPath());
            OutputStream os = new FileOutputStream(file);
            os.write(bits);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Bitmap bm = new Bitmap(1000);
        int[] data = {1, 3, 65, 32, 54};
        for (int n : data) {
            bm.add(n);
        }

        for (int n : data) {
            System.out.println(bm.get(n));
        }

        bm.saveAsFile("/Users/yuan/Devel/exp/karancs/./algorithmex/src/chenyuan/algorithmex/njb/datastructure/bitmap/big_int_array.bitmap");

//        System.out.println(Arrays.toString(bm.bytes));
//        bm.display(125);
    }
}
