package com.akademicu.mytattooapp.repository;
import static java.sql.DriverManager.println;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import com.akademicu.mytattooapp.model.PexelResponse;
import com.akademicu.mytattooapp.retrofit.ApiRequest;
import com.akademicu.mytattooapp.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoRepository {
    Application application;
    private MutableLiveData<PexelResponse> data = new MutableLiveData<>();

    public PhotoRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<PexelResponse> getMutableDataFromPexel(String query, int perPage, int page){
        ApiRequest apiRequest = RetrofitRequest.getRetrofitInstance();
        Call<PexelResponse> call =apiRequest.searchPhoto(query,perPage,page);
        call.enqueue(new Callback<PexelResponse>() {
            @Override
            public void onResponse(Call<PexelResponse> call, Response<PexelResponse> response) {
                if (response.isSuccessful() && response.body() != null){
                    data.setValue(response.body());
                    Log.d("onResponse","ESTE");
                }
            }

            @Override
            public void onFailure(Call<PexelResponse> call, Throwable throwable) {
                Log.d("onResponse","NUI");

                data.setValue(null);
            }
        });
        return data;
    }

}
