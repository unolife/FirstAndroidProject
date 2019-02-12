package com.project.coding101.my.Introduction.Major_soft;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.project.coding101.my.R;

public class Soft_frag3 extends Fragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_soft_frag3, container, false);

        ImageButton soft_curry = (ImageButton)view.findViewById(R.id.soft_curry);
        soft_curry.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Soft_curry.class);
                startActivity(intent);
            }
        });

        ImageButton soft_table = (ImageButton)view.findViewById(R.id.soft_table);
        soft_table.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Soft_table.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
