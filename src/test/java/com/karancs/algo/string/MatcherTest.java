package com.karancs.algo.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yuan on 15/12/31.
 */
public class MatcherTest {

    @Test
    public void testRKSMatcer() {
//        Matcher matcher = new RKSMatcher(10,13);
//        int result = matcher.matches("2359023141526739921","31415");
        int result = RKSMatcher.rksMatch1("2359023141526739921","31415",10,13);
        Assert.assertEquals(6,result);
    }

    @Test
    public void test01() {
        print("" + 23590 % 13);
    }

    private void print(String msg) {
        System.out.println(msg);
    }
}
