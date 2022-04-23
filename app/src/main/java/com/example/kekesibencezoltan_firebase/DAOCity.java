package com.example.kekesibencezoltan_firebase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DAOCity {
    private DatabaseReference databaseReference;
    private List<City> cityList;
    public DAOCity() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(City.class.getSimpleName());
    }
    public Task<Void> add(City city) {
       return  databaseReference.push().setValue(city);
    }

    public List<City> get() {
        cityList = new ArrayList<>();
        DatabaseReference reference = databaseReference.child("City");
        ValueEventListener getListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    Log.e("snapshots: ", "onDataChange: " + snapshot.toString());
                    City c = snapshot.getValue(City.class);
                    cityList.add(c);
                }
                Log.e("onRespone", "onDataChange: " + cityList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        reference.addValueEventListener(getListener);
        return cityList;
    }
}
