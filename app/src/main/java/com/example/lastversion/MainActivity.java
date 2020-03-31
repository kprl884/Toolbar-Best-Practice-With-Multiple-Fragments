package com.example.lastversion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<ProjectsModel> projectsModels = new ArrayList<>();
    private ProjectsAdapter projectsAdapter;
    private RecyclerView projects_recyclerview;

    TextView detail_txt_projectName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        projects_recyclerview = (RecyclerView) findViewById(R.id.projects_recyclerview);
        projects_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        getProjectResponse();


        detail_txt_projectName = (TextView) findViewById(R.id.detail_txt_name);
        projectsAdapter.setOnItemClickListener(new ProjectsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //here will full with project detail
                String projectName = projectsModels.get(position).getTitle();
                detail_txt_projectName.setText(projectName);
            }
        });
    }

    private void getProjectResponse() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://starlord.hackerearth.com/kickstarter")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
        Call<List<ProjectsModel>> call = requestInterface.getProjectsJson();

        call.enqueue(new Callback<List<ProjectsModel>>() {
            @Override
            public void onResponse(Call<List<ProjectsModel>> call, Response<List<ProjectsModel>> response) {
                projectsModels = new ArrayList<>(response.body());
                projectsAdapter = new ProjectsAdapter(MainActivity.this, projectsModels);
                projects_recyclerview.setAdapter(projectsAdapter);

                //Toast.makeText(MainActivity.this, "Succesed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<ProjectsModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
