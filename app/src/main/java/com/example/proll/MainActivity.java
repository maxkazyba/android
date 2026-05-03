package com.example.proll;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proll.objects.User;

import java.net.DatagramPacket;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("logcreate", "onCreate: eeee");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        User user = (User) getIntent().getSerializableExtra("user");
        if (user != null) {
            TextView login = findViewById(R.id.login);
            TextView password = findViewById(R.id.password);
            login.setText(user.getLogin());
            password.setText(user.getPassword());
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("logstart", "onStart: eeee");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("logresum", "onResume: eeee");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("logpause", "onPause: eeee");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("logstop", "onStop: eeee");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("logdestr", "onDestroy: eeee");
    }

    public void onMainscreen(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Подтверждение");
        builder.setMessage("Вы уверены, что ввели все правильно");
        builder.setPositiveButton("Да", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Onms();
                        // Обработка подтверждения
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
    }

    private void Onms() {
        EditText logint = findViewById(R.id.login);
        EditText passw = findViewById(R.id.password);
        String login = logint.getText().toString();
        String password = passw.getText().toString();

        if (login.equals("") || password.equals("")) {
            Toast.makeText(getApplicationContext(), "Вы ввели не все данные",
                    Toast.LENGTH_SHORT).show();
        } else {
            User user = new User(login, password);
            Intent newact = new Intent(this, Mainscreen.class);
            newact.putExtra("user", user);
            startActivity(newact);
        }
    }

    public void onLogin(View view) {
        Intent newact = new Intent(this, Login.class);
        startActivity(newact);
    }

    public void onPrac3(View view) {
        Intent newact = new Intent(this, Practica3.class);
        startActivity(newact);
    }

    public void Mainset(View view) {
        Intent newact = new Intent(this, Main_setting.class);
        startActivity(newact);
    }

    public void onPrac4(View view) {
        Intent newact = new Intent(this, Practica4.class);
        startActivity(newact);
    }

    public void onPr5(View view) {
        Intent newact = new Intent(this, Pr5.class);
        startActivity(newact);
    }
}