package com.example.manhinhungdung.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.manhinhungdung.models.Seat;

import java.util.List;

public class SeatAdapter extends BaseAdapter {

    private Context context123;
    private List<Seat> seatList123;

    public SeatAdapter(Context context123, List<Seat> seatList123) {
        this.context123 = context123;
        this.seatList123 = seatList123;
    }

    @Override
    public int getCount() {
        return seatList123.size();
    }

    @Override
    public Object getItem(int position123) {
        return seatList123.get(position123);
    }

    @Override
    public long getItemId(int position123) {
        return position123;
    }

    @Override
    public View getView(int position123, View convertView123, ViewGroup parent123) {
        ViewHolder holder123;
        if (convertView123 == null) {
            convertView123 = LayoutInflater.from(context123).inflate(android.R.layout.simple_list_item_1, parent123, false);
            holder123 = new ViewHolder();
            holder123.tvSeat123 = convertView123.findViewById(android.R.id.text1);
            convertView123.setTag(holder123);
        } else {
            holder123 = (ViewHolder) convertView123.getTag();
        }

        Seat seat123 = seatList123.get(position123);
        holder123.tvSeat123.setText(seat123.getSeatNumber());
        holder123.tvSeat123.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        holder123.tvSeat123.setPadding(16, 16, 16, 16);

        if (seat123.isBooked()) {
            holder123.tvSeat123.setBackgroundColor(Color.GRAY);
            holder123.tvSeat123.setTextColor(Color.WHITE);
            convertView123.setEnabled(false);
        } else if (seat123.isSelected()) {
            holder123.tvSeat123.setBackgroundColor(Color.GREEN);
            holder123.tvSeat123.setTextColor(Color.BLACK);
        } else {
            holder123.tvSeat123.setBackgroundColor(Color.LTGRAY);
            holder123.tvSeat123.setTextColor(Color.BLACK);
        }

        convertView123.setOnClickListener(v -> {
            if (!seat123.isBooked()) {
                seat123.setSelected(!seat123.isSelected());
                notifyDataSetChanged();
            }
        });

        return convertView123;
    }

    static class ViewHolder {
        TextView tvSeat123;
    }
}
