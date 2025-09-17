package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.Truong;

import java.util.ArrayList;
import java.util.List;
public class TruongAdapterTotal extends RecyclerView.Adapter<TruongAdapterTotal.TruongViewHolder> {

    private int itemLayout; // layout resource id
    private List<Truong> list = new ArrayList<>();
    private OnItemClickListener listener;

    public TruongAdapterTotal(int itemLayout) {
        this.itemLayout = itemLayout;
    }

    public TruongAdapterTotal(int itemLayout, String đhHàNội, String mạnhVềNgoạiNgữ, int icLauncherBackground, String s, float v, List<String> list, List<String> list1) {
    }

    public void setData(List<Truong> newList) {
        list = newList;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(Truong truong);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public TruongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(itemLayout, parent, false); // dùng layout được truyền vào
        return new TruongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TruongViewHolder holder, int position) {
        Truong truong = list.get(position);
        holder.tvTenTruong.setText(truong.getTen());
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) listener.onItemClick(truong);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class TruongViewHolder extends RecyclerView.ViewHolder {
        TextView tvTenTruong;
        ImageView imgTruong;

        public TruongViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenTruong = itemView.findViewById(R.id.tvTenTruong);
            imgTruong = itemView.findViewById(R.id.imgTruong);
        }
    }
}
