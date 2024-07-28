package com.example.dekiemtra1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class activity2 extends AppCompatActivity {

    private RadioButton rb1, rb2, rb3, rb4;
    private CheckBox cb1, cb2;
    private Button btChoose, btNext, btExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        rb1 = findViewById(R.id.rb_1);
        rb2 = findViewById(R.id.rb_2);
        rb3 = findViewById(R.id.rb_3);
        rb4 = findViewById(R.id.rb_4);
        cb1 = findViewById(R.id.checkBox);
        cb2 = findViewById(R.id.checkBox2);
        btChoose = findViewById(R.id.bt_choose);
        btExit = findViewById(R.id.bt_exit2);
        btNext = findViewById(R.id.bt_next);

        btChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String roomType = "";
                if (rb1.isChecked()) {
                    roomType = rb1.getText().toString();
                } else if (rb2.isChecked()) {
                    roomType = rb2.getText().toString();
                } else if (rb3.isChecked()) {
                    roomType = rb3.getText().toString();
                } else if (rb4.isChecked()) {
                    roomType = rb4.getText().toString();
                }

                StringBuilder services = new StringBuilder();
                if (cb1.isChecked()) {
                    services.append(cb1.getText().toString()).append("\n");
                }
                if (cb2.isChecked()) {
                    services.append(cb2.getText().toString()).append("\n");
                }

                String result = "Loại phòng ngủ: " + roomType + "\nDịch vụ:\n" + services.toString();

                new AlertDialog.Builder(activity2.this)
                        .setTitle("Thông tin đã chọn")
                        .setMessage(result)
                        .setPositiveButton("OK", null)
                        .show();
            }
        });

        btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity(); // Thoát ứng dụng
            }
        });

        btNext.setOnClickListener(v -> {
            Intent intent = new Intent(activity2.this, activity3.class);
            startActivity(intent);
        });
    }
}
