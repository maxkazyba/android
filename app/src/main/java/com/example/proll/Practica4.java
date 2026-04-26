package com.example.proll;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Practica4 extends AppCompatActivity {

    private int hour;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practica4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Play(View view){
        Intent startIntent = new Intent(this, MyService.class);
        startService(startIntent);
    }

    public void Stop(View view){
        Intent startIntent = new Intent(this, MyService.class);
        stopService(startIntent);
    }

    public void Time(View view){
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int
                            hourOfDay, int minute) {
                        // Обработка выбранного времени
                        // Пример: установка времени в TextView
// textView.setText(hourOfDay + ":" +minute);
                    }
                }, hour, minute, true);
        timePickerDialog.show();
    }

    public  void Cust(View view){
        String stroka;
        Dialog dialog = new Dialog(Practica4.this);
// Установка макета для диалогового окна
        dialog.setContentView(R.layout.cus_dil);
// Настройка элементов в макете
        EditText logint = findViewById(R.id.textInputEditText);
        TextView login = dialog.findViewById(R.id.textView7);
        stroka = "Вы ввели это: "+logint.getText();
        login.setText(stroka);
        Button button = dialog.findViewById(R.id.button12);
        Button button2 = dialog.findViewById(R.id.button13);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Обработка нажатия на кнопку
            }
        });
// Отображение диалогового окна
        dialog.show();
    }

    public void pr42(View view) {
        Intent newact = new Intent(this, Pr42.class);
        startActivity(newact);
    }
}