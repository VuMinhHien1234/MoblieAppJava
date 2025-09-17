package com.example.myapplication.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.R;
import com.example.myapplication.adapter.NganhAdapter;
import com.example.myapplication.adapter.TruongAdapterTotal;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.example.myapplication.model.Nganh;
import com.example.myapplication.model.Truong;
import com.example.myapplication.ui.truong.AllTruongActivity;
import com.example.myapplication.ui.truong.TruongDetailActivity;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        setupRecyclerViews();
        observeData();

        return root;
    }

    private void setupRecyclerViews() {
        binding.rvNganh.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false)
        );

        binding.rvTruong.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false)
        );
        binding.btnSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), AllTruongActivity.class);
            startActivity(intent);
        });

        binding.rvTruong.setHasFixedSize(false);

    }

    private void observeData() {
        viewModel.getNganhList().observe(getViewLifecycleOwner(), this::showNganhList);
        viewModel.getTruongList().observe(getViewLifecycleOwner(), this::showTruongList);
    }

    private void showNganhList(List<Nganh> list) {
        NganhAdapter adapter = new NganhAdapter(requireContext(), list, nganh -> {
            viewModel.loadTruongTheoNganh(nganh.getTen());
        });
        binding.rvNganh.setAdapter(adapter);
    }

    private void showTruongList(List<Truong> list) {
        // Dùng layout item_truong_home cho HomeFragment
        TruongAdapterTotal adapter = new TruongAdapterTotal(R.layout.item_truong);
        adapter.setData(list);

        adapter.setOnItemClickListener(truong -> {
            Intent intent = new Intent(requireContext(), TruongDetailActivity.class);
            intent.putExtra("truong_id", truong.getId());
            startActivity(intent);
        });

        binding.rvTruong.setAdapter(adapter);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
