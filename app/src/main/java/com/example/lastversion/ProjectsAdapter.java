package com.example.lastversion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ViewHolder> {

    private ArrayList<ProjectsModel> projectsModels;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener (OnItemClickListener listener) {
        mListener = listener;
    }

    public ProjectsAdapter(ArrayList<ProjectsModel> projectsModels){
        //mOnNoteListener = (OnProjectListener) onProjectListener;
        this.projectsModels = projectsModels;
    }

    @NonNull
    @Override
    public ProjectsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.projects_list_item2
        ,parent, false);

        return new ProjectsAdapter.ViewHolder(view, mListener);
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

    //For now static, later control this line
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView project_name, project_pleadge, project_backers, project_sNo;
        private Button project_button;


        public ViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            project_button = itemView.findViewById(R.id.project_button);
            project_name = itemView.findViewById(R.id.project_name);
            project_pleadge = itemView.findViewById(R.id.project_pleadge);
            project_backers = itemView.findViewById(R.id.project_backers);
            project_sNo = itemView.findViewById(R.id.project_sNo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}
