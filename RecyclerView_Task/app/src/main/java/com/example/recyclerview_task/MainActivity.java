package com.example.recyclerview_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> list_task;
    TaskAdaptor adaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_task = new ArrayList<>();
        EditText taskEDT;
        Button addBTN;
        taskEDT=findViewById(R.id.taskEDT);
        addBTN=findViewById(R.id.addBTN);
        recyclerView=findViewById(R.id.recyclerView);
        adaptor=new TaskAdaptor(this);
        adaptor.setData(list_task);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptor);
        addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(!(taskEDT.getText().toString().equals(""))){
                    String data =taskEDT.getText().toString();
                    list_task.add(data);
                    adaptor.setData(list_task);
                   recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerView.setAdapter(adaptor);
               }
            }
        });
    }
}