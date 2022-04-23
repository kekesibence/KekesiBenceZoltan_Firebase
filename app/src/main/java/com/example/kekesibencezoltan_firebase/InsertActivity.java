package com.example.kekesibencezoltan_firebase;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InsertActivity  extends AppCompatActivity {
    private Button btnBack, btnAdd;
    private EditText editName, editCountry, editPopulation;
    private DatabaseReference dbRef;
    private int cityCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_activity);
        init();
        dbRef = FirebaseDatabase.getInstance().getReference("Cities");

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot child: dataSnapshot.getChildren()) { cityCount++; }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("FirebaseError", "onCancelled: " + databaseError );
            }
        });

        btnAdd.setOnClickListener(view -> {
            if (!editName.getText().toString().isEmpty()) {
                if (!editCountry.getText().toString().isEmpty()) {
                    if (!editPopulation.getText().toString().isEmpty()) {
                        City city = new City(
                                cityCount++,
                                editName.getText().toString(),
                                editCountry.getText().toString(),
                                Integer.parseInt(editPopulation.getText().toString())
                        );
                        dbRef.push().child("City").setValue(city).addOnSuccessListener( succes ->
                                Toast.makeText(this, "Új város hozzáadva", Toast.LENGTH_SHORT).show()
                        );
                    }else {
                        Toast.makeText(this, "Lakosság nem lehet üres", Toast.LENGTH_SHORT).show();

                    }
                }else {
                    Toast.makeText(this, "Ország nem lehet üres", Toast.LENGTH_SHORT).show();

                }
            }else {
                Toast.makeText(this, "Név nem lehet üres", Toast.LENGTH_SHORT).show();

            }
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
