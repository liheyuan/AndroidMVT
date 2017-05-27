package com.coder4.amvt.util;

/**
 * Created by coder4 on 2017/5/27.
 */

public class StringUtil {

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

}
