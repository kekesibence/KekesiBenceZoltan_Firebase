package com.example.kekesibencezoltan_firebase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListResultActivity extends AppCompatActivity {
    private Button btnBackFromList;
    private TextView textViewCityList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_result_activity);
        init();

        btnBackFromList.setOnClickListener(view -> {
            Intent backIntent = new Intent(this, MainActivity.class);
            startActivity(backIntent);
            finish();
        });
    }

    private void init() {
        btnBackFromList = findViewById(R.id.btnBackFromList);
        textViewCityList = findViewById(R.id.varosokListView);
    }
}
