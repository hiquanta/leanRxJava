package com.hiquanta.rxandroiddemo.adapter.viewpaperadapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;

import com.hiquanta.rxandroiddemo.ui.fragment.translate.TransformItem;


/**
 * Created by hiquanta on 2016/7/13.
 */
public class TransformAdapter extends BaseAdapter {
    TransformItem[] tabs;
    Context context;

    public TransformAdapter(Context context,FragmentManager fm) {
        super(fm);
        this.context=context;
        tabs = TransformItem.values();
    }

    @Override
    public Fragment getItem(int position) {
        try {
            return tabs[position].getClz().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return context.getString(tabs[position].getResName());
    }
}
