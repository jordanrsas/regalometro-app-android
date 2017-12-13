package com.mireagaloideal.apportame;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.mireagaloideal.apportame.interfaces.enums.Direction;
import com.mireagaloideal.apportame.utils.SupportComponent;

/**
 * Created by Jordán Rosas on 12/12/2017.
 */

public abstract class SupportFragmentActivity extends AppCompatActivity {
    private SupportComponent mSupportComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mSupportComponent = new SupportComponent(getSupportFragmentManager());
    }

    protected void loadFragment(@NonNull GenericFragment fragment) {
        mSupportComponent.loadFragment(fragment, R.id.container, Direction.NONE, false);
    }

    protected void loadFragment(@NonNull GenericFragment fragment, @IdRes int idContainer) {
        mSupportComponent.loadFragment(fragment, idContainer, Direction.NONE, false);
    }

    protected void loadFragment(@NonNull GenericFragment fragment, boolean addToBackStack) {
        mSupportComponent.loadFragment(fragment, R.id.container, Direction.NONE, addToBackStack);
    }

    protected void loadFragment(@NonNull GenericFragment fragment, @IdRes int idContainer, boolean addToBackStack) {
        mSupportComponent.loadFragment(fragment, idContainer, Direction.NONE, addToBackStack);
    }

    protected void loadFragment(@NonNull GenericFragment fragment, @NonNull Direction Direction) {
        mSupportComponent.loadFragment(fragment, R.id.container, Direction, false);
    }

    protected void loadFragment(@NonNull GenericFragment fragment, @IdRes int idContainer, @NonNull Direction Direction) {
        mSupportComponent.loadFragment(fragment, idContainer, Direction, false);
    }

    protected void loadFragment(@NonNull GenericFragment fragment, @NonNull Direction Direction,
                                boolean addToBackStack) {
        mSupportComponent.loadFragment(fragment, R.id.container, Direction, addToBackStack);
    }

    protected void loadFragment(@NonNull GenericFragment fragment, @IdRes int idContainer, @NonNull Direction direction,
                                boolean addToBackStack) {
        mSupportComponent.loadFragment(fragment, idContainer, direction, addToBackStack);
    }

    protected void loadFragment(@NonNull Fragment fragment, @IdRes int idContainer, @NonNull Direction direction,
                                boolean addToBackStack) {
        mSupportComponent.loadFragment(fragment, idContainer, direction, addToBackStack);
    }

    protected Fragment getCurrentFragment() {
        return mSupportComponent.getCurrentFragment();
    }

    protected Fragment getCurrentFragment(@IdRes int idContainer) {
        return mSupportComponent.getCurrentFragment(idContainer);
    }

}
