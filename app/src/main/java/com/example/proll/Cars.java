package com.example.proll;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cars extends AppCompatActivity {
    String[] kategories = {"Игры", "Языки программирования", "Машинки"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cars);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent games = new Intent(Cars.this, Games.class);
        Intent proglang = new Intent(Cars.this, Proglang.class);
        Intent cars = new Intent(Cars.this, Cars.class);
        ListView kategorii = (ListView) findViewById(R.id.kategory);
        ArrayAdapter<String> kategAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, kategories);
        kategorii.setAdapter(kategAdapter);
        kategorii.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // по позиции получаем выбранный элемент
                String selectedItem = kategories[position];
                if (selectedItem.equals("Игры")){
                    startActivity(games);
                }
                if (selectedItem.equals("Языки программирования")){
                    startActivity(proglang);
                }
                if (selectedItem.equals("Машинки")){
                    startActivity(cars);
                }
            }
        });
    }
}