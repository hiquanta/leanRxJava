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
import com.hiquanta.rxandroiddemo.ui.activity.MainActivity;
import com.hiquanta.rxandroiddemo.ui.fragment.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
        create.setOnClickListener(this);
        return view;
    }
    @OnClick(R.id.create)
    void clicked() {
        Toast.makeText(getActivity(),"adsfa",Toast.LENGTH_LONG).show();
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                for(int i=0;i<10;i++){
                    subscriber.onNext(i+"");
                }
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.i("tag",s);
            }
        });
    }
    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.create:
                Toast.makeText(getActivity(),"adsfa",Toast.LENGTH_LONG).show();
                Observable.create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        for(int i=0;i<10;i++){
                            subscriber.onNext(i+"");
                        }
                    }
                }).subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.i("tag",s);
                    }
                });
                break;
        }
    }
}
