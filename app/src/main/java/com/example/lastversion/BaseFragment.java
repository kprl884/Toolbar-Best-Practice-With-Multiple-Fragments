package com.example.lastversion;

import android.content.Context;
import android.os.Bundle;
import android.transition.Visibility;
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
    ToolbarLayoutBinding binding2;
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
                binding = DataBindingUtil.inflate(inflater, R.layout.activity_main, container, false);

                ProjectsModel a = new ProjectsModel("a",1,"a",2);

                binding.toolbarLayout.setToolbarProject(a);

                Button butonson = binding.toolbarLayout.toolbarBackBtn;

                butonson.setVisibility(View.INVISIBLE);

                binding.toolbarLayout.toolbarBackBtn.setVisibility(View.VISIBLE);



            //binding.toolbarLayout.setToolbarProject(a);
            //binding.toolbarLayout.toolbarTitle.setText("aaaaaasdsadasdsadas");
            //binding.toolbarLayout.toolbarBackBtn.setVisibility(View.VISIBLE);
            //binding.toolbarInclude.toolbarBackBtn.setVisibility(View.GONE)
            //binding2.toolbarBackBtn.setVisibility(View.GONE);
            //android.widget.Toolbar toolbar = binding2.toolbarLayout;
            // getActivity().setActionBar(toolbar);
            //binding2.setToolbarProject(a);
            //Button newButtn = binding2.toolbarBackBtn;
            //newButtn.setVisibility(View.INVISIBLE);
            //binding = DataBindingUtil.inflate(inflater, R.layout.toolbar_layout, container, false);
            //Objects.requireNonNull(getActivity()).setActionBar(binding.toolbarInclude.toolbarLayout);
        }
        return binding2.getRoot();}

        protected void updateToolbarBindingHome(String appName){
            //binding.setProje();
            //binding2.toolbarTitle.setText(appName);
            //binding.toolbarInclude.toolbarTitle.setText(appName);
            //binding.toolbarInclude.toolbarBackBtn.setVisibility(View.GONE);
            //(ActivityMainBinding)DataBindingUtil.setContentView(mainActivity,R.layout.toolbar_layout).
        }
        protected void updateToolbarBindingPM(ProjectsModel projectsModel){

            //binding.setProje(new ProjectsModel(projectsModel.getTitle(),projectsModel.getAmtPledged(),projectsModel.getNumBackers(),projectsModel.getSNo()));
            //binding.toolbarInclude.toolbarTitle.setText(projectsModel.getTitle());
            //binding2.toolbarBackBtn.setVisibility(View.VISIBLE);
        }
    /*
    protected void updateToolbar(String s, boolean b) {
        androidx.appcompat.widget.Toolbar toolbar = mainActivity.findViewById(R.id.toolbar_layout);
        mainActivity.setSupportActionBar(toolbar);
        Button toolbar_back_btn = toolbar.findViewById(R.id.toolbar_back_btn);
        TextView toolbar_title = toolbar.findViewById(R.id.toolbar_title);
        toolbar_title.setText(s);
        if(b){
            toolbar_back_btn.setVisibility(View.VISIBLE);
        }else {
            toolbar_back_btn.setVisibility(View.INVISIBLE);
        }
    }*/
}

