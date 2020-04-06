package com.example.lastversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button detail_button_back;
    TextView detail_txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        detail_txtView = findViewById(R.id.detail_textView);
        Intent intent = getIntent();
        String msj_fromMainActivity = intent.getStringExtra("details");
        detail_txtView.setText(msj_fromMainActivity);

        String detail_url = intent.getStringExtra("detail_url");
        new DownloadImageTask(findViewById(R.id.detail_url_image)).execute("detail_url");

        detail_button_back = findViewById(R.id.detail_button_back);
        detail_button_back.setOnClickListener(view -> {
         Intent intent1 = new Intent(SecondActivity.this,MainActivity.class);
         startActivity(intent1);
        });
    }
}
