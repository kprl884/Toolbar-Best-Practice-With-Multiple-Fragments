package com.example.lastversion;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.lastversion.databinding.FragmentDetailsBinding;
import com.example.lastversion.models.ProjectsModel;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends BaseFragment {

    public static String TAG = DetailsFragment.class.getSimpleName();

    private FragmentDetailsBinding binding;

    public static DetailsFragment newInstance(ProjectsModel project) {

        Bundle args = new Bundle();

        args.putParcelable("ProjectsInfo", project);

        DetailsFragment fragment = new DetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false);
            Bundle bundle = getArguments();
            ProjectsModel projectsModel;
            if (bundle != null) {
                projectsModel = bundle.getParcelable("ProjectsInfo");
                binding.setDataDetail(projectsModel);
                String titleProject = projectsModel.getTitle();
                if (titleProject != null) {
                    updateToolbar(titleProject,true);
                }
            }
        }
        return binding.getRoot();
    }

}
