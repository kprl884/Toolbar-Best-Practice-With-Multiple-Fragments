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

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = ((MainActivity) context);
    }
}

