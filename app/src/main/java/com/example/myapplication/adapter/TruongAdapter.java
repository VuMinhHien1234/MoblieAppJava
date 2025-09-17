package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Truong;

import java.util.List;

public class TruongAdapter extends RecyclerView.Adapter<TruongAdapter.TruongViewHolder> {

    private final Context context;
    private final List<Truong> list;

    public TruongAdapter(Context context, List<Truong> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TruongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.fragment_cactruong, parent, false);
        return new TruongViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TruongViewHolder holder, int position) {
        Truong t = list.get(position);
        holder.img.setImageResource(t.getHinhAnh());
        holder.ten.setText(t.getTen());
        holder.moTa.setText(t.getMoTa());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class TruongViewHolder extends RecyclerView.ViewHolder {
        ImageView img; TextView ten; TextView moTa;
        public TruongViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgNganh);
            ten = itemView.findViewById(R.id.txtNganh);
            moTa = itemView.findViewById(R.id.txtMoTa);
        }
    }
}
