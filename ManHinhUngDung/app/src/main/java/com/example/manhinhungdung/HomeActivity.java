package com.example.manhinhungdung;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.manhinhungdung.adapters.MovieAdapter;
import com.example.manhinhungdung.models.Movie;
import com.example.manhinhungdung.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private TextView tvAppName123;
    private EditText etSearch123;
    private ImageView imgBanner123;
    private RecyclerView recyclerFeaturedMovies123;
    private Button btnHome123, btnMyTickets123, btnAccount123;

    @Override
    protected void onCreate(Bundle savedInstanceState123) {
        super.onCreate(savedInstanceState123);
        setContentView(R.layout.activity_home);

        tvAppName123 = findViewById(R.id.tvAppName);
        etSearch123 = findViewById(R.id.etSearch);
        imgBanner123 = findViewById(R.id.imgBanner);
        recyclerFeaturedMovies123 = findViewById(R.id.recyclerFeaturedMovies);
        btnHome123 = findViewById(R.id.btnHome);
        btnMyTickets123 = findViewById(R.id.btnMyTickets);
        btnAccount123 = findViewById(R.id.btnAccount);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerFeaturedMovies123.setLayoutManager(layoutManager);

        List<Movie> featured123 = new ArrayList<>();
        featured123.add(new Movie("Mưa đỏ", "Thời lượng: 124 phút", R.drawable.ic_launcher_foreground));
        featured123.add(new Movie("Spider-Man", "Thời lượng: 110 phút", R.drawable.ic_launcher_foreground));
        featured123.add(new Movie("Parasite", "Tâm lý - 132 phút", R.drawable.ic_launcher_foreground));
        featured123.add(new Movie("Spider-Man: No Way Home", "Hành động - 148 phút", R.drawable.ic_launcher_foreground));
        featured123.add(new Movie("Interstellar", "Khoa học viễn tưởng - 169 phút", R.drawable.ic_launcher_foreground));
        featured123.add(new Movie("Avengers", "Thời lượng: 120 phút", R.drawable.ic_launcher_foreground));
        MovieAdapter adapter = new MovieAdapter(this, featured123);
        recyclerFeaturedMovies123.setAdapter(adapter);

        btnHome123.setOnClickListener(v123 -> {

        });

        btnMyTickets123.setOnClickListener(v123 ->
                startActivity(new Intent(this, TicketActivity.class))
        );

        btnAccount123.setOnClickListener(v123 ->
                startActivity(new Intent(this, MainActivity.class))
        );
    }
}
