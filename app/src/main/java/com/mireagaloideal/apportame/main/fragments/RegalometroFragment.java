package com.mireagaloideal.apportame.main.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mireagaloideal.apportame.GenericFragment;
import com.mireagaloideal.apportame.R;

import butterknife.ButterKnife;

/**
 * Created by Jordán Rosas on 12/12/2017.
 */

public class RegalometroFragment extends GenericFragment {


    public static RegalometroFragment newInstace() {
        RegalometroFragment fragment = new RegalometroFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_regalometro, container, false);
        initViews();
        return rootview;
    }

    @Override
    public void initViews() {
        ButterKnife.bind(this, rootview);

    }
}
