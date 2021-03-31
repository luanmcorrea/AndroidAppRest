package com.example.atividaderest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.atividaderest.model.Album;

public class DetalheAlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_album);
        Intent intent = getIntent();
        Parcelable prc = intent.getParcelableExtra("objAlbum");
        if (prc instanceof Album) {

        }
        if (prc instanceof Pessoa) {

        }
        Album album = intent.getParcelableExtra("objAlbum");
        bind(album);

    }
    public void trocaLayout(View v) {
        setContentView(R.layout.activity_detalhe_album);
        Intent intent = getIntent();
        Album album = intent.getParcelableExtra("objAlbum");
        bind(album);

    }
    private void bind(Album obj) {
        TextView tv = findViewById(R.id.tvId);
        tv.setText(obj.getId()+"");
        tv = findViewById(R.id.tvIdUser);
        tv.setText(obj.getUserId()+"");
        tv = findViewById(R.id.tvTitle);
        tv.setText(obj.getTitle());
    }
}
