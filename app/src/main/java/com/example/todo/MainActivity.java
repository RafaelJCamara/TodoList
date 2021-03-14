package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listToDo;
    private ArrayList<String> toDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init main list
        toDo = new ArrayList<String>();

        //LIST OPERATIONS
        listOperations();

        //TO DO SUBMISSION OPERATIONS
        todoSubmissions();
    }

    private void listOperations(){
        //get list view
        listToDo = findViewById(R.id.listToDo);

        //create list adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                //context
                getApplicationContext(),
                //layout to be applied on
                android.R.layout.simple_list_item_1,
                //id inside layout
                android.R.id.text1,
                //data
                toDo
        );

        //add adapter to list
        listToDo.setAdapter(adapter);

        //add actionlisterner to each item of the list
        listToDo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemSelected = listToDo.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),itemSelected,Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void todoSubmissions(){
        //get the button
        Button submit = findViewById(R.id.submitToDo);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the text content
                EditText todo = (EditText) findViewById(R.id.toDoTask);
                toDo.add(todo.getText().toString());
                listOperations();
            }
        });
    }

}