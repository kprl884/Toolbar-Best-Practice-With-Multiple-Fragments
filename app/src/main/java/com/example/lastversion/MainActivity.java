package com.example.lastversion;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<ProjectsModel> projectsModels;
    private ProjectsAdapter projectsAdapter;
    private RecyclerView projects_recycler_view;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        projects_recycler_view = findViewById(R.id.projects_recyclerV);
        getProjectResponse();
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
                OnMyAdapterItemClickListener clickListener = pos -> {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("projectObject", projectsModels.get(pos));
                    startActivity(intent);
                };

                projectsAdapter = new ProjectsAdapter(projectsModels, clickListener);

                projects_recycler_view.setHasFixedSize(true);
                projects_recycler_view.setAdapter(projectsAdapter);
            }

            @Override
            public void onFailure(Call<List<ProjectsModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("Error", Objects.requireNonNull(t.getMessage()));
            }
        });
    }
}
