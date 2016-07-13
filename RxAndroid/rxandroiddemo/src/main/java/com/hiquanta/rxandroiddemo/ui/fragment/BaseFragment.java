package com.hiquanta.rxandroiddemo.ui.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hiquanta on 2016/7/13.
 */
public  class BaseFragment extends Fragment implements android.view.View.OnClickListener{
    public static BaseFragment newInstance() {
        
        Bundle args = new Bundle();
        
        BaseFragment fragment = new BaseFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onClick(View v) {

    }
}
