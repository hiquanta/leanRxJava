package com.hiquanta.rxandroiddemo.adapter.viewpaperadapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import com.hiquanta.rxandroiddemo.ui.fragment.create.CreateItem;

/**
 * Created by hiquanta on 2016/7/13.
 */
public class CreateOperatorAdapter extends BaseAdapter {
    CreateItem[] tabs;
    Context context;

    public CreateOperatorAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        tabs = CreateItem.values();
    }

    @Override
    public Fragment getItem(int position) {

        return Fragment.instantiate(context, tabs[position].getClz().getName());
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
