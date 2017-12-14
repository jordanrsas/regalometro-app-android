package com.mireagaloideal.apportame.main.controllers;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.mireagaloideal.apportame.R;
import com.mireagaloideal.apportame.SupportFragmentActivity;
import com.mireagaloideal.apportame.interfaces.DialogDoubleActions;
import com.mireagaloideal.apportame.interfaces.enums.Direction;
import com.mireagaloideal.apportame.main.fragments.EventsFragment;
import com.mireagaloideal.apportame.main.fragments.RegalometroFragment;
import com.mireagaloideal.apportame.main.fragments.SearchGiftFragment;
import com.mireagaloideal.apportame.utils.UI;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jordán Rosas on 11/12/2017.
 */

public class MainActivity extends SupportFragmentActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.drawer)
    DrawerLayout drawerLayout;
    //@BindView(R.id.progress_view)
    //ProgressLayout progressLayout;

    private int lastCheked;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle(R.string.title_bar);
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(this);

        lastCheked = navigationView.getMenu().getItem(0).getItemId();
        navigationView.setCheckedItem(lastCheked);
        loadFragment(EventsFragment.newInstance(), Direction.NONE, false);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        drawerLayout.closeDrawers();

        if (lastCheked != id) {
            switch (id) {
                case R.id.menu_eventos:
                    loadFragment(EventsFragment.newInstance(), Direction.FORDWARD, false);
                    lastCheked = id;
                    break;

                case R.id.menu_gifts:
                    loadFragment(SearchGiftFragment.newInstance(), Direction.FORDWARD, false);
                    lastCheked = id;
                    break;

                case R.id.menu_regalometro:
                    loadFragment(RegalometroFragment.newInstance(), Direction.FORDWARD, false);
                    lastCheked = id;
                    break;

                case R.id.menu_recomienda:
                    lastCheked = id;
                    break;

                case R.id.menu_settings:
                    lastCheked = id;
                    break;

                case R.id.menu_logotu:
                    break;
            }
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
        } else {
            UI.createSimpleCustomDialog(getString(R.string.message_salir), getSupportFragmentManager(),
                    new DialogDoubleActions() {
                        @Override
                        public void actionConfirm(Object... params) {
                            finish();
                        }

                        @Override
                        public void actionCancel(Object... params) {

                        }
                    }, true, true);
        }
    }

}
