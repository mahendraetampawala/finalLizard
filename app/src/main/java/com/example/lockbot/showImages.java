package com.example.lockbot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class showImages extends AppCompatActivity implements RecyclerViewClickInterface{

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
            objectRVAdapter = new RVAdapter(objectDatabaseHandler.getImagesData(),this);
            objectRecyclerview.setHasFixedSize(true);

            objectRecyclerview.setLayoutManager(new LinearLayoutManager(this));
            objectRecyclerview.setAdapter(objectRVAdapter);

        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "Long Press to delete selected item...", Toast.LENGTH_SHORT).show();




    }

    @Override
    public void onLongItemClick(int position) {
        //   objectRVAdapter.remove(position);
    }
}
