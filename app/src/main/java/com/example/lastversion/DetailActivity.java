package com.example.lastversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    Button detail_button_back;
    TextView detail_layout_title, detail_layout_blurb, detail_tv_blurb, detail_layout_location
            , detail_tv_location, detail_layout_state, detail_tv_state;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detail_layout_title = findViewById(R.id.detail_layout_title);
        detail_layout_blurb = findViewById(R.id.detail_layout_blurb);
        detail_tv_blurb = findViewById(R.id.detail_tv_blurb);
        detail_layout_location = findViewById(R.id.detail_layout_location);
        detail_tv_location = findViewById(R.id.detail_tv_location);
        detail_layout_state = findViewById(R.id.detail_layout_state);
        detail_tv_state = findViewById(R.id.detail_tv_state);


        Intent intent = getIntent();
        ProjectsModel projectsModel = intent.getParcelableExtra("projectObject");


        detail_layout_blurb.setText("Blurb : ");
        detail_tv_blurb.setText(projectsModel.getBlurb());

        detail_layout_location.setText("Location : ");
        detail_tv_location.setText(projectsModel.getLocation());

        detail_layout_state.setText("State : ");
        detail_tv_state.setText(projectsModel.getState());

        detail_layout_title.setText(projectsModel.getTitle());

        detail_button_back = findViewById(R.id.detail_btn_back);
        detail_button_back.setOnClickListener(view -> {
        onBackPressed();
        });
    }
}
