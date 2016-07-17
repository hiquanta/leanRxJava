package com.hiquanta.rxandroiddemo.utils;

import android.os.Looper;

/**
 * Created by hiquanta on 2016/7/14.
 */
public class ThreadUtil {
    public static boolean _isCurrentlyOnMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

}
