package com.example.atividaderest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.atividaderest.model.Album;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button b1 = (Button) findViewById(R.id.button4);
        Button b2 = (Button) findViewById(R.id.button5);
        Button b3 = (Button) findViewById(R.id.button6);
        Button b4 = (Button) findViewById(R.id.button7);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                abreTodosActivity(v);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                abrePostsActivity(v);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                abreAlbumsActivity(v);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                abreCommentsActivity(v);
            }
        });

        Button btnGoLogin = (Button)findViewById(R.id.btnGoLogin);
        btnGoLogin.setOnClickListener(this::goLogin);

        Button btnGoSplash = (Button)findViewById(R.id.btnGoSplash);
        btnGoSplash.setOnClickListener(this::goSplash);
    }
    public void abreTodosActivity(View view) {
        Intent intent = new Intent(this,TodosActivity.class);
        startActivity(intent);
    }

    public void abrePostsActivity(View view) {
        Intent intent = new Intent(this,PostsActivity.class);
        startActivity(intent);
    }

    public void abreAlbumsActivity(View view) {
        Intent intent = new Intent(this, AlbumsActivity.class);
        startActivity(intent);
    }

    public void abreCommentsActivity(View view) {
        Intent intent = new Intent(this, CommentsActivity.class);
        startActivity(intent);
    }

    private void goLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    private void goSplash(View view) {
        Intent intent = new Intent(this, SplashScreen.class);
        startActivity(intent);
    }
}