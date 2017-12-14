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
 * Created by Jordán Rosas on 13/12/2017.
 */

public class EventsFragment extends GenericFragment {

    public static EventsFragment newInstance() {
        EventsFragment fragment = new EventsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_mis_eventos, container, false);
        initViews();
        return rootview;
    }


    @Override
    public void initViews() {
        ButterKnife.bind(this, rootview);
    }
}
