package com.mireagaloideal.apportame.net;

import com.mireagaloideal.apportame.data.RegaloFromWS;
import com.mireagaloideal.apportame.data.RegaloToWS;
import com.mireagaloideal.apportame.data.ResponseSearch;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Jordán Rosas on 13/12/2017.
 */

public interface IApiClient {

    @GET("/params")
    Call<ResponseSearch> searchItems(@Query("params1") String params1);

    @POST("/gift-users")
    Call<RegaloToWS> saveItem(@Body RegaloToWS regaloFromWS);
}
