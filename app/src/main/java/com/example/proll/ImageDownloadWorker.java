package com.example.proll;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class ImageDownloadWorker extends Worker {
    public ImageDownloadWorker(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        try {

            String finalImageUrl = "https://random.dog/20549-24554-21155.jpg";

            Data outputData = new Data.Builder()
                    .putString("img_url", finalImageUrl)
                    .build();

            return Result.success(outputData);
        } catch (Exception e) {
            return Result.failure();
        }
    }
}

