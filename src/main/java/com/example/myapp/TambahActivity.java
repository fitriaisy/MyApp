package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapp.R;
import com.example.myapp.database.AppDatabase;

public class TambahActivity extends AppCompatActivity {

    private EditText editNama, editNohp;
    private Button btn_simpan;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        editNama = findViewById(R.id.Full_name);
        editNohp = findViewById(R.id.nohp);
        btn_simpan = findViewById(R.id.btn_simpan);

        database = AppDatabase.getInstance(getApplicationContext());

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.kontakDao().inserAll(editNama.getText().toString(), editNohp.getText().toString());
                finish();
            }
        });
    }
}