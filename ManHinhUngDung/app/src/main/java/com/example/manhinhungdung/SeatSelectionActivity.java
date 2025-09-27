package com.example.manhinhungdung;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.manhinhungdung.adapters.SeatAdapter;
import com.example.manhinhungdung.models.Seat;

import java.util.ArrayList;
import java.util.List;

public class SeatSelectionActivity extends AppCompatActivity {

    private TextView tvScreen123, tvSummary123;
    private GridView gridSeats123;
    private Button btnContinue123;

    private SeatAdapter seatAdapter123;
    private List<Seat> seatList123;
    private int seatPrice123 = 80000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_selection); // activity_seat_selection.xml

        tvScreen123 = findViewById(R.id.tvScreen);
        gridSeats123 = findViewById(R.id.gridSeats);
        tvSummary123 = findViewById(R.id.tvSummary);
        btnContinue123 = findViewById(R.id.btnContinue);

        seatList123 = new ArrayList<>();
        for (char row = 'A'; row <= 'F'; row++) {
            for (int col = 1; col <= 8; col++) {
                String seatNum123 = row + String.valueOf(col);
                boolean isBooked123 = Math.random() < 0.2;
                seatList123.add(new Seat(seatNum123, isBooked123));
            }
        }

        seatAdapter123 = new SeatAdapter(this, seatList123);
        gridSeats123.setAdapter(seatAdapter123);

        btnContinue123.setOnClickListener(v -> {
            List<String> selected123 = new ArrayList<>();
            int total123 = 0;
            for (Seat s123 : seatList123) {
                if (s123.isSelected()) {
                    selected123.add(s123.getSeatNumber());
                    total123 += seatPrice123;
                }
            }
            if (selected123.isEmpty()) {
                Toast.makeText(this, "Vui lòng chọn ghế!", Toast.LENGTH_SHORT).show();
                return;
            }
            tvSummary123.setText("Ghế đã chọn: " + selected123 + " | Tổng tiền: " + total123 + "đ");

            Intent intent123 = new Intent(this, PaymentActivity.class);
            intent123.putExtra("seats", String.join(", ", selected123));
            intent123.putExtra("total", total123);
            startActivity(intent123);
        });
    }
}
