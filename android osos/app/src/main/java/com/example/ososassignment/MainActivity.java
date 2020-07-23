package com.example.ososassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements dialog.dialogListerner {

    private Button button;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.addButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openDialogue();
            }
        });
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize((true));
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        listItems=new ArrayList<>();
        adapter=new MyAdapter(listItems,this);
        recyclerView.setAdapter(adapter);

    }
    public void openDialogue(){
        dialog d=new dialog();
        d.show(getSupportFragmentManager(),"dialog");
    }
    @Override
    public  void applyTexts(String name,String age,String roll)
    {
        ListItem listItem=new ListItem("Name:"+name,"Age:"+ age,"Roll No:"+ roll);
        listItems.add(listItem);
    }
}
