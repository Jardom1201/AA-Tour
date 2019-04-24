package com.example.aatour;


import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class HomePage extends AppCompatActivity {

    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        //ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        //viewPager.setAdapter(viewPagerAdapter);

        Button gambar1 = findViewById(R.id.gambar1);

        gambar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, gambartour.class);
                startActivity(i);



            }
        });
        Button map1 = findViewById(R.id.map1);

        map1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, map.class);
                startActivity(i);



            }
        });
        Button makan1 = findViewById(R.id.makan1);

        makan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, tempatmakan.class);
                startActivity(i);



            }
        });
        Button lokasi1 = findViewById(R.id.lokasi1);

        lokasi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, lokasi.class);
                startActivity(i);



            }
        });
        Button chat1 = findViewById(R.id.chat1);

        chat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, lokasi.class);
                startActivity(i);



            }
        });
        Button home1 = findViewById(R.id.home1);

        home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, home2.class);
                startActivity(i);



            }
        });
    }
        }

