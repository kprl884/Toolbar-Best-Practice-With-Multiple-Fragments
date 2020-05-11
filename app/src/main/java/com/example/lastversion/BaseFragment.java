package com.example.lastversion;

import android.content.Context;
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
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.lastversion.databinding.ActivityMainBinding;
import com.example.lastversion.databinding.ToolbarLayoutBinding;
import com.example.lastversion.models.ProjectsModel;

import java.util.Objects;

public class BaseFragment extends Fragment {

    protected MainActivity mainActivity;
    ActivityMainBinding binding;
    Button backButtonToolbar;
    TextView titleToolbar;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = ((MainActivity) context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.toolbar_layout, container, false);
            ProjectsModel a = new ProjectsModel("a",1,"a",2);
            Objects.requireNonNull(getActivity()).setActionBar(binding.toolbarInclude.toolbarLayout);


        }
        return binding.getRoot();}

        protected void updateToolbarBindingHome(String appName){
            //binding.toolbarInclude.toolbarBackBtn.setVisibility(View.GONE);
            //binding.toolbarInclude.toolbarTitle.setText(appName);
        }

        protected void updateToolbarBindingPM(ProjectsModel projectsModel){
            //binding.setProje(new ProjectsModel(projectsModel.getTitle(),projectsModel.getAmtPledged(),projectsModel.getNumBackers(),projectsModel.getSNo()));
            //binding.toolbarInclude.toolbarTitle.setText(projectsModel.getTitle());
            //binding.toolbarInclude.toolbarBackBtn.setVisibility(View.VISIBLE);
        }

    protected void updateToolbar(String s, boolean b) {

        androidx.appcompat.widget.Toolbar toolbar = mainActivity.findViewById(R.id.toolbar_include);
        mainActivity.setSupportActionBar(toolbar);
        Button toolbar_back_btn = toolbar.findViewById(R.id.toolbar_back_btn);
        TextView toolbar_title = toolbar.findViewById(R.id.toolbar_title);
        toolbar_title.setText(s);
        if(b){
            toolbar_back_btn.setVisibility(View.VISIBLE);
        }else {
            toolbar_back_btn.setVisibility(View.INVISIBLE);
        }
    }

}

