package com.example.lastversion;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

import static com.example.lastversion.R.drawable.back;

public class DetailActivity extends AppCompatActivity {

    TextView detail_layout_title, detail_layout_blurb, detail_tv_blurb, detail_layout_location
            , detail_tv_location, detail_layout_state, detail_tv_state;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        Button back_tb_btn = toolbar.findViewById(R.id.detail_toolbar_btn);
        back_tb_btn.setOnClickListener(v -> onBackPressed());

        detail_layout_title = findViewById(R.id.detail_tv_lbl_title);
        detail_layout_blurb = findViewById(R.id.detail_tv_lbl_blurb);
        detail_tv_blurb = findViewById(R.id.detail_tv_blurb);
        detail_layout_location = findViewById(R.id.detail_tv_lbl_location);
        detail_tv_location = findViewById(R.id.detail_tv_location);
        detail_layout_state = findViewById(R.id.detail_tv_lbl_state);
        detail_tv_state = findViewById(R.id.detail_tv_state);

        Intent intent = getIntent();
        ProjectsModel projectsModel = intent.getParcelableExtra("projectObject");

        assert projectsModel != null;
        String blurb = projectsModel.getBlurb();
        if (blurb != null) {
            detail_tv_blurb.setText(blurb);
        }

        detail_tv_location.setText(projectsModel.getLocation());

        detail_tv_state.setText(projectsModel.getState());

        detail_layout_title.setText(projectsModel.getTitle());

    }
}
