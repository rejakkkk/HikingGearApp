package com.example.hikingapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.hikingapp.Bar.ArticleActivity;
import com.example.hikingapp.Bar.CartListActivity;
import com.example.hikingapp.Bar.ProfileActivity;
import com.example.hikingapp.Bar.ReviewActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private EditText editEmail, editPass;
    private Button btnLogin, btnRegister;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        editEmail= findViewById(R.id.etEmail);
        editPass= findViewById(R.id.etPassword);
        btnLogin= findViewById(R.id.btnLogin);
        btnRegister= findViewById(R.id.btnRegister);

        mAuth= FirebaseAuth.getInstance();
        progressDialog= new ProgressDialog(LoginActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.setCancelable(false);

        btnRegister.setOnClickListener(v ->{
            startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
        });

        btnLogin.setOnClickListener(view -> {
            if(editEmail.getText().length()>0 && editPass.getText().length()>0){
                login(editEmail.getText().toString(), editPass.getText().toString());
            }else{
                Toast.makeText(getApplicationContext(), "Silahkan isi data dahulu", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void login(String email, String password){
        /* TODO Implement Method Login */
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful() && task.getResult() != null){
                    if (task.getResult().getUser() != null){
                        reload();
                    }else{
                        Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void reload(){
        startActivity(new Intent(getApplicationContext(), CartListActivity.class));
        startActivity(new Intent(getApplicationContext(), ArticleActivity.class));
        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        startActivity(new Intent(getApplicationContext(), ReviewActivity.class));
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

}
