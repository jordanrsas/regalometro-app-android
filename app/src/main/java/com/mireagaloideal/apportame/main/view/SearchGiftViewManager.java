package com.mireagaloideal.apportame.main.view;

import com.mireagaloideal.apportame.data.RegaloFromWS;

import java.util.List;

/**
 * Created by Jordán Rosas on 13/12/2017.
 */

public interface SearchGiftViewManager {
    void printGifts(List<RegaloFromWS> regalos);

    void showError(Object error);
}

