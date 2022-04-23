package com.example.kekesibencezoltan_firebase;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class ListResultActivity extends AppCompatActivity {
    private Button btnBackFromList;
    private TextView textViewCityList;
    private List<City> cityList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_result_activity);
        init();
        DAOCity dao = new DAOCity();
        cityList = dao.get();
        Log.e("listResultActivity", "onCreate: " + cityList);
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
