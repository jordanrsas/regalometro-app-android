package com.mireagaloideal.apportame;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.View;

import com.mireagaloideal.apportame.interfaces.OnEventListener;

/**
 * Created by Jordán Rosas on 12/12/2017.
 */

public abstract class GenericFragment extends Fragment {
    protected View rootview;
    protected OnEventListener onEventListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnEventListener) {
            this.onEventListener = (OnEventListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @NonNull
    public String getFragmentTag() {
        return getClass().getSimpleName();
    }

    public abstract void initViews();
}