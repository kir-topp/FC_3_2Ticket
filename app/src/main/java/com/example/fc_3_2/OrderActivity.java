package com.example.fc_3_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {
    private TextView userIdTextView;
    private TextView departureTextView;
    private TextView arrivalTextView;
    private TextView costTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        userIdTextView = findViewById(R.id.userIdTextView);
        departureTextView = findViewById(R.id.departureTextView);
        arrivalTextView = findViewById(R.id.arrivalTextView);
        costTextView = findViewById(R.id.costTextView);

        Intent intent = getIntent();
        Ticket ticket = intent.getParcelableExtra("ticket");

        if (ticket != null) {
            int userId = ticket.getUserId();
            String departure = ticket.getDeparture();
            String arrival = ticket.getArrival();
            double cost = ticket.getCost();

            userIdTextView.setText(String.valueOf(userId));
            departureTextView.setText(departure);
            arrivalTextView.setText(arrival);
            costTextView.setText(String.valueOf(cost));
        } else {
            // Обработка случая, когда ticket является null
        }
    }
}
