package com.example.lastversion;

import android.app.Activity;
import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Objects;


public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ViewHolder> {
    private ArrayList<ProjectsModel> projectsModels;
    Context context;

    public OnMyAdapterItemClickListener onMyAdapterItemClickListener;

    public ProjectsAdapter(ArrayList<ProjectsModel> projectsModels,Context context, OnMyAdapterItemClickListener onMyAdapterItemClickListener){
        this.projectsModels = projectsModels;
        context = context;
        this.onMyAdapterItemClickListener = onMyAdapterItemClickListener;
    }

    @NonNull
    @Override
    public ProjectsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.projects_list_item2
        ,parent, false);

        return new ProjectsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectsAdapter.ViewHolder holder, int position) {
        //TODO: NULL Check
            //ProjectsModel currentProject = projectsModels.get(position);
        // TODO: 31.03.2020 Null Check And Type Check
        holder.project_name.setText(projectsModels.get(position).getTitle());
        String stringPledged = Integer.toString(projectsModels.get(position).getAmtPledged());
        holder.project_pleadge.append("Pleadge - $ " + stringPledged);
        holder.project_backers.append("Backers - " + projectsModels.get(position).getNumBackers());
        String stringSNo = Integer.toString(projectsModels.get(position).getSNo());
        holder.project_sNo.append("No. of Days to GO - " + stringSNo);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMyAdapterItemClickListener.onItemClicked(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return projectsModels.size();
    }



    //For now static, later control this line
    public  class ViewHolder extends RecyclerView.ViewHolder{
        private TextView project_name, project_pleadge, project_backers, project_sNo;
        private Button project_button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //project_button = itemView.findViewById(R.id.project_button);
            project_name = itemView.findViewById(R.id.project_name);
            project_pleadge = itemView.findViewById(R.id.project_pleadge);
            project_backers = itemView.findViewById(R.id.project_backers);
            project_sNo = itemView.findViewById(R.id.project_sNo);

        }
    }
}
