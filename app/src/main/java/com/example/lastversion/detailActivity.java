package com.example.lastversion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class detailActivity extends Activity {

    Button detail_button_back;
    ImageView detail_imageView_url;
    TextView detail_txtView;



    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.details);

        detail_txtView = (TextView)findViewById(R.id.detail_textView);
        Intent intent = getIntent();
        String msj_fromMainActivity = intent.getStringExtra("detail_toString");
        detail_txtView.setText(msj_fromMainActivity);

        String detail_url = intent.getStringExtra("detail_url");
        new DownloadImageTask((ImageView) findViewById(R.id.detail_url_image)).execute("detail_url");

        detail_button_back = (Button)findViewById(R.id.detail_button_back);
        detail_button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(detailActivity.this,MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
