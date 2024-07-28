package com.example.dekiemtra1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class activity4 extends AppCompatActivity {
    private Button bt_hienthi;
    private ListView listView;
    private ArrayList<String> dslist;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        bt_hienthi = findViewById(R.id.bt_hienthi);
        listView = findViewById(R.id.listStudent);
        dslist = new ArrayList<>();

        bt_hienthi.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                loadStudent();
                ArrayAdapter<String> adapter = new ArrayAdapter<>(activity4.this, android.R.layout.simple_list_item_1, dslist);
                listView.setAdapter(adapter);
                listView.setVisibility(View.VISIBLE);
            }
        });
    }
    private void loadStudent(){
        InputStream inputStream = getResources().openRawResource(R.raw.student);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder jsonString = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
            JSONArray jsonArray = new JSONArray(jsonString.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                double gpa = jsonObject.getDouble("gpa");
                dslist.add("Tên: " + name + ", GPA: " + gpa);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    };
}
