package com.coder4.amvt.util;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by coder4 on 2017/6/1.
 */

public class KeyboardUtil {

    public static void hideSoftKeyboard(@Nullable Activity activity, @Nullable View view) {
        if (activity == null || view == null) {
            return ;
        }
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
