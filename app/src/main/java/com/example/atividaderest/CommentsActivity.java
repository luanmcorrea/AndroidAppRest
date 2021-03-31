package com.example.atividaderest;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.DiskWriteViolation;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.example.atividaderest.model.Comment;

public class CommentsActivity extends AppCompatActivity
        implements Response.Listener<JSONArray>,
        Response.ErrorListener{

    List<Comment> comments =  new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        //TextView tv = (TextView) findViewById(R.id.textoSegunda);
        Intent it = getIntent();
        String txt = it.getStringExtra("nome");
        Pessoa pes = it.getParcelableExtra("objPessoa");
        //tv.setText(pes.getNome()+" ("+pes.getId()+")");
        //tv.setText(txt);
        //Toast.makeText(this,"olá "+txt,Toast.LENGTH_LONG).show();
// Volley
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/comments";

        // Request de JsonArray da URL.

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                this, this);


        // Add the request to the RequestQueue.
        queue.add(jsonArrayRequest);
        Toast.makeText(this,"qtd:"+comments.size(),Toast.LENGTH_LONG).show();


    }
    // Volley
    @Override
    public void onResponse(JSONArray response) {
        try {
            for(int i = 0; i < response.length(); i++) {
                JSONObject json = response.getJSONObject(i);
                Comment obj = new Comment(json.getInt("postId"),
                        json.getInt("id"),
                        json.getString("name"),
                        json.getString("email"),
                        json.getString("body"));
                comments.add(obj);

            }
            Toast.makeText(this,"qtd:"+comments.size(),Toast.LENGTH_LONG).show();
            LinearLayout ll = findViewById(R.id.layoutVerticalItens);
            for(Comment obj1 : comments) {
                Button bt = new Button(this);
                bt.setText(obj1.getName());
                bt.setTag(obj1);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button btn = (Button) v;
                        Comment comment = (Comment) btn.getTag();
                        Intent intent = new Intent(getApplicationContext(), DetalheCommentActivity.class);

                        // adicional para incluir dados para a proxima activity
                        intent.putExtra("objComment", comment);
                        // lança intent para o SO chamar a activity
                        startActivity(intent);
                        //Toast.makeText(v.getContext(),comment.getId()+" - "+comment.getTitle(),Toast.LENGTH_LONG).show();
                    }
                });
                ll.addView(bt);
            }


        } catch (JSONException e) {
            Log.e("erro",e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        String msg = error.getMessage();
        Toast.makeText(this.getApplicationContext(),"ERRO >> >> "+msg,Toast.LENGTH_LONG).show();
    }

}