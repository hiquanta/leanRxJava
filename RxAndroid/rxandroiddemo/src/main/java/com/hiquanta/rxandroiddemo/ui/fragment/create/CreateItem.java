package com.hiquanta.rxandroiddemo.ui.fragment.create;




import android.app.Fragment;

import com.hiquanta.rxandroiddemo.R;

/**
 * Created by hiquanta on 2015/8/18.
 */
public enum CreateItem {


    CREATE(0, R.string.create,
            CreateFragment.class),
    DEFER(1, R.string.defer,
            DeferFragment.class);

    private int idx;
    private int resName;
    private Class<? extends Fragment> clz;




     CreateItem(int idx, int resName, Class<? extends Fragment> clz) {
        this.idx = idx;
        this.resName = resName;
        this.clz = clz;

    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getResName() {
        return resName;
    }

    public void setResName(int resName) {
        this.resName = resName;
    }

    public Class<? extends Fragment> getClz() {
        return clz;
    }

    public void setClz(Class<? extends Fragment> clz) {
        this.clz = clz;
    }
}
