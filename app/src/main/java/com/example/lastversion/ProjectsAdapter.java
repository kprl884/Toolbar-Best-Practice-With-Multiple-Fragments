package com.example.lastversion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ViewHolder> {
    private ArrayList<ProjectsModel> projectsModels;
    private Context context;

    public OnMyAdapterItemClickListener onMyAdapterItemClickListener;

    public ProjectsAdapter(ArrayList<ProjectsModel> projectsModels,Context context, OnMyAdapterItemClickListener onMyAdapterItemClickListener){
        this.projectsModels = projectsModels;
        this.context = context;
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

        ProjectsModel projectsModel = projectsModels.get(position);
        holder.project_name.setText(projectsModel.getTitle());
        String stringPledged = Integer.toString(projectsModel.getAmtPledged());
        holder.project_pleadge.append("Pleadge - $ " + stringPledged);
        holder.project_backers.append("Backers - " + projectsModel.getNumBackers());
        String stringSNo = Integer.toString(projectsModel.getSNo());
        holder.project_sNo.append("No. of Days to GO - " + stringSNo);

        holder.itemView.setOnClickListener(v -> onMyAdapterItemClickListener.onItemClicked(position));

    }

    @Override
    public int getItemCount() {
        return projectsModels.size();
    }



    //For now static, later control this line
    // TODO: 6.04.2020 ViewHolder ismi yine ne oldugunu anlatmiyor. Buraya DetailViewHolder diyebilirsin.

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
