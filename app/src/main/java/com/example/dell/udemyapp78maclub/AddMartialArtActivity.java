package com.example.dell.udemyapp78maclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AddMartialArtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_martial_art);
        Toast.makeText(AddMartialArtActivity.this,"This is add martial art activity",Toast.LENGTH_SHORT).show();

    }
}