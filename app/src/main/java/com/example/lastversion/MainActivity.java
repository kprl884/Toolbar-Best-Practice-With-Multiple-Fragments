package com.example.lastversion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * TODO LIST
 * Image icin glide kutuphanesi kullanilacak.
 */
public class MainActivity extends AppCompatActivity{

    ArrayList<ProjectsModel> projectsModels;
    private ProjectsAdapter projectsAdapter;
    ArrayAdapter<ProjectsModel> adapter;
    private RecyclerView projects_recycler_view;
    AutoCompleteTextView autoCompleteTextView;
    Button btn_sort, btn_filter, btn_search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        projects_recycler_view = findViewById(R.id.projects_recyclerV);
        getProjectResponse();
        //

    }

    private void getProjectResponse() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://starlord.hackerearth.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
        Call<List<ProjectsModel>> call = requestInterface.getProjectsJson();

        call.enqueue(new Callback<List<ProjectsModel>>() {
            @Override
            public void onResponse(Call<List<ProjectsModel>> call, Response<List<ProjectsModel>> response) {

                assert response.body() != null;
                projectsModels = new ArrayList<>(response.body());

                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
                projects_recycler_view.setLayoutManager(mLayoutManager);
                projectsAdapter = new ProjectsAdapter(projectsModels, MainActivity.this, pos -> {

                   Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                   intent.putExtra("projectObject", projectsModels.get(pos));

                   startActivity(intent);
                });

                projects_recycler_view.setHasFixedSize(true);
                projects_recycler_view.setAdapter(projectsAdapter);

                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<List<ProjectsModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("Error", Objects.requireNonNull(t.getMessage()));
            }
        });
    }
}
