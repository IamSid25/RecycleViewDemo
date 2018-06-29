package com.iam_sid.recycleviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> androidVersions = new ArrayList<>();

        androidVersions.add("Android 1.0    1   BASE");
        androidVersions.add("Android 1.1    2   BASE_1_1");

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter =new MyRecyclerViewAdapter(this,androidVersions);
        adapter.setmClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClicked(View view, int position) {
        Toast.makeText(this, "you clicked on "+adapter.getItemId(position), Toast.LENGTH_SHORT).show();
    }
}
