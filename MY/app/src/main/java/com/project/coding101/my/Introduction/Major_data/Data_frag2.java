package com.project.coding101.my.Introduction.Major_data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.coding101.my.R;

public class Data_frag2 extends Fragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_data_frag2, container, false);

        TextView tel1 = (TextView)view.findViewById(R.id.tel1);
        tel1.setAutoLinkMask(Linkify.PHONE_NUMBERS);

        TextView tel2 = (TextView)view.findViewById(R.id.tel2);
        tel2.setAutoLinkMask(Linkify.PHONE_NUMBERS);

        TextView tel3 = (TextView)view.findViewById(R.id.tel3);
        tel3.setAutoLinkMask(Linkify.PHONE_NUMBERS);

        TextView tel4 = (TextView)view.findViewById(R.id.tel4);
        tel4.setAutoLinkMask(Linkify.PHONE_NUMBERS);

        TextView tel5 = (TextView)view.findViewById(R.id.tel5);
        tel5.setAutoLinkMask(Linkify.PHONE_NUMBERS);

        return view;
    }
}
