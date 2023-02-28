package com.example.phonecall;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phonecall.databinding.ListItemBinding;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class PhoneBookItemAdapter extends RecyclerView.Adapter<PhoneBookItemAdapter.PhoneBookItemViewHolder> {

    private List<PhoneBookItem> data;

    public PhoneBookItemAdapter(List<PhoneBookItem> data) {
        this.data = data;
    }

    public PhoneBookItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemBinding binding = ListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PhoneBookItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneBookItemViewHolder holder, int position) {
        holder.view.setImageResource(data.get(position).id);
        holder.name.setText(data.get(position).name);
        holder.name.setTextSize(16);
        //проверка количества символов для уменьшения размера при необходимости
        if (data.get(position).name.length() >= 20) {
            holder.name.setTextSize(12);
        }
        if (data.get(position).name.length() >= 60) {
            holder.name.setTextSize(8);
        }
        holder.info.setText(data.get(position).info);
        //смещение имени, если отсутвует описание
        if (data.get(position).info.length()==0){
            holder.name.setText("\n"+data.get(position).name);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PhoneBookItemViewHolder extends RecyclerView.ViewHolder {
        private ShapeableImageView view;
        private TextView name;
        private TextView info;

        public PhoneBookItemViewHolder(ListItemBinding binding) {
            super(binding.getRoot());
            view = binding.view;
            name = binding.name;
            info = binding.info;
        }
    }
}