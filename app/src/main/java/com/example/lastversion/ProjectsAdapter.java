package com.example.lastversion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastversion.ProjectsModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.http.HEAD;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ViewHolder> {

    private ArrayList<ProjectsModel> projectsModels;

    private OnItemClickListener mListener;



    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }


    public ProjectsAdapter(ArrayList<ProjectsModel> projectsModels){

        this.projectsModels = projectsModels;
    }

    @NonNull
    @Override
    public ProjectsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.projects_list_item
        ,parent, false);

        return new ProjectsAdapter.ViewHolder(view,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectsAdapter.ViewHolder holder, int position) {
        //TODO: NULL Check
            ProjectsModel currentProject = projectsModels.get(position);
        // TODO: 31.03.2020 Null Check And Type Check
        holder.project_name.setText(projectsModels.get(position).getTitle());
        holder.project_pleadge.setText(Integer.toString(projectsModels.get(position).getAmtPledged()));
        holder.project_backers.setText(projectsModels.get(position).getNumBackers());
        holder.project_sNo.setText(Integer.toString(projectsModels.get(position).getSNo()));

    }

    @Override
    public int getItemCount() {
        return projectsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView project_name, project_pleadge, project_backers, project_sNo;
        public ViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            project_name = itemView.findViewById(R.id.project_name);
            project_pleadge = itemView.findViewById(R.id.project_pleadge);
            project_backers = itemView.findViewById(R.id.project_backers);
            project_sNo = itemView.findViewById(R.id.project_sNo);

            itemView.setOnClickListener(view -> {
                if(listener != null){
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }
}
