package com.example.manhinhungdung;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.manhinhungdung.adapters.MovieAdapter;
import com.example.manhinhungdung.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieListActivity extends AppCompatActivity {

    private SearchView searchView123;
    private RecyclerView recyclerViewMovies123;
    private MovieAdapter adapter123;
    private List<Movie> movieList123;    // danh sách hiện tại (được adapter dùng)
    private List<Movie> allMovies123;    // toàn bộ danh sách để filter

    @Override
    protected void onCreate(Bundle savedInstanceState123) {
        super.onCreate(savedInstanceState123);
        setContentView(R.layout.activity_movie_list); // activity_movie_list.xml

        searchView123 = findViewById(R.id.searchView);
        recyclerViewMovies123 = findViewById(R.id.recyclerViewMovies);

        // Tạo dữ liệu demo (bạn thay bằng dữ liệu thật nếu có)
        allMovies123 = new ArrayList<>();
        allMovies123.add(new Movie("Avengers: Endgame", "Hành động - 180 phút", R.drawable.ic_launcher_foreground));
        allMovies123.add(new Movie("Frozen II", "Hoạt hình - 103 phút", R.drawable.ic_launcher_foreground));
        allMovies123.add(new Movie("Parasite", "Tâm lý - 132 phút", R.drawable.ic_launcher_foreground));
        allMovies123.add(new Movie("Spider-Man: No Way Home", "Hành động - 148 phút", R.drawable.ic_launcher_foreground));
        allMovies123.add(new Movie("Interstellar", "Khoa học viễn tưởng - 169 phút", R.drawable.ic_launcher_foreground));

        // Khởi tạo danh sách hiển thị (clone từ allMovies)
        movieList123 = new ArrayList<>(allMovies123);

        // Khởi tạo adapter (theo signature hiện tại của MovieAdapter)
        adapter123 = new MovieAdapter(this, movieList123);
        recyclerViewMovies123.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerViewMovies123.setAdapter(adapter123);

        // SearchView -> lọc danh sách
        searchView123.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query123) {
                filterMovies(query123);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText123) {
                filterMovies(newText123);
                return true;
            }
        });
    }

    // Hàm lọc: sửa movieList123 rồi thông báo adapter cập nhật
    private void filterMovies(String query123) {
        String q = query123 == null ? "" : query123.trim().toLowerCase();
        movieList123.clear();
        if (q.isEmpty()) {
            movieList123.addAll(allMovies123);
        } else {
            for (Movie m123 : allMovies123) {
                if ((m123.getTitle() != null && m123.getTitle().toLowerCase().contains(q)) ||
                        (m123.getInfo() != null && m123.getInfo().toLowerCase().contains(q))) {
                    movieList123.add(m123);
                }
            }
        }
        adapter123.notifyDataSetChanged();
    }
}
