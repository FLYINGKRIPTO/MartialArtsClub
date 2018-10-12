package com.example.dell.udemyapp78maclub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class AddMartialArtActivity extends AppCompatActivity {
       EditText edtName,edtPrice,edtColor;
       Button btnAddMarshalArt,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_martial_art);
       edtName = findViewById(R.id.editTextName);
       edtPrice = findViewById(R.id.editTextPrice);
       edtColor  = findViewById(R.id.editTextColor);
       btnAddMarshalArt = findViewById(R.id.btnAddMarshalArt);
       btnBack = findViewById(R.id.button_back);

    }

}
