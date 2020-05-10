package com.example.lastversion;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastversion.adapters.ProjectsAdapter;
import com.example.lastversion.models.ProjectsModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends BaseFragment {

    ArrayList<ProjectsModel> projectsModels;
    private ProjectsAdapter projectsAdapter;
    private RecyclerView projects_recycler_view;
    public static String TAG = HomeFragment.class.getSimpleName();

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity, container, false);

        projects_recycler_view = view.findViewById(R.id.projects_recyclerV);
        getProjectResponse();
        updateToolbar("aa", false);


        return view;
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

                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mainActivity);
                projects_recycler_view.setLayoutManager(mLayoutManager);

                OnMyAdapterItemClickListener clickListener = pos ->
                        mainActivity.addFragment(DetailsFragment.newInstance(projectsModels.get(pos)), DetailsFragment.TAG);

                projectsAdapter = new ProjectsAdapter(projectsModels, clickListener);

                projects_recycler_view.setHasFixedSize(true);
                projects_recycler_view.setAdapter(projectsAdapter);
            }

            @Override
            public void onFailure(Call<List<ProjectsModel>> call, Throwable t) {
                Toast.makeText(mainActivity, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("Error", Objects.requireNonNull(t.getMessage()));
            }
        });
    }
}
