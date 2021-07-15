package chenyuan.algorithmex.njb.datastructure.hash;

/**
 * @author chenyuan
 */
public class HashFunctions {

    /**
     * 直接定址法
     * @param key
     * @return
     */
    public static int hash01(int key) {
        return key * 31 + 7;
    }

    /**
     * 除留余数法
     * @param key
     * @param m
     * @return
     */
    public static int hash02(int key, int m) {
        return key % m;
    }

    /**
     * 平方均值法，取中间几位作为hash值
     * @param key
     * @return
     */
    public static int hash03(int key) {
        String s = (key * key) + "";
        StringBuilder sb = new StringBuilder();
        int m = s.length()/2;
        while (m < s.length()/2 + 3 && m < s.length()) {
            sb.append(s.charAt(m));
            m ++;
        }
        m = s.length() / 2 - 1;
        while (m >= 0 && m > s.length()/2 - 3) {
            sb.append(s.charAt(m));
            m --;
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(hash03(786));
    }
}
