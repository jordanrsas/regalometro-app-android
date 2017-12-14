package com.mireagaloideal.apportame.main.presenters;

import com.mireagaloideal.apportame.data.RegaloFromWS;
import com.mireagaloideal.apportame.main.interactores.SearchGiftInteractor;
import com.mireagaloideal.apportame.main.interactores.interfaces.ISearchGiftInteractor;
import com.mireagaloideal.apportame.main.presenters.interfaces.ISearchGiftPresenter;
import com.mireagaloideal.apportame.main.view.SearchGiftViewManager;

import java.util.List;

/**
 * Created by Jordán Rosas on 13/12/2017.
 */

public class SearchGiftPresenter implements ISearchGiftPresenter {

    private ISearchGiftInteractor interactor;
    private SearchGiftViewManager viewManager;

    public SearchGiftPresenter(SearchGiftViewManager viewManager) {
        interactor = new SearchGiftInteractor(this);
        this.viewManager = viewManager;
    }

    @Override
    public void searchGifts(String srch) {
        interactor.searchGift(srch);
    }

    @Override
    public void searchGiftsResultSuccess(Object result) {

        //String res = (String)result;

        //List<RegaloFromWS> regalos = new Gson().fromJson(res, new TypeToken<List<RegaloFromWS>>(){}.getType());
        viewManager.printGifts((List<RegaloFromWS>) result);
    }

    @Override
    public void searchGiftsResultError(Object error) {
        viewManager.showError(error);
    }


}
