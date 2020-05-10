package com.example.lastversion.view;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastversion.OnMyAdapterItemClickListener;
import com.example.lastversion.databinding.AdapterProjectItemBinding;
import com.example.lastversion.models.ProjectsModel;

/**
 * Created by mertselcukdemir on 10.05.2020
 * Copyright (c) 2020 Twin Science & Robotics to present
 * All rights reserved.
 */
public class ProjectViewHolder extends RecyclerView.ViewHolder {

    public final AdapterProjectItemBinding binding;

    public ProjectViewHolder(@NonNull AdapterProjectItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void setItem(ProjectsModel projectsModel, int position, OnMyAdapterItemClickListener onMyAdapterItemClickListener) {
        binding.setProject(projectsModel);
        binding.setPosition(position);
        binding.setListener(onMyAdapterItemClickListener);
    }
}
