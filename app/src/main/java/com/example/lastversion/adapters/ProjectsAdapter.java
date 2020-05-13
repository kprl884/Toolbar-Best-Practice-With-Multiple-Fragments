package com.example.lastversion.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastversion.OnMyAdapterItemClickListener;
import com.example.lastversion.databinding.AdapterProjectItemBinding;
import com.example.lastversion.models.ProjectsModel;
import com.example.lastversion.view.ProjectViewHolder;

import java.util.ArrayList;


public class ProjectsAdapter extends RecyclerView.Adapter<ProjectViewHolder> {
    private ArrayList<ProjectsModel> projectsModels;

    public OnMyAdapterItemClickListener onMyAdapterItemClickListener;

    public ProjectsAdapter(ArrayList<ProjectsModel> projectsModels, OnMyAdapterItemClickListener onMyAdapterItemClickListener) {
        this.projectsModels = projectsModels;
        this.onMyAdapterItemClickListener = onMyAdapterItemClickListener;
    }


    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterProjectItemBinding binding = AdapterProjectItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ProjectViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        holder.setItem(projectsModels.get(position), position, onMyAdapterItemClickListener);

    }

    @Override
    public int getItemCount() {
        return projectsModels.size();
    }

}
