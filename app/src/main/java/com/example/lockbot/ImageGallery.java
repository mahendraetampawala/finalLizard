package com.example.lockbot;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ImageGallery extends AppCompatActivity implements View.OnClickListener{

    private Toolbar toolbarX;
    private CardView c1, c2, c3, c4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.nav_imagegal);

        c1 = findViewById(R.id.galleryCard_1);
        c2 = findViewById(R.id.galleryCard_2);
        c3 = findViewById(R.id.galleryCard_3);
        c4 = findViewById(R.id.galleryCard_4);

        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);


        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.nav_home){
                    startActivity(new Intent(ImageGallery.this,resourceManager.class));
                }
                if (item.getItemId()==R.id.nav_gallery){
                    startActivity(new Intent(ImageGallery.this,homechana.class));
                }
                DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }
    /*
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu,menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if(requestCode == 1 && resultCode == RESULT_OK){
                final ImageView imageView = findViewById(R.id.imageView);
                final List<Bitmap> bitmaps = new ArrayList<>();
                ClipData clipData = data.getClipData();

                if(clipData != null){
                    for(int i=0; i < clipData.getItemCount() ;i++){
                        Uri imageUri = clipData.getItemAt(i).getUri();
                        try {
                            InputStream is = getContentResolver().openInputStream(imageUri);

                            Bitmap bitmap = BitmapFactory.decodeStream(is);

                            bitmaps.add(bitmap);

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }else{
                    Uri imageUri = data.getData();
                    try {
                        InputStream is = getContentResolver().openInputStream(imageUri);

                        Bitmap bitmap = BitmapFactory.decodeStream(is);

                        bitmaps.add(bitmap);
                    }catch (FileNotFoundException e){
                        e.printStackTrace();
                    }
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(final Bitmap b : bitmaps){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    imageView.setImageBitmap(b);
                                }
                            });
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }).start();

            }

        }
    */
    @Override
    public void onClick(View view) {
        Intent xi;

        switch (view.getId()){
 /*  */          case R.id.galleryCard_1:
               xi = new Intent(this, MainActivityX1.class);
                startActivity(xi);
              break;

            case R.id.galleryCard_2:
              xi = new Intent(this, RecordListActivityX1.class);
                startActivity(xi);
                break;

            case R.id.galleryCard_4:
                xi=new Intent(this,RecyclerViewClickInterface.class);
                startActivity(xi);
                break;
       /*  */


    }//onclick

    }//oncreate

}//class
