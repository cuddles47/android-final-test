package com.example.dekiemtra1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button bt_exit;
    private Button bt_login;
    private EditText edt_login;
    private EditText edt_pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.baithi1);

        bt_exit = findViewById(R.id.bt_exit);
        bt_login = findViewById(R.id.bt_login);
        edt_login = findViewById(R.id.edt_user);
        edt_pass = findViewById(R.id.edt_pass);

        bt_exit.setOnClickListener(v -> finish()); //bam exxit se tat ct
        bt_login.setOnClickListener(v -> {
            String user = edt_login.getText().toString();
            String pass = edt_pass.getText().toString();

            if (user.equals("cnttk14hn") && pass.equals("cnttk14")) {
                // Success
                // TODO: Navigate to the main activity
                Intent intent = new Intent(MainActivity.this, activity2.class);
                startActivity(intent);
            } else {
                // Error
                // TODO: Show an error message
                Toast.makeText(MainActivity.this, "Tài khoản hoặc mật khẩu không đúng",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}