package com.akademicu.mytattooapp.retrofit;

import com.akademicu.mytattooapp.BuildConfig;
import com.akademicu.mytattooapp.model.PexelResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiRequest {
    @Headers(BuildConfig.API_KEY)
    @GET("search")
    Call<PexelResponse> searchPhoto(@Query("query") String query,
                                    @Query("per_page") int perPage,
                                    @Query("page") int page);
}
