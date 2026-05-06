package com.example.proll;

import android.animation.ObjectAnimator;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proll.objects.User;
import com.google.gson.Gson;

import java.io.FileOutputStream;
import java.io.IOException;

public class Pr62 extends AppCompatActivity {
    private static final String CHANNEL_ID = "example_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pr62);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        createNotificationChannel();

        ImageView imageView = findViewById(R.id.babushk);
        ObjectAnimator rotateAnim =
                ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
        rotateAnim.setDuration(6000);
        rotateAnim.setRepeatCount(ObjectAnimator.INFINITE);
        rotateAnim.setRepeatMode(ObjectAnimator.RESTART);
        rotateAnim.start();

        final Button moveButton =
                findViewById(R.id.moveButton);
        moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator moveAnim =
                        ObjectAnimator.ofFloat(moveButton, "translationX", 0f, 300f);
                moveAnim.setDuration(1000);
                moveAnim.setRepeatCount(ObjectAnimator.INFINITE);
                moveAnim.setRepeatMode(ObjectAnimator.RESTART);
                moveAnim.start();
            }
        });

        TextView scaleText =
                findViewById(R.id.scaleTextView);
        scaleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(scaleText, "scaleX", 1f, 2f);
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(scaleText, "scaleY", 1f, 2f);
                scaleX.setDuration(1000);
                scaleX.setRepeatCount(ObjectAnimator.INFINITE);
                scaleX.setRepeatMode(ObjectAnimator.RESTART);
                scaleY.setDuration(1000);
                scaleY.setRepeatCount(ObjectAnimator.INFINITE);
                scaleY.setRepeatMode(ObjectAnimator.RESTART);
                scaleX.start();
                scaleY.start();
            }
        });

        final Button notifyButton =
                findViewById(R.id.notifyButton);
        notifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new
                        NotificationCompat.Builder(Pr62.this, CHANNEL_ID).setSmallIcon(R.drawable.ic_launcher_foreground).setContentTitle("BABUSHKI").setContentText("Zdes krutyatsa babushki")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                notificationManager.notify(1, builder.build());
            }
        });
    }
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            CharSequence name = "Example Channel";
            String description = "Channel for example notifications";
            int importance =
                    NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new
                    NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager =
                    getSystemService(NotificationManager.class);

            notificationManager.createNotificationChannel(channel);
        }
    }

    public void parseJsonUsingGson() {
        String jsonStr = "{\"login\":\"John\", \"password\":30\"}";
        Gson gson = new Gson();

        User user = gson.fromJson(jsonStr, User.class);

        System.out.println("login: " + user.getLogin());
        System.out.println("password: " + user.getPassword());
        file(jsonStr);
    }

    public void file(String jsonString){
        String filename = "json file";
//Открываем поток для записи. Если документ не создан, то он будетсоздан автоматически
        try (FileOutputStream fos = openFileOutput(filename,
                Context.MODE_PRIVATE)) {
//Записываем текст в файл, переведя его в массив байт
            fos.write(jsonString.getBytes());
        } catch (IOException e) {
        }
    }
}