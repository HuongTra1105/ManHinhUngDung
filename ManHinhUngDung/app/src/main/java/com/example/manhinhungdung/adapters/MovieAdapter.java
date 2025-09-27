package com.example.manhinhungdung.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.manhinhungdung.R;
import com.example.manhinhungdung.models.Movie;
import com.example.manhinhungdung.R;
import com.example.manhinhungdung.models.Movie;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder123> {

    private final Context context123;
    private final List<Movie> movieList123;

    public MovieAdapter(Context context123, List<Movie> movieList123) {
        this.context123 = context123;
        this.movieList123 = movieList123;
    }

    @NonNull
    @Override
    public MovieViewHolder123 onCreateViewHolder(@NonNull ViewGroup parent123, int viewType123) {
        View view123 = LayoutInflater.from(context123).inflate(R.layout.item_movie, parent123, false);
        return new MovieViewHolder123(view123);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder123 holder123, int position123) {
        Movie movie123 = movieList123.get(position123);

        holder123.tvTitle123.setText(movie123.getTitle());
        holder123.tvInfo123.setText(movie123.getInfo());
        holder123.imgPoster123.setImageResource(movie123.getPosterResId());

        holder123.btnBook123.setOnClickListener(v123 ->
                Toast.makeText(context123, "Đặt vé: " + movie123.getTitle(), Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public int getItemCount() {
        return movieList123 != null ? movieList123.size() : 0;
    }

    static class MovieViewHolder123 extends RecyclerView.ViewHolder {
        ImageView imgPoster123;
        TextView tvTitle123, tvInfo123;
        MaterialButton btnBook123;

        public MovieViewHolder123(@NonNull View itemView123) {
            super(itemView123);
            imgPoster123 = itemView123.findViewById(R.id.imgPoster);
            tvTitle123 = itemView123.findViewById(R.id.tvTitle);
            tvInfo123 = itemView123.findViewById(R.id.tvInfo);
            btnBook123 = itemView123.findViewById(R.id.btnBook);
        }
    }
}
