package com.example.lastversion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
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
    private RecyclerView projects_recycler_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        projects_recycler_view = findViewById(R.id.projects_recyclerview);
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        //projects_recycler_view.setLayoutManager(mLayoutManager);

        //projectsModels = new ArrayList<>();
        //  projectsModels.add(new ProjectsModel("name",1,"asad",1));
        //  projectsModels.add(new ProjectsModel("name",1,"asad",1));
        //   projectsModels.add(new ProjectsModel("name",1,"asad",1));
        //   projectsModels.add(new ProjectsModel("name",1,"asad",1));
        //  projectsModels.add(new ProjectsModel("name",1,"asad",1));
        //  projectsModels.add(new ProjectsModel("name",1,"asad",1));
        // projectsModels.add(new ProjectsModel("name",1,"asad",1));
        //getProjectResponse();


        //projectsAdapter = new ProjectsAdapter(projectsModels);
        // projects_recycler_view.setAdapter(projectsAdapter);
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
                projectsAdapter = new ProjectsAdapter(projectsModels, MainActivity.this, pos -> {
                    // TODO: 6.04.2020 Buradan string olarak degil obje olarak gondermen lazim.
                    //Bu obje de parcelable olacak.
                    //Not: Neden parcelable kullanman gerektigini arastir
                   Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                   String stringDetail = projectsModels.get(pos).toString();
                   intent.putExtra("details", stringDetail);

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
