package com.mireagaloideal.apportame.login.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mireagaloideal.apportame.R;
import com.mireagaloideal.apportame.main.controllers.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jordán Rosas on 11/12/2017.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.btnLoginFacebook)
    Button btnLoginFacebook;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        btnLogin.setOnClickListener(this);
        btnLoginFacebook.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
