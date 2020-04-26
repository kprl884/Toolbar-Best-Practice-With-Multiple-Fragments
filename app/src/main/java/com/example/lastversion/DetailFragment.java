package com.example.lastversion;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class DetailFragment extends Fragment {

    private ProjectsModel projectsModels;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_detail, container, false);

        TextView detail_layout_title = v.findViewById(R.id.detail_tv_lbl_title);
        TextView detail_layout_blurb = v.findViewById(R.id.detail_tv_lbl_blurb);
        TextView detail_tv_blurb = v.findViewById(R.id.detail_tv_blurb);
        TextView detail_layout_location = v.findViewById(R.id.detail_tv_lbl_location);
        TextView detail_tv_location = v.findViewById(R.id.detail_tv_location);
        TextView detail_layout_state = v.findViewById(R.id.detail_tv_lbl_state);
        TextView detail_tv_state = v.findViewById(R.id.detail_tv_state);

        assert projectsModels != null;
        String blurb = projectsModels.getBlurb();
        if (blurb != null) {
            detail_tv_blurb.setText(blurb);
        }

        detail_tv_location.setText(projectsModels.getLocation());

        detail_tv_state.setText(projectsModels.getState());

        detail_layout_title.setText(projectsModels.getTitle());

        return v;
    }

    public void sendProjectObject(ProjectsModel projectsModel) {

        projectsModels = projectsModel;
    }
}
