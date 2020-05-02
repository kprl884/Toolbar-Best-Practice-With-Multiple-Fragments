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

    // TODO: 2.05.2020 Hicbir zaman view objelerini field olarak tanimlama

    private TextView detail_tv_state;

    public static String TAG = DetailsFragment.class.getSimpleName();

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
        View v = inflater.inflate(R.layout.fragment_details, container, false);

        TextView detail_layout_title = v.findViewById(R.id.detail_tv_lbl_title);
        TextView detail_layout_blurb = v.findViewById(R.id.detail_tv_lbl_blurb);
        TextView detail_tv_blurb = v.findViewById(R.id.detail_tv_blurb);
        TextView detail_layout_location = v.findViewById(R.id.detail_tv_lbl_location);
        TextView detail_tv_location = v.findViewById(R.id.detail_tv_location);
        TextView detail_layout_state = v.findViewById(R.id.detail_tv_lbl_state);
        detail_tv_state = v.findViewById(R.id.detail_tv_state);

        // TODO: 2.05.2020 yine mainActivity'deki toobarin title'ini proje ismi olarak guncelle
        // Back butonu gelecek
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
