package com.hiquanta.rxandroiddemo.adapter.viewpaperadapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

/**
 * Created by hiquanta on 2016/7/13.
 */
public class BaseAdapter extends FragmentPagerAdapter {
    public BaseAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
