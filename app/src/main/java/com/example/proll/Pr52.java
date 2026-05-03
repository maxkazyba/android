package com.example.proll;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Map;

public class Pr52 extends AppCompatActivity {
    TextView text;
    TextView textt;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pr52);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        sharedPreferences = getSharedPreferences("myPreferences", MODE_PRIVATE);
        editor = sharedPreferences.edit();
// Сохранение строкового значения
        editor.putString("username", "User123");
        editor.putInt("sessionCount", 5);
        editor.putBoolean("loggedIn", true);
// Сохранение изменений
        editor.apply();
    }

    public void getname (View view){
        sharedPreferences = getSharedPreferences("myPreferences", MODE_PRIVATE);
        text = findViewById(R.id.textView9);
        String username = sharedPreferences.getString("username",
                "defaultUsername");
        Map<String, ?> allEntries = sharedPreferences.getAll();

        // 2. Создаем "строитель" строк
        StringBuilder builder = new StringBuilder();

        // 3. Перебираем Map и склеиваем в текст
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            builder.append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue().toString())
                    .append("\n");
        }

        text.setText(builder.toString());
    }

    public void removename(View view){
        editor = sharedPreferences.edit();
// Удаление данных по ключу
        editor.remove("username");
// Применение изменений
        editor.apply();
    }

    public void changename (View view){
        sharedPreferences = getSharedPreferences("myPreferences", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        EditText name = findViewById(R.id.newname);
        editor.putString("username", name.getText().toString());
        editor.apply();
    }

    public void Pr522(View view) {
        Intent newact = new Intent(this, Pr522.class);
        startActivity(newact);
    }
}