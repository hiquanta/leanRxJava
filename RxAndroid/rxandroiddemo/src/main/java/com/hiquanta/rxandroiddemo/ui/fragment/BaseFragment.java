package com.hiquanta.rxandroiddemo.ui.fragment;



import android.app.AlertDialog;
import android.app.Fragment;

import com.hiquanta.rxandroiddemo.R;

import butterknife.OnClick;

/**
 * Created by hiquanta on 2016/7/13.
 */
public abstract class BaseFragment extends Fragment {

    @OnClick(R.id.tipBt)
    void tip() {
        new AlertDialog.Builder(getActivity())
                .setTitle(getTitleRes())
                .setView(getActivity().getLayoutInflater().inflate(getDialogRes(), null))
                .show();
    }


    protected abstract int getDialogRes();
    protected abstract int getTitleRes();
}
