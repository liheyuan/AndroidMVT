package com.coder4.amvt.util;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by coder4 on 2017/5/18.
 */

public class ReusingActivityFragmentUtil {
    private static String FRAGMENT_EXTRA_KEY = "FRAGMENT_EXTRA_KEY";
    private static String FRAGMENT_CLASS = "FRAGMENT_CLASS";
    private static String FRAGMENT_TAG = "FRAGMENT_TAG";
    private static String FRAGMENT_CONTAINER_ID = "FRAGMENT_CONTAINER_ID";
    private static String FRAGMENT_ARGS = "FRAGMENT_ARGS";

    public static void saveReqFragment(@NonNull Intent intent,
                                      @NonNull Class<? extends Fragment> fragmentClass,
                                 int fragmentContainerId,
                                 @Nullable Bundle fragmentArgs) {
        // make bundle
        Bundle bundle = new Bundle();
        bundle.putString(FRAGMENT_CLASS, fragmentClass.getName());
        bundle.putString(FRAGMENT_TAG, fragmentClass.getSimpleName());
        bundle.putInt(FRAGMENT_CONTAINER_ID, fragmentContainerId);
        if (fragmentArgs != null) {
            bundle.putBundle(FRAGMENT_ARGS, fragmentArgs);
        }
        // save to intent
        intent.putExtra(FRAGMENT_EXTRA_KEY, bundle);
    }

    public static void loadFragment(@NonNull Intent intent,
                             @NonNull FragmentActivity activity) {
        // get fm
        FragmentManager fm = activity.getSupportFragmentManager();
        if (fm == null) {
            return ;
        }

        // get bundle
        Bundle bundle = intent.getBundleExtra(FRAGMENT_EXTRA_KEY);
        if (bundle == null) {
            return ;
        }

        // get fragment related param
        String fragmentClass = bundle.getString(FRAGMENT_CLASS);
        String fragmentTag = bundle.getString(FRAGMENT_TAG);
        int fragmentContainerId = bundle.getInt(FRAGMENT_CONTAINER_ID, 0);
        if (fragmentClass == null || fragmentTag == null) {
            return ;
        }
        Bundle fragmentArgs = bundle.getBundle(FRAGMENT_ARGS);

        // create fragment if not exists
        Fragment fragment = fm.findFragmentByTag(fragmentTag);
        if (fragment == null) {
            // need create first
            fragment = Fragment.instantiate(activity, fragmentClass, fragmentArgs);
            FragmentTransaction ft = fm.beginTransaction();
            if (fragmentContainerId == 0) {
                ft.add(fragment, fragmentTag);
            } else {
                ft.add(fragmentContainerId, fragment, fragmentTag);
            }
            ft.commit();
        } else if (fragment.isDetached()) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.attach(fragment);
            ft.commit();
        }
    }
}
