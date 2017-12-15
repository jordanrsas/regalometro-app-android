package com.mireagaloideal.apportame.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.mireagaloideal.apportame.interfaces.enums.Font;

import java.util.HashMap;

/**
 * Created by Jordán Rosas on 14/12/2017.
 */

public class FontCache {
    private static HashMap<String, Typeface> fontCache = new HashMap<>();

    public static Typeface getTypeface(String fontname, Context context) {
        Typeface typeface = fontCache.get(fontname);
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), fontname);
            } catch (Exception e) {
                return null;
            }
            fontCache.put(fontname, typeface);
        }
        return typeface;
    }

    public static void initStyle(Context context, Font font, View view) {

        String fontAssets;
        switch (font) {
            case ANGELINA:
                fontAssets = "fonts/angelina.ttf";
                break;
            case GLYPHICONS:
                fontAssets = "fonts/glyphicons_halflings_regular.ttf";
                break;
            case SOURCESANSPRO_LIGHT:
                fontAssets = "fonts/SourceSansPro_Light.ttf";
                break;
            case SOURCESANSPRO_REGULAR:
                fontAssets = "fonts/SourceSansPro_Regular.ttf";
                break;
            case SOURCESANSPRO_SEMIBOLD:
                fontAssets = "fonts/SourceSansPro_Semibold.ttf";
                break;
            case DK_BUPKIS:
                fontAssets = "fonts/DK_Bupkis.otf";
                break;
            case ROBOTO:
                fontAssets = "fonts/Roboto-Regular.ttf";
                break;
            default:
                fontAssets = "fonts/angelina.ttf";
                break;
        }
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), fontAssets);
        setTypeface(typeface, view);
    }

    public static void setTypeface(Typeface typeface, View view) {
        if (view instanceof TextView) {
            ((TextView) view).setTypeface(typeface);
        } else if (view instanceof EditText) {
            ((EditText) view).setTypeface(typeface);
        } else if (view instanceof Button) {
            ((Button) view).setTypeface(typeface);
        } else if (view instanceof ToggleButton) {
            ((ToggleButton) view).setTypeface(typeface);
        }
    }
}
