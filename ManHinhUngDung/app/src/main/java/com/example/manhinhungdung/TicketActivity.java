package com.example.manhinhungdung;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TicketActivity extends AppCompatActivity {

    private TextView tvAppName123, tvMovieTitle123, tvShowtime123, tvCinemaRoom123, tvSeats123;
    private ImageView imgPoster123, imgQRCode123;
    private Button btnSaveTicket123, btnShareTicket123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket); // activity_ticket.xml

        tvAppName123 = findViewById(R.id.tvAppName);
        imgPoster123 = findViewById(R.id.imgPoster);
        tvMovieTitle123 = findViewById(R.id.tvMovieTitle);
        tvShowtime123 = findViewById(R.id.tvShowtime);
        tvCinemaRoom123 = findViewById(R.id.tvCinemaRoom);
        tvSeats123 = findViewById(R.id.tvSeats);
        imgQRCode123 = findViewById(R.id.imgQRCode);
        btnSaveTicket123 = findViewById(R.id.btnSaveTicket);
        btnShareTicket123 = findViewById(R.id.btnShareTicket);

        String seats123 = getIntent().getStringExtra("seats");
        int total123 = getIntent().getIntExtra("total", 0);
        String method123 = getIntent().getStringExtra("paymentMethod");

        tvMovieTitle123.setText(getIntent().getStringExtra("movieTitle") != null ? getIntent().getStringExtra("movieTitle") : "Phim");
        tvSeats123.setText("Ghế: " + (seats123 != null ? seats123 : ""));
        // tvShowtime123, tvCinemaRoom123 set tu intent nếu có

        btnSaveTicket123.setOnClickListener(v -> Toast.makeText(this, "Vé đã được lưu vào thiết bị", Toast.LENGTH_SHORT).show());
        btnShareTicket123.setOnClickListener(v -> Toast.makeText(this, "Chia sẻ vé thành công", Toast.LENGTH_SHORT).show());
    }
}
