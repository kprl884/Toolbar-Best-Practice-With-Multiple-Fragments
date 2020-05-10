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


    /*   @NonNull
        @Override
        public ProjectsAdapter.DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_project_item
                    , parent, false);

            return new ProjectsAdapter.DetailViewHolder(view);
        }
    */


    /*   @Override
    public void onBindViewHolder(@NonNull ProjectsAdapter.DetailViewHolder holder, int position) {

        ProjectsModel projectsModel = projectsModels.get(position);
        holder.project_name.setText(projectsModel.getTitle());
        String stringPledged = "Pleadge :" + projectsModel.getAmtPledged();
        holder.project_pleadge.setText(stringPledged);
        holder.project_backers.setText(String.format("backers :%s", projectsModel.getNumBackers()));
        String stringSNo = "S no :" + projectsModel.getSNo();
        holder.project_sNo.setText(stringSNo);
        holder.itemView.setOnClickListener(v -> onMyAdapterItemClickListener.onItemClicked(position));
    }
*/
    @Override
    public int getItemCount() {
        return projectsModels.size();
    }

    /*// TODO: 10.05.2020 ProjectViewHolder olacak
    public class DetailViewHolder extends RecyclerView.ViewHolder {
        private TextView project_name, project_pleadge, project_backers, project_sNo;

        public DetailViewHolder(@NonNull View itemView) {
            super(itemView);
            project_name = itemView.findViewById(R.id.project_name);
            project_pleadge = itemView.findViewById(R.id.project_pleadge);
            project_backers = itemView.findViewById(R.id.project_backers);
            project_sNo = itemView.findViewById(R.id.project_sNo);

        }
    }*/
}
