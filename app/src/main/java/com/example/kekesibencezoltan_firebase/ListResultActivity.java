package com.example.kekesibencezoltan_firebase;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListResultActivity extends AppCompatActivity {
    private Button  btnAdd;
    private TextView textViewCityList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_activity);
        init();
    }

    private void init() {
        btnAdd = findViewById(R.id.btnFelvetel);
        textViewCityList = findViewById(R.id.varosokListView);
    }
}
