package com.example.getjob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText memail_login, mpassword_login;
    Button mloginbutton;
    TextView mcreate_account;
    ProgressBar pgbar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        memail_login = findViewById(R.id.email_login);
        mpassword_login = findViewById(R.id.password_login);
        pgbar = findViewById(R.id.pgbar);
        fAuth = FirebaseAuth.getInstance();
        mloginbutton = findViewById(R.id.loginbutton);
        mcreate_account = findViewById(R.id.create_account);

        mloginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = memail_login.getText().toString().trim();
                String password = mpassword_login.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    memail_login.setError("Email is Required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    mpassword_login.setError("Password is Required");
                    return;
                }

                if (password.length() < 6) {
                    mpassword_login.setError("Password must be more than 6 Characters");
                    return;
                }

                pgbar.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Login.this,"Login Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else {
                            Toast.makeText(Login.this, "Your Email or Password is Incorrect!" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            pgbar.setVisibility(View.GONE);
                        }
                    }
                });

            }
        });

        mcreate_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });

    }
}