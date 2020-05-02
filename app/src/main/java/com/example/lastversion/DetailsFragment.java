package com.example.lastversion;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    TextView detail_layout_title, detail_layout_blurb, detail_tv_blurb, detail_layout_location
            , detail_tv_location, detail_layout_state, detail_tv_state;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_details, container, false);

        detail_layout_title = v.findViewById(R.id.detail_tv_lbl_title);
        detail_layout_blurb = v.findViewById(R.id.detail_tv_lbl_blurb);
        detail_tv_blurb = v.findViewById(R.id.detail_tv_blurb);
        detail_layout_location = v.findViewById(R.id.detail_tv_lbl_location);
        detail_tv_location = v.findViewById(R.id.detail_tv_location);
        detail_layout_state = v.findViewById(R.id.detail_tv_lbl_state);
        detail_tv_state = v.findViewById(R.id.detail_tv_state);


        Bundle bundle = this.getArguments();
        ProjectsModel projectsModel = null;
        if (bundle != null) {
            projectsModel = bundle.getParcelable("ProjectsInfo");
        }

        String blurb = projectsModel.getBlurb();
        if (blurb != null) {
            detail_tv_blurb.setText(blurb);
        }

        detail_tv_location.setText(projectsModel.getLocation());

        detail_tv_state.setText(projectsModel.getState());

        detail_layout_title.setText(projectsModel.getTitle());

        return v;
    }

}
