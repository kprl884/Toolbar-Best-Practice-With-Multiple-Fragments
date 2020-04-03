package com.example.lastversion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// TODO: 1.04.2020 Class isimlerinin buyuk harfle baslamasi lazim
public class DetailActivity extends Activity {

    Button detail_button_back;
    //ImageView detail_imageView_url;
    TextView detail_txtView;





    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.details);

        Log.d("debuh", "degub");

        detail_txtView = findViewById(R.id.detail_textView);
        Intent intent = getIntent();
        String msj_fromMainActivity = intent.getStringExtra("detail_toString");
        detail_txtView.setText(msj_fromMainActivity);

        String detail_url = intent.getStringExtra("detail_url");
        new DownloadImageTask(findViewById(R.id.detail_url_image)).execute("detail_url");

        detail_button_back = findViewById(R.id.detail_button_back);
        detail_button_back.setOnClickListener(view -> {
            Intent intent1 = new Intent(DetailActivity.this,MainActivity.class);
            startActivity(intent1);
        });
    }
}
