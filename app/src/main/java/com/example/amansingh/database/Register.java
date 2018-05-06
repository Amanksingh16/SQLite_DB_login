package com.example.amansingh.database;

import android.content.ContentValues;
import android.content.Intent;
import android.os.health.PackageHealthStats;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amansingh.database.Database.DBhelper;
import com.example.amansingh.database.Model.BookData;
import com.example.amansingh.database.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity {

    EditText username , password , phone;
    Button register;
    DBhelper dBhelper;
    List<BookData> content ;
    int status = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        phone = (EditText)findViewById(R.id.phone);
        register = (Button)findViewById(R.id.Register);
        dBhelper = DBhelper.getinstance(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                 insert();
            }
        });
    }
    private void insert() {
        content = dBhelper.getfullcontent("");
        List<String> usernames = new ArrayList<String>();
        for (int i = 0; i < content.size(); i++) {
            usernames.add(content.get(i).getUsername());
        }
        for(int i=0;i<content.size();i++)
        {
            status = 1;
            if (usernames.get(i).equals(username.getText().toString()))
            {
                Toast.makeText(Register.this, "Username already taken", Toast.LENGTH_SHORT).show();
                status = 0;
                break;
            }
        }
        if(status == 1)
        {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Constants.USER_NAME, username.getText().toString());
            contentValues.put(Constants.PASSWORD, password.getText().toString());
            contentValues.put(Constants.PHONE, phone.getText().toString());
            dBhelper.insertContentvalues(Constants.Table_name, contentValues);
            Toast.makeText(Register.this, "Thanks for Registration", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Register.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
