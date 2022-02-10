package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText n1 = findViewById(R.id.n1);
        EditText n2 = findViewById(R.id.n2);
        Button b = findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer number1 = Integer.parseInt(n1.getText().toString());
                Integer number2 = Integer.parseInt(n2.getText().toString());
                String res = String.valueOf(number1+number2);
                Intent it = new Intent(getApplicationContext(),MainActivity2.class);
                it.putExtra("res",res);
                startActivity(it);
            }
        });
    }
}