package com.mireagaloideal.apportame.main.interactores;

import android.util.Log;

import com.mireagaloideal.apportame.data.ResponseSearch;
import com.mireagaloideal.apportame.interfaces.RequestResultListener;
import com.mireagaloideal.apportame.main.interactores.interfaces.ISearchGiftInteractor;
import com.mireagaloideal.apportame.main.presenters.interfaces.ISearchGiftPresenter;
import com.mireagaloideal.apportame.net.APIClient;
import com.mireagaloideal.apportame.net.IApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jordán Rosas on 13/12/2017.
 */

public class SearchGiftInteractor implements ISearchGiftInteractor, RequestResultListener {
    private ISearchGiftPresenter presenter;

    public SearchGiftInteractor(ISearchGiftPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void searchGift(String str) {

        APIClient.getClient().create(IApiClient.class).searchItems(str).enqueue(new Callback<ResponseSearch>() {
            @Override
            public void onResponse(Call<ResponseSearch> call, Response<ResponseSearch> response) {
                //response.body().getData().get(0);
                //response.code()
                onSucces(response.body().getData());
            }

            @Override
            public void onFailure(Call<ResponseSearch> call, Throwable t) {
                Log.e("MyError", t.getMessage());
                onError(t);
            }
        });
    }

    @Override
    public void onSucces(Object result) {
        //String resultado = "[ { \"name\": \" Smartphone Samsung S8 5.8 pulgadas Plata AT&T;\\n\", \"prices\": \"17,29900\", \"url_image\": \"https://ss632.liverpool.com.mx/lg/1057900829.jpg\" }, { \"name\": \" Smartphone Samsung S8 5.8 pulgadas Violeta AT&T;\\n\", \"prices\": \"17,29900\", \"url_image\": \"https://ss632.liverpool.com.mx/lg/1057900837.jpg\" }, { \"name\": \" Smartphone Samsung S8 Plus 6.2 pulgadas Negro AT&T;\\n\", \"prices\": \"19,69900\", \"url_image\": \"https://ss632.liverpool.com.mx/lg/1057900845.jpg\" }, { \"name\": \" Smartphone Samsung S8 Plus 6.2 pulgadas Plata AT&T;\\n\", \"prices\": \"19,69900\", \"url_image\": \"https://ss632.liverpool.com.mx/lg/1057900853.jpg\" }, { \"name\": \" Smartphone Samsung S8 5.8 pulgadas Violeta Telcel\\n\", \"prices\": \"17,29900\", \"url_image\": \"https://ss632.liverpool.com.mx/lg/1057897119.jpg\" }]";
        presenter.searchGiftsResultSuccess(result);
    }

    @Override
    public void onError(Object error) {
        presenter.searchGiftsResultError(error);
    }
}
