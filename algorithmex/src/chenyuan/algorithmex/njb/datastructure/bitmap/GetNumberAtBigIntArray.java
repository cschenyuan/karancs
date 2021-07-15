package chenyuan.algorithmex.njb.datastructure.bitmap;

import java.io.*;
import java.nio.file.Files;
import java.util.BitSet;
import java.util.Random;

/**
 * @author chenyuan
 */
public class GetNumberAtBigIntArray {

    private static final String DIR = "./algorithmex/src/" + GetNumberAtBigIntArray.class.getPackage().getName().replaceAll("\\.", "/");
    private static final int MAX_N = Integer.MAX_VALUE/10;
    private static final int SIZE = 100 * 1024 * 1024 / 6;

    private static void genBigIntArrayToFile() throws IOException {
        File file = new File(DIR + "/big_int_array.txt");
        System.out.println(file.getAbsolutePath());
        Files.deleteIfExists(file.toPath());
        Files.createFile(file.toPath());
        int n = 0;
        Random random = new Random();
        try (FileWriter fw = new FileWriter(file)) {
            while (n < SIZE) {
                fw.write(random.nextInt(MAX_N) + "\n");
                n ++;
            }
            System.out.println("Size: " + n);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Bitmap loadData() throws Exception {
        File file = new File(DIR + "/big_int_array.txt");
        Bitmap bm = new Bitmap(MAX_N);
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        String s;
        int c = 0;
        while ((s = raf.readLine()) != null) {
            bm.add(Integer.parseInt(s));
            c ++;
        }

        OutputStream os = new FileOutputStream(DIR + "/big_int_array.bitmap");

        System.out.println("loaded: " + c);
        return bm;
    }



    public static void main(String[] args) throws Exception {
        File bitmapFile = new File(DIR + "/big_int_array.bitmap");

//        genBigIntArrayToFile();
//        Bitmap bm = loadData();
//        bm.saveAsFile(DIR + "/big_int_array.bitmap");
        Bitmap bm = Bitmap.loadFromFile(bitmapFile, MAX_N);

        int[] arr = {198084608, 143011259, 214378556,
                46116311, 213494380, 66467625, 210285545,
                50174995, 207696762, 39858753, 90935691,
                54133022, 58578749, 1653439,
                1, 2, 3 // 不存在
        };
        for (int n : arr) {
            System.out.println(n + " => " + bm.get(n));
        }
    }
}
