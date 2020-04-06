package com.example.lastversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button detail_button_back;
    TextView detail_txtView;

    /**
     * TODO LIST
     * UI en yukarda solda geri butonu olacak.Geri butonu android'in standart geri butonu olacak. Bastigimda mainActivity'e donecek.
     * Altta senin secegin 3 tane bilgiyi onunde label olacak sekilde goruntuleyecek
     * Ornek:
     * (1. Textview) by: (2.Textview)"Tyrone Wells & Broken Eagle, LLC"
     * (3. Textview) country: (4.Textview)"US"
     * (5. Textview) currency: (6.Textview)"usd"
     * 1, 3 Ve 5. textviewlar sayfaya esit olarak dagilacak(chain kullanabilirsin).
     * Constraint Layout ile yapilacak
     * Activity ismi second olmayacak. Daha aciklayici olmasi lazim.
     * gitignore dosyasini android formatinda guncelle.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        detail_txtView = findViewById(R.id.detail_textView);
        Intent intent = getIntent();
        String msj_fromMainActivity = intent.getStringExtra("details");
        detail_txtView.setText(msj_fromMainActivity);

        //String detail_url = intent.getStringExtra("detail_url");

        detail_button_back = findViewById(R.id.detail_button_back);
        detail_button_back.setOnClickListener(view -> {
        onBackPressed();
         /*Intent intent1 = new Intent(SecondActivity.this,MainActivity.class);
         startActivity(intent1);*/
        });
    }
}
