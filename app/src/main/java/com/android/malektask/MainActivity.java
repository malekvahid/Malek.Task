package com.android.malektask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;


import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edtSearch = findViewById(R.id.edtSearch);
        Button btnSearch = findViewById(R.id.btnSearch);





        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edtSearch.getText().toString();
                Intent intent = new Intent(MainActivity.this, AsyncHttpActivity.class);
                intent.putExtra("title", title);
                startActivity(intent);


                Toast.makeText(MainActivity.this,"Pleas Wait", Toast.LENGTH_LONG).show();

                    }
                });
            }

    }

