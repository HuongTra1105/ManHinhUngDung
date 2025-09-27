package com.example.manhinhungdung.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.manhinhungdung.R;

import java.util.List;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.DateViewHolder> {

    private List<String> dateList123;
    private OnDateClickListener123 listener123;

    public interface OnDateClickListener123 {
        void onDateClick123(String date123);
    }

    public DateAdapter(List<String> dateList123, OnDateClickListener123 listener123) {
        this.dateList123 = dateList123;
        this.listener123 = listener123;
    }

    @NonNull
    @Override
    public DateViewHolder onCreateViewHolder(@NonNull ViewGroup parent123, int viewType123) {
        View view123 = LayoutInflater.from(parent123.getContext())
                .inflate(R.layout.item_date, parent123, false);
        return new DateViewHolder(view123);
    }

    @Override
    public void onBindViewHolder(@NonNull DateViewHolder holder123, int position123) {
        String date123 = dateList123.get(position123);
        holder123.tvDate123.setText(date123);

        holder123.itemView.setOnClickListener(v -> {
            if (listener123 != null) {
                listener123.onDateClick123(date123);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dateList123.size();
    }

    public static class DateViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate123;

        public DateViewHolder(@NonNull View itemView123) {
            super(itemView123);
            tvDate123 = itemView123.findViewById(R.id.tvDate123);
        }
    }
}
