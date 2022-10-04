package com.example.roomdatabase_recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_a, new FragmentOne())
                .add(R.id.container_b, new FragmentTwo())
                .commit();
    }
}