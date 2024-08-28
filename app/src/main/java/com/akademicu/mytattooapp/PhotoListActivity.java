package com.akademicu.mytattooapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.akademicu.mytattooapp.adapter.PhotoAdapter;
import com.akademicu.mytattooapp.model.Photo;
import com.akademicu.mytattooapp.view_model.ActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class PhotoListActivity extends AppCompatActivity {
    private  RecyclerView recyclerView;
    private  LinearLayoutManager layoutManager;
    private ArrayList<Photo> photoArrayList = new ArrayList<>();
    private PhotoAdapter photoAdapter;
    ActivityViewModel viewModel;
    private ProgressBar progressBar;
    private int currentPage = 1;
    private boolean isLoading = false;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_photo_list);

        initApp();
        getPhotos("tattoo",10, currentPage);
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                layoutManager =(LinearLayoutManager) recyclerView.getLayoutManager();
                if (!isLoading){
                    if (layoutManager != null &&
                            layoutManager.findLastCompletelyVisibleItemPosition() == photoArrayList.size()-1){
                        currentPage++;
                        getPhotos("tattoo",10, currentPage);
                        isLoading = true;
                    }
                }
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    private void getPhotos(String tatto, int perPage, int page) {
        viewModel.getPexelseResponseLiveData(tatto, perPage ,page).observe(this, pexelResponse -> {
            if (pexelResponse != null && pexelResponse.getPhotos() != null && !pexelResponse.getPhotos().isEmpty()){
                progressBar.setVisibility(View.GONE);
                List<Photo> photoList =pexelResponse.getPhotos();
                photoArrayList.addAll(photoList);
                photoAdapter.notifyDataSetChanged();
                isLoading = false;
            }
        });
    }

    private void initApp() {
        recyclerView = findViewById(R.id.recycler_View);
        progressBar = findViewById(R.id.progress_Barr);
        layoutManager = new LinearLayoutManager(PhotoListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        photoAdapter = new PhotoAdapter(photoArrayList, PhotoListActivity.this);
        recyclerView.setAdapter(photoAdapter);
        viewModel = new ViewModelProvider(this).get(ActivityViewModel.class);
    }
    public void backToHome(View view){
        Intent intent = new Intent(PhotoListActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }


}