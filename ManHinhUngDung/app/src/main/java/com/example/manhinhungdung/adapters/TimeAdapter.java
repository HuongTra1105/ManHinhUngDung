package com.example.manhinhungdung.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.manhinhungdung.R;

import java.util.List;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.TimeViewHolder> {

    private List<String> timeList123;
    private OnTimeClickListener123 listener123;

    public interface OnTimeClickListener123 {
        void onTimeClick123(String time123);
    }

    public TimeAdapter(List<String> timeList123, OnTimeClickListener123 listener123) {
        this.timeList123 = timeList123;
        this.listener123 = listener123;
    }

    @NonNull
    @Override
    public TimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent123, int viewType123) {
        View view123 = LayoutInflater.from(parent123.getContext())
                .inflate(R.layout.item_time, parent123, false);
        return new TimeViewHolder(view123);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeViewHolder holder123, int position123) {
        String time123 = timeList123.get(position123);
        holder123.tvTime123.setText(time123);

        holder123.itemView.setOnClickListener(v -> {
            if (listener123 != null) {
                listener123.onTimeClick123(time123);
            }
        });
    }

    @Override
    public int getItemCount() {
        return timeList123.size();
    }

    public static class TimeViewHolder extends RecyclerView.ViewHolder {
        TextView tvTime123;

        public TimeViewHolder(@NonNull View itemView123) {
            super(itemView123);
            tvTime123 = itemView123.findViewById(R.id.tvTime123);
        }
    }
}
