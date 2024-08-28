package com.akademicu.mytattooapp.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.akademicu.mytattooapp.model.PexelResponse;
import com.akademicu.mytattooapp.repository.PhotoRepository;

public class ActivityViewModel extends AndroidViewModel {
   PhotoRepository photoRepository;

   public ActivityViewModel(@NonNull Application application) {
      super(application);
      this.photoRepository = new PhotoRepository(application);
   }

   public LiveData<PexelResponse> getPexelseResponseLiveData(String query, int perPage, int currentPage){
      return photoRepository.getMutableDataFromPexel(query, perPage, currentPage);
   }
}
