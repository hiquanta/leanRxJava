package com.hiquanta.rxandroiddemo.ui.fragment.translate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hiquanta.rxandroiddemo.R;
import com.hiquanta.rxandroiddemo.ui.fragment.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by hiquanta on 2016/7/13.
 */
public class BufferFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transform, container, false);
        ButterKnife.bind(this, view);


        return view;
    }

    @Override
    protected int getDialogRes() {
        return 0;
    }

    @Override
    protected int getTitleRes() {
        return 0;
    }
}
