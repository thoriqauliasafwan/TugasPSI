package com.example.psi1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText editUsername,editPassword;
    Button btnSubmit;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences = Login.this.getSharedPreferences("username", Context.MODE_PRIVATE);
        String dataShared = sharedPreferences.getString("uname", "");
        Log.e("Cek data Sharedpref",dataShared);
        if(dataShared.isEmpty()) {
            Toast.makeText(Login.this, "Silahkan Login Terlebih Dahulu", Toast.LENGTH_LONG).show();

        }else {
            startActivity(new Intent(Login.this, MainActivity.class));
            finish();
        }
        editUsername = findViewById(R.id.username);
        editPassword = findViewById(R.id.password);
        btnSubmit = findViewById(R.id.submitbtn);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String uname = editUsername.getText().toString();
               String password = editPassword.getText().toString();
               if(uname.equals("admin")&&password.equals("admin")){
                   SharedPreferences.Editor edit = sharedPreferences.edit();
                   edit.putString("uname",uname);
                   edit.apply();
                   startActivity(new Intent(Login.this,MainActivity.class));
                   finish();
               }
            }
        });
    }

    public void ResetData(View view) {
        editUsername.setText("");
        editPassword.setText("");
    }

    public void Register(View view) {
        startActivity(new Intent(Login.this,SignUP.class));
        finish();
    }
}