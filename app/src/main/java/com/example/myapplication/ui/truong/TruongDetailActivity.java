package com.example.myapplication.ui.truong;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.AnhAdapter;
import com.example.myapplication.adapter.ThongTinAdapter;
import com.example.myapplication.model.Truong;


public class TruongDetailActivity extends AppCompatActivity {

    private TextView tvTen, tvMoTa, tvHocPhi, tvDanhGia;
    private RecyclerView rvAnh, rvThongTin;
    private ImageButton btnBack;
    private TruongViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truong_detail);

        tvTen = findViewById(R.id.tvTenTruong);
        tvMoTa = findViewById(R.id.tvMoTa);
        tvHocPhi = findViewById(R.id.tvHocPhi);
        tvDanhGia = findViewById(R.id.tvDanhGia);

        rvAnh = findViewById(R.id.rvAnh);
        rvThongTin = findViewById(R.id.rvThongTinChung);
        btnBack = findViewById(R.id.viewTopbar).findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> finish()); // Quay về màn trước

        rvAnh.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvThongTin.setLayoutManager(new LinearLayoutManager(this));

        // Lấy viewmodel
        viewModel = new ViewModelProvider(this).get(TruongViewModel.class);

        int truongId = getIntent().getIntExtra("truong_id", 1);
        if(truongId != -1) {
            viewModel.getTruongList().observe(this, list -> {
                for(Truong t : list) {
                    if(t.getId() == truongId) {
                        tvTen.setText(t.getTen());
                        tvMoTa.setText(t.getMoTa());
                        tvHocPhi.setText(t.getHocPhi());
                        tvDanhGia.setText(String.valueOf(t.getDanhGia()));

                        rvAnh.setAdapter(new AnhAdapter(this, t.getAnhList()));
                        rvThongTin.setAdapter(new ThongTinAdapter(this, t.getThongTinChung()));
                        break;
                    }
                }
            });
        }
    }


}
