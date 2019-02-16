package com.project.coding101.my.Introduction.Major_data;

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

public class Data_frag3 extends Fragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_data_frag3, container, false);

        ImageButton data_curry = (ImageButton)view.findViewById(R.id.data_curry);
        data_curry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Data_curry.class);
                startActivity(intent);
            }
        });

        ImageButton data_table = (ImageButton)view.findViewById(R.id.data_table);
        data_table.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Data_table.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
