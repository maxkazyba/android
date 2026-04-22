package com.example.proll;

import android.media.Image;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recyclerview3pr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recyclerview);

        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<MyItem> items = new ArrayList<>();
        items.add(new MyItem("один",R.drawable.ic_launcher_background));
        items.add(new MyItem("два"));
        items.add(new MyItem("три"));
        SimpleAdapter adapter = new SimpleAdapter(items);
        recyclerView.setAdapter(adapter);

    }
}

