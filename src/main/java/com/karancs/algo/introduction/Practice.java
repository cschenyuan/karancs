package com.karancs.algo.introduction;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by chenyuan on 2018/1/14.
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Practice {
    String id();
}
