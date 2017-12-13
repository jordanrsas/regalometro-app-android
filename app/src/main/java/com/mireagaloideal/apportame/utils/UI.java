package com.mireagaloideal.apportame.utils;

import android.support.v4.app.FragmentManager;

import com.mireagaloideal.apportame.R;
import com.mireagaloideal.apportame.interfaces.DialogDoubleActions;

/**
 * Created by Jordán Rosas on 12/12/2017.
 */

public class UI {

    public static void createSimpleCustomDialog(String message, FragmentManager fragmentManager) {
        createSimpleCustomDialog(message, fragmentManager, null, true, false);
    }

    public static void createSimpleCustomDialog(String message,
                                                FragmentManager fragmentManager, final DialogDoubleActions actions,
                                                boolean hasConfirmBtn, boolean hasCancelBtn) {
        createSimpleCustomDialog("", message, fragmentManager, actions, hasConfirmBtn, hasCancelBtn);
    }

    public static void createSimpleCustomDialog(String title, String message,
                                                FragmentManager fragmentManager, final DialogDoubleActions actions,
                                                boolean hasConfirmBtn, boolean hasCancelBtn) {
        final ApportaFragmentDialog apportaFragmentDialog = ApportaFragmentDialog.newInstance(R.layout.dialog_message_layout,
                title, message, hasConfirmBtn, hasCancelBtn);
        apportaFragmentDialog.setDialogActions(new DialogDoubleActions() {
            @Override
            public void actionConfirm(Object... params) {
                apportaFragmentDialog.dismiss();
                if (actions != null) {
                    actions.actionConfirm(params);
                }
            }

            @Override
            public void actionCancel(Object... params) {
                apportaFragmentDialog.dismiss();
                if (actions != null) {
                    actions.actionCancel(params);
                }
            }
        });

        apportaFragmentDialog.setCancelable(false);
        apportaFragmentDialog.show(fragmentManager, ApportaFragmentDialog.class.getSimpleName());
    }
}
