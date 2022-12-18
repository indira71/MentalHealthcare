package com.kelompok_6.mentalhealthcare;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kelompok_6.mentalhealthcare.databinding.ActivityLoginBinding;
import com.kelompok_6.mentalhealthcare.utils.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);
        binding.btnLogin.setOnClickListener(view -> {
            String username = binding.edtUsername.getText().toString().trim();
            String password = binding.edtPassword.getText().toString().trim();
            boolean res = databaseHelper.checkUser(username, password);
            if (res) {
                Toast.makeText(LoginActivity.this, "Succesfully Logged In", Toast.LENGTH_SHORT).show();
                Intent contentIntent = new Intent(LoginActivity.this, ContentActivity.class);
                startActivity(contentIntent);
            } else {
                Toast.makeText(LoginActivity.this,"Username atau Password Anda Salah", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnRegister.setOnClickListener(view -> {
            Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(registerIntent);
        });
    }
}