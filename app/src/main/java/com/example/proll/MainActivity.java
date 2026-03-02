package com.example.proll;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("logcreate", "onCreate: eeee");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button button2 = findViewById(R.id.button2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected  void onStart(){
        super.onStart();
        Log.i("logstart", "onStart: eeee");
    }
    @Override
    protected  void onResume(){
        super.onResume();
        Log.i("logresum", "onResume: eeee");
    }    @Override
    protected  void onPause(){
        super.onPause();
        Log.i("logpause", "onPause: eeee");
    }    @Override
    protected  void onStop(){
        super.onStop();
        Log.i("logstop", "onStop: eeee");
    }
    @Override
    protected  void onDestroy(){
        super.onDestroy();
        Log.i("logdestr", "onDestroy: eeee");
    }
    public void onNextActivity(View view) {
        Intent newact = new Intent(this, MainActivity2.class);

        EditText namet = findViewById(R.id.name);
        EditText aget = findViewById(R.id.age);
        EditText groupt = findViewById(R.id.group);

        String name = namet.getText().toString();
        int age = Integer.parseInt(aget.getText().toString());
        String group = groupt.getText().toString();


        newact.putExtra("name", name);
        newact.putExtra("age", age);
        newact.putExtra("group", group);

        startActivity(newact);

        Toast.makeText(getApplicationContext(), "Perehodim v new activnost",
                Toast.LENGTH_SHORT).show();
    }

}