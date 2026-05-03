package com.example.proll;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Pr5 extends AppCompatActivity {
    TextView text;
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (text != null) {
            outState.putString("saved_text", text.getText().toString());
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
       String state = savedInstanceState.getString("KEY_STATE");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pr5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (savedInstanceState != null) {
            String state = savedInstanceState.getString("KEY_STATE");
            text = findViewById(R.id.textView8);
            text.setText(state);
        }
    }

    public void Save(View view){
        EditText namefile = findViewById(R.id.namefile);
        EditText content = findViewById(R.id.content);
        String filename = String.valueOf(namefile.getText()); //Название файла
        String fileContents = String.valueOf(content.getText()); //Текст внутри файла
//Открываем поток для записи. Если документ не создан, то он будетсоздан автоматически
        try (FileOutputStream fos = openFileOutput(filename,
                Context.MODE_PRIVATE)) {
//Записываем текст в файл, переведя его в массив байт
            fos.write(fileContents.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void dobavit(View view){
        EditText namefile = findViewById(R.id.namefile);
        EditText content = findViewById(R.id.content);
        String filename = String.valueOf(namefile.getText()); //Название файла
        String fileContents = String.valueOf(content.getText()); //Текст внутри файла
//Открываем поток для записи. Если документ не создан, то он будетсоздан автоматически
        try (FileOutputStream fos = openFileOutput(filename,
                Context.MODE_APPEND)) {
//Записываем текст в файл, переведя его в массив байт
            fos.write(fileContents.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Write (View view){
        text = findViewById(R.id.textView8);
        EditText namefile = findViewById(R.id.namefile);
        String filename = String.valueOf(namefile.getText()); //Название файла
        try (FileInputStream fis = openFileInput(filename)) {
            InputStreamReader inputStreamReader = new
                    InputStreamReader(fis, StandardCharsets.UTF_8);
            StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader reader = new
                    BufferedReader(inputStreamReader)) {
                String line = reader.readLine();
                while (line != null) {
                    stringBuilder.append(line).append('\n');
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            String content = stringBuilder.toString();
            text.setText(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Remove(View view){
        // Указываем имя файла, который хотим удалить
        EditText namefile = findViewById(R.id.namefile);
        String filename = String.valueOf(namefile.getText());
        AlertDialog.Builder builder = new AlertDialog.Builder(Pr5.this);
        builder.setTitle("Подтверждение");
        builder.setMessage("Вы уверены, что хотите удалить этот файл");
        builder.setPositiveButton("Да", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        File dir = getFilesDir();
                        File file = new File(dir, filename);
                        boolean deleted = file.delete();
                    }

                });
// Установка кнопки "Отмена" и ее обработчика
        builder.setNegativeButton("Отмена", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Обработка отмены действия
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
// Получаем файловый объект для файла из внутреннего хранилища
    }

    public void Pr52(View view) {
        Intent newact = new Intent(this, Pr522.class);
        startActivity(newact);
    }
}