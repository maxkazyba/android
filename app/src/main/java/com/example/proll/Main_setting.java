package com.example.proll;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main_setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_setting);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Главная");
        }



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottombar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.profil){
                    // Обработка выбора раздела "Домой"
                    Toast.makeText( Main_setting.this,"Настройки профиля",
                            Toast.LENGTH_LONG).show();
                    return true;
                }
                else if (item.getItemId()==R.id.educ){
                    // Обработка выбора раздела "Настройки"
                    Toast.makeText(Main_setting.this,"Обучение",
                            Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });
    }

    public void Return (View view){
        Intent intent = new Intent(Main_setting.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        getMenuInflater().inflate(R.menu.bottom_nav_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( @NonNull MenuItem item ) {
        //Определение нажатого элемента
        if (item.getItemId() == R.id.profil) {
            // Обработка выбора раздела "Домой"
            Toast.makeText(Main_setting.this, "Домой", Toast.LENGTH_LONG).show();
            return true;
        } else if (item.getItemId() == R.id.educ) {
            // Обработка выбора раздела "Настройки"
            Toast.makeText(Main_setting.this, "Настройки", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}