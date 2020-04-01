package com.example.lastversion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.HEAD;

public class MainActivity extends AppCompatActivity {

    ArrayList<ProjectsModel> projectsModels = new ArrayList<>();
    private ProjectsAdapter projectsAdapter;
    private RecyclerView projects_recycler_view;

    TextView detail_txt_projectName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        projects_recycler_view = findViewById(R.id.projects_recyclerview);
        projects_recycler_view.setLayoutManager(new LinearLayoutManager(this));
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
                 projectsModels = new ArrayList<>(response.body());
                projectsAdapter = new ProjectsAdapter(MainActivity.this, projectsModels);
                projects_recycler_view.setAdapter(projectsAdapter);
                projectsAdapter.setOnItemClickListener(new ProjectsAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Intent intent = new Intent(MainActivity.this, detailActivity.class);
                        String detail_toString = toString();
                        String detail_url = projectsModels.get(position).getUrl();
                        intent.putExtra("detail_url",detail_url);
                        intent.putExtra("detail_toString",detail_toString);
                        startActivity(intent);
                        String projectName = projectsModels.get(position).getTitle();
                        detail_txt_projectName.setText(projectName);
                    }
                });

                Toast.makeText(MainActivity.this, "succes", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<ProjectsModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("Error", t.getMessage());
            }
        });
    }
}
