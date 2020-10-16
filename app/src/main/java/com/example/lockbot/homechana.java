package com.example.lockbot;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class homechana extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbarX;
    private CardView card1, card2, card3, card4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.nav_homechana);

        toolbarX = findViewById(R.id.toolbarX);
        setSupportActionBar(toolbarX);

        card1 = (CardView) findViewById(R.id.card1);
        card2 = (CardView) findViewById(R.id.card2);
        card3 = (CardView) findViewById(R.id.card3);
        card4 = (CardView) findViewById(R.id.card4);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);

        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               if (item.getItemId()==R.id.nav_home){
                   startActivity(new Intent(homechana.this,resourceManager.class));
               }
               if (item.getItemId()==R.id.nav_gallery){
                   startActivity(new Intent(homechana.this,homechana.class));
               }
                DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
               drawerLayout.closeDrawer(GravityCompat.START);
               return true;
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.card1:
                i = new Intent(this, ImageGallery.class);
                startActivity(i);
                break;
            case R.id.card2:
                i = new Intent(this, AudioSelect.class);
                startActivity(i);
                break;

        }

    }
    @Override
    public void onBackPressed(){

    }
}
