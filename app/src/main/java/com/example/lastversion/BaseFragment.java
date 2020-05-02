package com.example.lastversion;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/**
 * Created by mertselcukdemir on 2.05.2020
 * Copyright (c) 2020 Twin Science & Robotics to present
 * All rights reserved.
 */
public class BaseFragment extends Fragment {

    protected MainActivity mainActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = ((MainActivity) context);
    }
}
