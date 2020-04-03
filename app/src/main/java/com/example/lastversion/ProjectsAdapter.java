package com.example.lastversion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ViewHolder> {

    private ArrayList<ProjectsModel> projectsModels;
    private OnProjectListener mOnNoteListener;


    public ProjectsAdapter(ArrayList<ProjectsModel> projectsModels){
        //mOnNoteListener = (OnProjectListener) onProjectListener;
        this.projectsModels = projectsModels;
    }

    @NonNull
    @Override
    public ProjectsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.projects_list_item2
        ,parent, false);

        return new ProjectsAdapter.ViewHolder(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectsAdapter.ViewHolder holder, int position) {
        //TODO: NULL Check
            //ProjectsModel currentProject = projectsModels.get(position);
        // TODO: 31.03.2020 Null Check And Type Check
        holder.project_name.setText(projectsModels.get(position).getTitle());
        holder.project_pleadge.setText("Pleadge - $ " + Integer.toString(projectsModels.get(position).getAmtPledged()));
        holder.project_backers.setText("Backers - " + projectsModels.get(position).getNumBackers());
        holder.project_sNo.setText("No. of Days to GO - " + Integer.toString(projectsModels.get(position).getSNo()));



    }

    @Override
    public int getItemCount() {
        return projectsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView project_name, project_pleadge, project_backers, project_sNo;
        OnProjectListener onProjectListener;

        public ViewHolder(@NonNull View itemView, OnProjectListener onProjectListener) {
            super(itemView);
            project_name = itemView.findViewById(R.id.project_name);
            project_pleadge = itemView.findViewById(R.id.project_pleadge);
            project_backers = itemView.findViewById(R.id.project_backers);
            project_sNo = itemView.findViewById(R.id.project_sNo);

            this.onProjectListener = onProjectListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onProjectListener.OnProjectClick(getAdapterPosition());
        }
    }

    public interface OnProjectListener{
        void OnProjectClick(int position);
    }
}
