package com.mireagaloideal.apportame.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.mireagaloideal.apportame.R;

/**
 * Created by Jordán Rosas on 13/12/2017.
 */

public class RegaloProgressLayout {
    private static ProgressDialog progressDialog = null;

    private static void createProgressDialog(final Context context) {

        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context, R.style.dialogFullScreen);
            progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);
        }
    }

    public static void show(final Context context) {
        createProgressDialog(context);

        if (progressDialog != null && !progressDialog.isShowing()) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.progress_regalometro, null);

            //ImageView icon = view.findViewById(R.id.imageLoading);
            //icon.setBackgroundResource(R.drawable.loading);

            // AnimationDrawable frameAnimation = (AnimationDrawable) icon.getBackground();
            progressDialog.show();
            progressDialog.setContentView(view);
            // frameAnimation.start();
        }
    }

    public static void hide() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        progressDialog = null;
    }
}
