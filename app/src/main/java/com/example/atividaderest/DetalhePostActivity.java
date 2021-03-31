package com.example.atividaderest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.atividaderest.model.Post;

public class DetalhePostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_post);
        Intent intent = getIntent();
        Parcelable prc = intent.getParcelableExtra("objPost");
        if (prc instanceof Post) {

        }
        if (prc instanceof Pessoa) {

        }
        Post post = intent.getParcelableExtra("objPost");
        bind(post);

    }
    public void trocaLayout(View v) {
        setContentView(R.layout.activity_detalhe_post);
        Intent intent = getIntent();
        Post post = intent.getParcelableExtra("objPost");
        bind(post);

    }
    private void bind(Post obj) {
        TextView tv = findViewById(R.id.tvId);
        tv.setText(obj.getId()+"");
        tv = findViewById(R.id.tvIdUser);
        tv.setText(obj.getUserId()+"");
        tv = findViewById(R.id.tvTitle);
        tv.setText(obj.getTitle());
        tv = findViewById(R.id.tvBody);
        tv.setText(obj.getBody());
    }
}
