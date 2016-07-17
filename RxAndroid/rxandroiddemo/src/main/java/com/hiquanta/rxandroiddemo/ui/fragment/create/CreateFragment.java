package com.hiquanta.rxandroiddemo.ui.fragment.create;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.hiquanta.rxandroiddemo.R;
import com.hiquanta.rxandroiddemo.ui.fragment.BaseFragment;
import com.hiquanta.rxandroiddemo.ui.widget.AlxUrlTextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by hiquanta on 2016/7/13.
 */
public class CreateFragment extends BaseFragment {
    
    @Bind(R.id.create)
    Button create;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create, container, false);
        ButterKnife.bind(this, view);

        return view;
    }


    @Override
    protected int getDialogRes() {
        return R.layout.dialog_create;
    }

    @Override
    protected int getTitleRes() {
        return R.string.app_name;
    }
}
