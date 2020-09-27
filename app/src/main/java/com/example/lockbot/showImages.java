package com.example.lockbot;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class showImages extends AppCompatActivity {

    private DBChana objectDatabaseHandler;
    private RecyclerView objectRecyclerview;
    private RVAdapter objectRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_images);

        try {
            objectRecyclerview = findViewById(R.id.imagesRV);
            objectDatabaseHandler = new DBChana(this);
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void getData(View view){
        try {
            objectRVAdapter = new RVAdapter(objectDatabaseHandler.getImagesData());
            objectRecyclerview.setHasFixedSize(true);

            objectRecyclerview.setLayoutManager(new LinearLayoutManager(this));
            objectRecyclerview.setAdapter(objectRVAdapter);

        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}
