package com.mireagaloideal.apportame.utils;

import android.content.Context;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Jordán Rosas on 13/12/2017.
 */

public class SeekBarNoTouch extends AppCompatSeekBar {
    public SeekBarNoTouch(Context context) {
        this(context, null);
    }

    public SeekBarNoTouch(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.seekBarStyle);
    }

    public SeekBarNoTouch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //init(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }
}
