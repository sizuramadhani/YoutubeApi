package com.example.adinda.youtubeapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ADINDA on 4/16/2018.
 */

public class ConfigRetrofit {

    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.googleapis.com/youtube/v3/").
            addConverterFactory(GsonConverterFactory.create()).build();

    ApiService service = retrofit.create(ApiService.class);

}
