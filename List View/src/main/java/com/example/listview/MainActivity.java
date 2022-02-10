package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = findViewById(R.id.list);
        String[] countries = getResources().getStringArray(R.array.countries);

        ArrayAdapter<String> adp = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,countries);
        list.setAdapter(adp);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> value, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You Clicked "+value.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}