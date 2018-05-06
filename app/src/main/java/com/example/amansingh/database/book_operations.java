package com.example.amansingh.database;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amansingh.database.Database.DBhelper;
import com.example.amansingh.database.utils.Constants;

import java.sql.BatchUpdateException;

public class book_operations extends AppCompatActivity {

EditText bookname , authorname;
Button update , delete;
DBhelper dBhelper;
Intent i;
String book_name,author_name;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_operations);
        dBhelper = DBhelper.getinstance(this);


    }
}
