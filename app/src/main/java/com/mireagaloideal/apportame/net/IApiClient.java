package com.mireagaloideal.apportame.net;

import com.mireagaloideal.apportame.data.ResponseSearch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jordán Rosas on 13/12/2017.
 */

public interface IApiClient {

    @GET("/params")
    Call<ResponseSearch> searchItems(@Query("params1") String params1);
}
