package hyejin.my;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CreateActivity extends AppCompatActivity {
    // public void main(String args[]){}
    private FirebaseAuth mAuth;
    private String TAG = "Email, PassWord";

    String email,password;
    EditText email_textfield,password_textfield ;

    Button btn_join;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createacount);

        email_textfield = findViewById(R.id.EditText_Email);
        password_textfield = findViewById(R.id.EditText_Password);
        btn_join = findViewById(R.id.Button_join);

        mAuth = FirebaseAuth.getInstance();

        email_textfield.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{email = s.toString();}catch (NullPointerException e){}
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password_textfield.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{password = s.toString();}catch (NullPointerException e){}
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btn_join.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createAccount(email,password);
            }
        });
    }

    private void createAccount(String email, String password){

        if(!validateForm()){return;}

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(CreateActivity.this, "회원가입 실패",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    private boolean validateForm(){
        boolean valid =true;

        String email = email_textfield.getText().toString();
        if(TextUtils.isEmpty(email)){
            email_textfield.setError("필수입력 항목입니다.");
            valid =false;
        }else{
            email_textfield.setError(null);
        }

        String password = password_textfield.getText().toString();
        if(TextUtils.isEmpty(password)){
            password_textfield.setError("필수입력 항목입니다.");
            valid =false;
        }else{
            password_textfield.setError(null);
        }
        return valid;
    }

}
