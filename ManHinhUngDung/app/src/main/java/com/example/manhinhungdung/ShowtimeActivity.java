package com.example.manhinhungdung;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.manhinhungdung.adapters.DateAdapter;
import com.example.manhinhungdung.adapters.TimeAdapter;

import java.util.Arrays;
import java.util.List;

public class ShowtimeActivity extends AppCompatActivity {

    private TextView tvMovieTitle123;
    private ImageView imgPoster123;
    private RecyclerView recyclerViewDates123, recyclerViewTimes123;
    private Spinner spinnerTheater123;
    private Button btnContinue123;

    // lưu lựa chọn người dùng
    private String selectedDate123 = "";
    private String selectedTime123 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showtime); // activity_showtime.xml

        // ánh xạ view
        tvMovieTitle123 = findViewById(R.id.tvMovieTitle);
        imgPoster123 = findViewById(R.id.imgPoster);
        recyclerViewDates123 = findViewById(R.id.recyclerViewDates);
        recyclerViewTimes123 = findViewById(R.id.recyclerViewTimes);
        spinnerTheater123 = findViewById(R.id.spinnerTheater);
        btnContinue123 = findViewById(R.id.btnContinue);

        // lấy dữ liệu từ intent
        String title123 = getIntent().getStringExtra("movieTitle");
        if (title123 != null) tvMovieTitle123.setText(title123);

        // danh sách ngày chiếu
        List<String> dates123 = Arrays.asList("26/09", "27/09", "28/09", "29/09");
        DateAdapter dateAdapter123 = new DateAdapter(dates123, date -> {
            selectedDate123 = date; // lưu ngày được chọn
        });
        recyclerViewDates123.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewDates123.setAdapter(dateAdapter123);

        // danh sách giờ chiếu
        List<String> times123 = Arrays.asList("09:00", "11:30", "14:00", "16:30", "20:00");
        TimeAdapter timeAdapter123 = new TimeAdapter(times123, time -> {
            selectedTime123 = time; // lưu giờ được chọn
        });
        recyclerViewTimes123.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewTimes123.setAdapter(timeAdapter123);

        // sự kiện nút tiếp tục
        btnContinue123.setOnClickListener(v -> {
            Intent intent123 = new Intent(this, SeatSelectionActivity.class);
            intent123.putExtra("movieTitle", title123);
            intent123.putExtra("date", selectedDate123);
            intent123.putExtra("time", selectedTime123);
            startActivity(intent123);
        });
    }
}
