package com.example.lastversion;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class BaseFragment extends Fragment {

    protected MainActivity mainActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = ((MainActivity) context);
        updateToolbar("",false);
    }

    protected void updateToolbar(String s, boolean b) {
        android.widget.Toolbar toolbar =  mainActivity.findViewById(R.id.toolbar_include);
        Objects.requireNonNull(getActivity()).setActionBar(toolbar);
        Button backButtonToolbar = toolbar.findViewById(R.id.toolbar_back_btn);
        TextView titleToolbar = toolbar.findViewById(R.id.toolbar_title);
        titleToolbar.setText(s);

        if(b){
            backButtonToolbar.setVisibility(View.VISIBLE);
            backButtonToolbar.setOnClickListener(v -> getActivity().onBackPressed());
        }else {
            backButtonToolbar.setVisibility(View.INVISIBLE);
        }


    }

}
