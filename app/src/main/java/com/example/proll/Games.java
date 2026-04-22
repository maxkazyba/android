package com.example.proll;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class Games extends AppCompatActivity {
    List<String> kategories = new ArrayList<String>();
    ArrayList<String> selectedUsers = new ArrayList<String>();
    ArrayAdapter<String> kategAdapter;
    ListView kategorii;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_games);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        kategories.add("Ведьмак");
        kategories.add("GTA");
        kategories.add("Resident evil");
        kategories.add("Max Payne");
        kategories.add("Mafia");
        kategories.add("God of War");
        kategories.add("Clash Royal");

        kategorii = (ListView) findViewById(R.id.kategory);
        kategAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, kategories);
        kategorii.setAdapter(kategAdapter);
        kategorii.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String user = kategAdapter.getItem(position);
                if (kategorii.isItemChecked(position))
                    selectedUsers.add(user);
                else
                    selectedUsers.remove(user);
            }
        });
    }

    public void add(View view){
        EditText userName = findViewById(R.id.userNames);
        String user = userName.getText().toString();
        if (!user.isEmpty()){
            kategAdapter.add(user);
            userName.setText("");
            kategAdapter.notifyDataSetChanged();
        }
    }

    public void remove(View view){
        // получаем и удаляем выделенные элементы
        for(int i=0; i< selectedUsers.size();i++){
            kategAdapter.remove(selectedUsers.get(i));
        }
        // снимаем все ранее установленные отметки
        kategorii.clearChoices();
        // очищаем массив выбраных объектов
        selectedUsers.clear();
        kategAdapter.notifyDataSetChanged();
    }

}