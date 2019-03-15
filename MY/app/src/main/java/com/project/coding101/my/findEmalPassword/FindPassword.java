package com.project.coding101.my.findEmalPassword;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.project.coding101.my.R;

public class FindPassword extends Fragment {

    String email;
    Button btn_send;
    private static final String TAG = "MainActivity";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view1 = inflater.inflate(R.layout.find_password, container, false);

        email = view1.findViewById(R.id.EditText_Email).toString();
        btn_send = view1.findViewById(R.id.Button_sendEmail);

        return view1;
    }

    public void sendPasswordReset() {
        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Log.d(TAG, "Email sent.");
                        }
                    }
                });
    }

}