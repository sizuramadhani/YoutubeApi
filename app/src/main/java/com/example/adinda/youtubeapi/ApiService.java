package com.example.adinda.youtubeapi;

import com.example.adinda.youtubeapi.ResponseYoutube.ResponYoutube;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ADINDA on 4/16/2018.
 */

public interface ApiService {
    //https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=25&q=surfing&regionCode=ID&key={YOUR_API_KEY}

    @GET("search")
    Call<ResponYoutube> getVideo (@Query("part") String part,@Query("maxResults") String result,@Query("q") String keyword,@Query("regionCode") String region,
                                  @Query("type") String type,@Query("key") String key);

}
