package com.example.lastversion;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


public class BaseFragment extends Fragment {

    protected MainActivity mainActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = ((MainActivity) context);
    }


}

