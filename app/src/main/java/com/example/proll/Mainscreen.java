package com.example.proll;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proll.objects.User;

public class Mainscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mainscreen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       ImageView avatar = findViewById(R.id.avatar);
        avatar.setClipToOutline(true);

        ImageView friend = findViewById(R.id.friend);
        friend.setClipToOutline(true);

        ImageView winr = findViewById(R.id.winr);
        winr.setClipToOutline(true);

        ImageView game = findViewById(R.id.game);
        game.setClipToOutline(true);

        User user = (User) getIntent().getSerializableExtra("user");
        TextView login = findViewById(R.id.login);
        login.setText(user.getLogin());
    }

    public void OnFrafActiv(View view){
        Intent newact = new Intent(this, fragmentActivity.class);
        startActivity(newact);
    }

    public void ChooseRoom(View view){
        Intent newact = new Intent(this, Choose_room.class);
        startActivity(newact);
    }
}