package com.mebk.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }
    public void game (View view) {

        Intent intent = new Intent(MainActivity2.this,GameScreen.class);
        startActivity(intent);

    }
    public void game2 (View view) {

        Intent intent = new Intent(MainActivity2.this,GameScreen2.class);
        startActivity(intent);

    }  public void game3 (View view) {

        Intent intent = new Intent(MainActivity2.this,GameScreen3.class);
        startActivity(intent);

    }  public void game4 (View view) {

        Intent intent = new Intent(MainActivity2.this,GameScreen4.class);
        startActivity(intent);

    }  public void game5 (View view) {

        Intent intent = new Intent(MainActivity2.this,GameScreen5.class);
        startActivity(intent);

    }  public void game6 (View view) {

        Intent intent = new Intent(MainActivity2.this,GameScreen6.class);
        startActivity(intent);

    }  public void game7 (View view) {

        Intent intent = new Intent(MainActivity2.this,GameScreen7.class);
        startActivity(intent);


}}