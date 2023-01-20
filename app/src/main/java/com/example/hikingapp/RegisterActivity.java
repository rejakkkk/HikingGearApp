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
import com.google.firebase.auth.UserProfileChangeRequest;

public class RegisterActivity extends AppCompatActivity {
    private EditText editUsername, editEmail, editPassword, editPassConfirm;
    private Button btnRegister;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        editUsername = findViewById(R.id.username);
        editEmail= findViewById(R.id.email);
        editPassword= findViewById(R.id.password);
        editPassConfirm= findViewById(R.id.password_confirmation);
        btnRegister=findViewById(R.id.btn_register);

        mAuth= FirebaseAuth.getInstance();
        progressDialog= new ProgressDialog(RegisterActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.setCancelable(false);

        btnRegister.setOnClickListener(view -> {
            if(editUsername.getText().length()>0 && editEmail.getText().length()>0 && editPassword.getText().length()>0 && editPassConfirm.getText().length()>0){
                if(editPassword.getText().toString().equals(editPassConfirm.getText().toString())){
                    register(editUsername.getText().toString(), editEmail.getText().toString(), editPassword.getText().toString());
                }else {
                    Toast.makeText(getApplicationContext(), "Silahkan masukan password yang sama!", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(getApplicationContext(), "Silahkan isi data dahulu!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void register(String username, String email, String password){
        /* TODO Implement Method Register */
        progressDialog.show();
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful() && task.getResult() != null) {
                    FirebaseUser firebaseUser = task.getResult().getUser();
                    if (firebaseUser != null){
                        UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                                .setDisplayName(username)
                                .build();
                        firebaseUser.updateProfile(request).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            reload();
                        }
                        });
                    }else{
                        Toast.makeText(getApplicationContext(), "Register Failed", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
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
