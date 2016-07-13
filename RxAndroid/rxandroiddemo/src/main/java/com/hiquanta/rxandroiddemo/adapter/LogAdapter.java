package com.hiquanta.rxandroiddemo.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import com.hiquanta.rxandroiddemo.R;

import java.util.List;

/**
 * Created by hiquanta on 2016/7/13.
 */
public class LogAdapter extends ArrayAdapter<String> {

    public LogAdapter(Context context, List<String> logs) {
        super(context, R.layout.item_log, R.id.item_log, logs);
    }
}