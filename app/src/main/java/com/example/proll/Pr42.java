package com.example.proll;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

public class Pr42 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pr42);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnLoad = findViewById(R.id.btnLoad); // Добавь кнопку в XML
        ImageView imageView = findViewById(R.id.imageView); // Добавь ImageView в XML

        btnLoad.setOnClickListener(v -> {
            OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(ImageDownloadWorker.class).build();
            WorkManager.getInstance(this).enqueue(request);

            // Слушаем результат
            WorkManager.getInstance(this).getWorkInfoByIdLiveData(request.getId())
                    .observe(this, workInfo -> {
                        if (workInfo != null && workInfo.getState() == WorkInfo.State.SUCCEEDED) {
                            // Используем Glide для загрузки картинки по URL
                            String url = workInfo.getOutputData().getString("img_url");

                            Glide.with(Pr42.this)
                                    .load(url)
                                    .skipMemoryCache(true) // Не брать из памяти старое
                                    .diskCacheStrategy(DiskCacheStrategy.NONE) // Не брать из памяти диска
                                    .placeholder(android.R.drawable.progress_horizontal) // Покажет полоску загрузки
                                    .error(android.R.drawable.stat_notify_error) // Покажет иконку ошибки, если сеть подведет
                                    .into(imageView);
                        }
                    });
        });
    }
}