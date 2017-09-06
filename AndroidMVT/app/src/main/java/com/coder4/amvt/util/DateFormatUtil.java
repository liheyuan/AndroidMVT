package com.coder4.amvt.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by coder4 on 17-9-6.
 */

public class DateFormatUtil {

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static String format(long time) {
        return formatter.format(new Date(time));
    }

}
