package com.example.lastversion;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.lastversion.databinding.FragmentDetailsBinding;
import com.example.lastversion.models.ProjectsModel;


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
        if(binding==null){
            FragmentDetailsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false);
        }


        /*
        View v = inflater.inflate(R.layout.fragment_details, container, false);

        FragmentDetailsBinding binding = DataBindingUtil.setContentView(getActivity(),R.layout.fragment_details);


        TextView detail_layout_title = v.findViewById(R.id.detail_tv_lbl_title);
        TextView detail_layout_blurb = v.findViewById(R.id.detail_tv_lbl_blurb);
        TextView detail_tv_blurb = v.findViewById(R.id.detail_tv_blurb);
        TextView detail_layout_location = v.findViewById(R.id.detail_tv_lbl_location);
        TextView detail_tv_location = v.findViewById(R.id.detail_tv_location);
        TextView detail_layout_state = v.findViewById(R.id.detail_tv_lbl_state);
        TextView detail_tv_state = v.findViewById(R.id.detail_tv_state);

        String blurb = projectsModel.getBlurb();
        if (blurb != null) {
            detail_tv_blurb.setText(blurb);
        }

        detail_tv_location.setText(projectsModel.getLocation());

        detail_tv_state.setText(projectsModel.getState());

        detail_layout_title.setText(projectsModel.getTitle());

        return v;
        */

        Bundle bundle = this.getArguments();
        ProjectsModel projectsModel = null;
        if (bundle != null) {
            projectsModel = bundle.getParcelable("ProjectsInfo");
        }

        binding.setDataDetail(projectsModel);

        assert projectsModel != null;
        String titleProject = projectsModel.getTitle();
        updateToolbar(titleProject,true);




        return binding.getRoot();
    }

}
