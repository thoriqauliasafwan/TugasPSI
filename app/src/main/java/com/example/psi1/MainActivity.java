package com.example.psi1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editNama,editAlamat;
    Button btnSimpan;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNama= findViewById(R.id.nama);
        editAlamat = findViewById(R.id.alamat);
        btnSimpan = findViewById(R.id.simpanbtn);
    }

    public void Resetdata(View view) {
        editNama.setText("");
        editAlamat.setText("");
    }
}