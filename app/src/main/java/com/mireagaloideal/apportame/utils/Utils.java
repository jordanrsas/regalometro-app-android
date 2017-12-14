package com.mireagaloideal.apportame.utils;

import android.util.DisplayMetrics;
import android.view.Display;

/**
 * Created by Jordán Rosas on 14/12/2017.
 */

public class Utils {
    public static int getDensityDpi(Display defaultDisplay, DisplayMetrics metrics) {
        int density = 0 ;
        defaultDisplay.getMetrics(metrics);

        switch(metrics.densityDpi)
        {
            case DisplayMetrics.DENSITY_HIGH: //HDPI
                density = DisplayMetrics.DENSITY_HIGH;
                break;
            case DisplayMetrics.DENSITY_MEDIUM: //MDPI
                density = DisplayMetrics.DENSITY_HIGH;
                break;

            case DisplayMetrics.DENSITY_LOW:  //LDPI
                density = DisplayMetrics.DENSITY_LOW;
                break;

            default:
                density = DisplayMetrics.DENSITY_XHIGH; // DefaultDENSITY_XHIGH
                break;
        }
        return density;
    }
}
