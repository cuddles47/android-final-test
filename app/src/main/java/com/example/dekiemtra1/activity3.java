package com.example.dekiemtra1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activity3 extends AppCompatActivity{
    private ListView mListView;
    private Button mButton;
    private String[] diachi = {"Linh nam","Minh Khai","Nam Dinh","My Xa"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        mListView = findViewById(R.id.listView);
        mButton = findViewById(R.id.bt_next3);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, diachi);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String chon = diachi[i];
                Toast.makeText(activity3.this, "Chon: "+chon, Toast.LENGTH_SHORT).show();
            }
        });
        mButton.setOnClickListener(view -> {
            Intent intent = new Intent(activity3.this,activity4.class);
            startActivity(intent);
        });
    }
}
