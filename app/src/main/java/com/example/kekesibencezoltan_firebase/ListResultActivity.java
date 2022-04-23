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
    private DatabaseReference dbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_result_activity);
        init();
        dbRef = FirebaseDatabase.getInstance().getReference("Cities");

        btnBackFromList.setOnClickListener(view -> {
            Intent backIntent = new Intent(this, MainActivity.class);
            startActivity(backIntent);
            finish();
        });

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot child: dataSnapshot.getChildren()) {
                    Log.e("Response", "child of child: " + child.child("City"));
                    City c = child.child("City").getValue(City.class);
                    String baseText = textViewCityList.getText().toString();
                    textViewCityList.setText(baseText + c.toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("FireBaseError", "message: " + databaseError );
            }
        });
    }

    private void init() {
        btnBackFromList = findViewById(R.id.btnBackFromList);
        textViewCityList = findViewById(R.id.varosokListView);
    }
}
