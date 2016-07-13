package com.hiquanta.rxandroiddemo.ui.fragment.translate;

import android.app.Fragment;

import com.hiquanta.rxandroiddemo.R;


/**
 * Created by hiquanta on 2016/7/13.
 */
public enum TransformItem {
    BUFFER(0,R.string.buffer,
           BufferFragment.class),
    FLATMAP(1,R.string.flatmap,
          FlatMapFragment.class);

    private int idx;
    private int resName;
    private Class<? extends Fragment> clz;




    TransformItem(int idx, int resName, Class<? extends Fragment> clz) {
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
