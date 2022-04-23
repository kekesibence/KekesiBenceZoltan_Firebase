package com.example.kekesibencezoltan_firebase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InsertActivity  extends AppCompatActivity {
    private Button btnBack, btnAdd;
    private EditText editName, editCountry, editPopulation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_activity);
        init();
        DAOCity dao = new DAOCity();
        btnAdd.setOnClickListener(view -> {
            City city = new City(editName.getText().toString(), editCountry.getText().toString(), Integer.parseInt(editPopulation.getText().toString()));
            dao.add(city).addOnSuccessListener(suc -> {
                Toast.makeText(this, "Sikeres hozzáadás", Toast.LENGTH_SHORT).show();
            });
        });

        btnBack.setOnClickListener(view -> {
            Intent backIntent = new Intent(this, MainActivity.class);
            startActivity(backIntent);
            finish();
        });

    }

    private void init() {
        btnAdd = findViewById(R.id.btnAdd);
        btnBack = findViewById(R.id.btnBackFromInsert);
        editName = findViewById(R.id.editTextVarosNev);
        editCountry = findViewById(R.id.editTextVarosOrszag);
        editPopulation =findViewById(R.id.editTextLakossag);
    }
}
