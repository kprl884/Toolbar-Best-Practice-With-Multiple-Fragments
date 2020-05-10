package com.example.lastversion;

import com.example.lastversion.models.ProjectsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface RequestInterface {
    @GET("kickstarter")
    Call<List<ProjectsModel>> getProjectsJson();
}
