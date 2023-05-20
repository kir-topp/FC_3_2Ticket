package com.example.fc_3_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText userIdEditText;
    private EditText departureEditText;
    private EditText arrivalEditText;
    private EditText costEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userIdEditText = findViewById(R.id.userIdEditText);
        departureEditText = findViewById(R.id.departureEditText);
        arrivalEditText = findViewById(R.id.arrivalEditText);
        costEditText = findViewById(R.id.costEditText);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userId = Integer.parseInt(userIdEditText.getText().toString());
                String departure = departureEditText.getText().toString();
                String arrival = arrivalEditText.getText().toString();
                double cost = Double.parseDouble(costEditText.getText().toString());

                Ticket ticket = new Ticket(userId, departure, arrival, cost);

                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra("ticket", ticket);
                startActivity(intent);
            }
        });
    }
}
