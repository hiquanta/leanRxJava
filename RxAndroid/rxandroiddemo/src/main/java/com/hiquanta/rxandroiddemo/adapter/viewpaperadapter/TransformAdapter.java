package com.hiquanta.rxandroiddemo.adapter.viewpaperadapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;



/**
 * bug http://blog.csdn.net/henry121212/article/details/23496913
 * http://blog.csdn.net/dreamzml/article/details/9951577
 */
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
