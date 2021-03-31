package com.example.atividaderest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.atividaderest.model.Comment;

public class DetalheCommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_comment);
        Intent intent = getIntent();
        Parcelable prc = intent.getParcelableExtra("objComment");
        if (prc instanceof Comment) {

        }
        if (prc instanceof Pessoa) {

        }
        Comment comment = intent.getParcelableExtra("objComment");
        bind(comment);

    }
    public void trocaLayout(View v) {
        setContentView(R.layout.activity_detalhe_comment);
        Intent intent = getIntent();
        Comment comment = intent.getParcelableExtra("objComment");
        bind(comment);

    }
    private void bind(Comment obj) {
        TextView tv = findViewById(R.id.tvPostId);
        tv.setText(obj.getPostId()+"");
        tv = findViewById(R.id.tvIdUser);
        tv.setText(obj.getId()+"");
        tv = findViewById(R.id.tvName);
        tv.setText(obj.getName());
        tv = findViewById(R.id.tvEmail);
        tv.setText(obj.getEmail());
        tv = findViewById(R.id.tvBody);
        tv.setText(obj.getBody());
    }
}