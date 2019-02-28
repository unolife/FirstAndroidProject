package com.project.coding101.my.findEmalPassword;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.coding101.my.R;
import com.project.coding101.my.User;

public class FindEmail extends Fragment {

    private DatabaseReference mDatabase;
    private DatabaseReference userDB;

    EditText name, collagenum, tel;
    Button btn_find;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view1 = inflater.inflate(R.layout.find_email, container, false);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        userDB = mDatabase.child("users");

        name = view1.findViewById(R.id.EditText_name);
        collagenum = view1.findViewById(R.id.EditText_collagenum);
        tel = view1.findViewById(R.id.EditText_tel);
        btn_find = view1.findViewById(R.id.Button_find);

        userDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot uniqueUserSnapshot : dataSnapshot.getChildren()){

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return view1;
    }
}