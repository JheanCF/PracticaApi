package com.jp.practicawd.ApiManager;

import com.jp.practicawd.models.Distillery;
import com.jp.practicawd.models.Whisky;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL="https://whiskyhunter.net/api/";
    @GET("auctions_info")
    Call<List<Whisky>> getWhisky();

    @GET("distilleries_info")
    Call<List<Distillery>> getDistillery();


}
