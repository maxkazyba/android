package com.example.proll;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.proll.objects.User;

public class Mainscreen extends AppCompatActivity {

    public DrawerLayout drawer;
    public ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mainscreen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawer_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(Mainscreen.this, drawer, R.string.login,R.string.login);
        if (drawer != null) {
            drawer.addDrawerListener(toggle);
        }
        toggle.syncState();
// to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
        if (login != null){
            login.setText(user.getLogin());
        }
    }

    public void OnFrafActiv(View view){
        Intent newact = new Intent(this, fragmentActivity.class);
        startActivity(newact);
    }

    public void ChooseRoom(View view){
        Intent newact = new Intent(this, Choose_room.class);
        startActivity(newact);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}