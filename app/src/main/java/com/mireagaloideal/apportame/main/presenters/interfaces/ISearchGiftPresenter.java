package com.mireagaloideal.apportame.main.presenters.interfaces;

/**
 * Created by Jordán Rosas on 13/12/2017.
 */

public interface ISearchGiftPresenter {
    void searchGifts(String srch);

    void searchGiftsResultSuccess(Object result);

    void searchGiftsResultError(Object error);
}
