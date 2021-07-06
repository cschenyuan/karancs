package com.karancs.algo.string;

/**
 * Rabin-Karp string matcher algorithm
 * Created by yuan on 15/12/31.
 */
public class RKSMatcher implements Matcher {

    private int d_;
    private int q_;

    private RKSMatcher() {}
    public RKSMatcher(int d,int q) {
        this.d_ = d;
        this.q_ = q;
    }

    public int matches(String text,String pattern) {
        return rksMatch(text,pattern,d_,q_);
    }

    public boolean contains(String text,String pattern) {
       return matches(text,pattern) != -1;
    }

    public static int rksMatch(String text,String pattern,int d, int q) {
        int tlength = text.length();
        int plength = pattern.length();
        int h = (int)Math.pow(d,plength-1);
        int p = 0;
        int[] t = new int[tlength - plength + 1];
        for(int i=0;i<plength;i++) {
            p = (d * p + decimal(pattern.charAt(i))) ;
            t[0] = (d * t[0] + decimal(text.charAt(i))) ;
        }
        int a,b;
        for(int s=0;s<=tlength-plength;s++) {
            if( p == t[s] ) {
                System.out.println(text.substring(s,s+plength));
                if (pattern.equals(text.substring(s, s + plength)))
                    return s;
            }
            if(s < tlength - plength) {
                a = decimal(text.charAt(s));
                b = decimal(text.charAt(s + plength));
                System.out.println(t[s] + " " + a*h + " " + b);
                // t[s+1] : denote the decimal value of length-m substring text[s+1..s+m+1]
//                t[s + 1] = ((d * (t[s] - decimal(text.charAt(s + 1))* h) + decimal(text.charAt(s + plength + 1)))) % q;
                t[s+1] = ((d * (t[s] - a * h) + b)) ;
            }
        }
        return -1;
    }

     public static int rksMatch1(String text,String pattern,int d, int q) {
        int tlength = text.length();
        int plength = pattern.length();
        int h = (int)Math.pow(d,plength-1) % q;
        int p = 0;
        int[] t = new int[tlength - plength + 1];
        for(int i=0;i<plength;i++) {
            p = (d * p + decimal(pattern.charAt(i))) % q;
            t[0] = (d * t[0] + decimal(text.charAt(i))) % q;
        }
        int a,b;
        for(int s=0;s<=tlength-plength;s++) {
            if( p == t[s] ) {
                System.out.println(text.substring(s,s+plength));
                if (pattern.equals(text.substring(s, s + plength)))
                    return s;
            }
            if(s < tlength - plength) {
                a = decimal(text.charAt(s));
                b = decimal(text.charAt(s + plength));
                System.out.println(t[s] + " " + a*h + " " + b);
                // t[s+1] : denote the decimal value of length-m substring text[s+1..s+m+1]
//                t[s + 1] = ((d * (t[s] - decimal(text.charAt(s + 1))* h) + decimal(text.charAt(s + plength + 1)))) % q;
                t[s+1] = ((d * (t[s] - a * h) + b)) % q;
            }
        }
        return -1;
    }

    private static int decimal(char lowerCase) {
        return lowerCase - '0';
    }

    private static int decimal(int num) {
        return num;
    }
}
