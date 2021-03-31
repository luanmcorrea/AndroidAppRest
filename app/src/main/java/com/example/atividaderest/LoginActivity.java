package com.example.atividaderest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView userId = (TextView) findViewById(R.id.userId);
                TextView passId = (TextView) findViewById(R.id.passId);
                String user = userId.getText().toString();
                String pass = passId.getText().toString();
                if(pass.equals(user)) {
                    alert("Logado com sucesso");
                    goHome(v);
                }else{
                    alert("Login ou senha incorretos");
                }
            }
        });
    }
    private void alert(String s) {
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }
    private void goHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}