package com.project.coding101.my.Introduction.Academy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.project.coding101.my.R;

public class Academy extends AppCompatActivity {

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReference();
    StorageReference pathReference = storageRef.child("images/data_table.jpg");
    StorageReference gsReference = storage.getReferenceFromUrl("gs://myandroid-59ff1.appspot.com/images/data_table.jpg");
    StorageReference httpReference = storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/v0/b/myandroid-59ff1.appspot.com/o/images%2Fdata_table.jpg?alt=media&token=a2d3189a-d351-48c2-874b-cd1c0f36ddc6");
    StorageReference tableRef = storageRef.child("images/data_table.jpg");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academy);
    }

    protected void downloadDirect(){
        StorageReference ref = FirebaseStorage.getInstance().getReference("images/data_table.jpg");
        ImageView imageView = findViewById(R.id.ImageView);
        Glide.with(this)
                .load(ref)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
    }




}
