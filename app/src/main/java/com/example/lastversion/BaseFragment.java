package com.example.lastversion;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class BaseFragment extends Fragment {

    protected MainActivity mainActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = ((MainActivity) context);

        String titleToolbar = String.valueOf(R.string.app_name);

        updateToolbar(titleToolbar,false);
    }

    protected void updateToolbar(String toolbarTitle, boolean isBack) {

        Toolbar toolbar = mainActivity.findViewById(R.id.toolbar_layout);
        mainActivity.setSupportActionBar(toolbar);
        /*Button toolbar_back_btn = toolbar.findViewById(R.id.toolbar_back_btn);
        TextView toolbar_title = toolbar.findViewById(R.id.toolbar_title);
        toolbar_title.setText(toolbarTitle);

        if(isBack){
            toolbar_back_btn.setVisibility(View.VISIBLE);
        }else {
            toolbar_back_btn.setVisibility(View.INVISIBLE);
        }*/
    }
}
