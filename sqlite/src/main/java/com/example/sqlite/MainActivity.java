package com.example.sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.name);
        EditText age  = findViewById(R.id.age);
        EditText contact = findViewById(R.id.contact);

        Button insert = findViewById(R.id.insert);
        Button delete = findViewById(R.id.delete);
        Button update = findViewById(R.id.update);
        Button view = findViewById(R.id.view);

        DBHelper DB = new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTxt = name.getText().toString();
                String ageTxt = age.getText().toString();
                String contactTxt = contact.getText().toString();

                boolean res =DB.insetData(nameTxt,ageTxt,contactTxt);
                if(res== false){
                    Toast.makeText(getApplicationContext(), "Insert data failed", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Data inserted successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTxt = name.getText().toString();
                String ageTxt = age.getText().toString();
                String contactTxt = contact.getText().toString();

                boolean res =DB.updateData(nameTxt,ageTxt,contactTxt);
                if(res== false){
                    Toast.makeText(getApplicationContext(), "Update data failed / the name updating not exists in database", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Data updated successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTxt = name.getText().toString();

                boolean res =DB.deleteData(nameTxt);
                if(res== false){
                    Toast.makeText(getApplicationContext(), "Delete data failed", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Data deleted successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = DB.viewData();

                if(cursor.getCount()==0){
                    Toast.makeText(getApplicationContext(), "No record exists", Toast.LENGTH_SHORT).show();
                }
                else{
                    StringBuffer buffer = new StringBuffer();
                    while(cursor.moveToNext()){
                        buffer.append("Name: "+cursor.getString(0)+"\n");
                        buffer.append("Age: "+cursor.getString(1)+"\n");
                        buffer.append("Contact: "+cursor.getString(2)+"\n");
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("User Data");
                    builder.setMessage(buffer.toString());
                    builder.show();
                }
            }
        });

    }
}