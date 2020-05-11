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

import java.util.Objects;

public class BaseFragment extends Fragment {

    protected MainActivity mainActivity;
    ActivityMainBinding binding;
    android.widget.Toolbar toolbar;
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
            toolbar = binding.toolbarInclude.toolbarLayout;
            Objects.requireNonNull(getActivity()).setActionBar(binding.toolbarInclude.toolbarLayout);
        }
/*
    protected void updateToolbar(String s, boolean b) {
         backButtonToolbar = toolbar.findViewById(R.id.toolbar_back_btn);
         titleToolbar = toolbar.findViewById(R.id.toolbar_title);
        titleToolbar.setText(s);
        if(b){
            //binding.toolbarInclude.toolbarBackBtn.setVisibility(View.VISIBLE);
            //backButtonToolbar.setVisibility(View.VISIBLE);
            //backButtonToolbar.setOnClickListener(v -> getActivity().onBackPressed());
        }else {
            //binding.toolbarInclude.toolbarBackBtn.setVisibility(View.INVISIBLE);
            //backButtonToolbar.setVisibility(View.INVISIBLE);
        }
    }
    */
        return binding.getRoot();
    }
}

