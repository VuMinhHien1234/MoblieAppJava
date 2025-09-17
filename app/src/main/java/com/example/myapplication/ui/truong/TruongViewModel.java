package com.example.myapplication.ui.truong;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.Truong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TruongViewModel extends ViewModel {
    private final MutableLiveData<List<Truong>> truongList = new MutableLiveData<>();
    private final MutableLiveData<Truong> selectedTruong = new MutableLiveData<>();

    public TruongViewModel() {
        loadData();
    }
    public LiveData<List<Truong>> getTruongList() {
        return truongList;
    }

    public LiveData<Truong> getSelectedTruong() {
        return selectedTruong;
    }

    public void selectTruong(Truong truong) {
        selectedTruong.setValue(truong);
    }
    private void loadData() {
        List<Truong> list = new ArrayList<>();

        list.add(new Truong(
                1,
                "Trường A",
                "Trường A nổi bật về ngành Công nghệ thông tin",
                "10,000,000 VNĐ/năm",
                4.5f,
                Arrays.asList("img1.jpg","img2.jpg","img3.jpg"),
                Arrays.asList("Khuôn viên rộng", "Giảng viên chất lượng", "Hoạt động ngoại khóa", "Đối tác doanh nghiệp")
        ));

        list.add(new Truong(
                2,
                "Trường B",
                "Trường B có nhiều chương trình học quốc tế",
                "12,000,000 VNĐ/năm",
                4.2f,
                Arrays.asList("img4.jpg","img5.jpg","img6.jpg"),
                Arrays.asList("Học bổng hấp dẫn", "Cơ sở vật chất hiện đại", "Hợp tác doanh nghiệp", "Đa dạng ngành học")
        ));

        truongList.setValue(list);
    }
    public Truong getTruongById(int id) {
        if (truongList.getValue() == null) return null;
        for (Truong t : truongList.getValue()) {
            if (t.getId() == id) return t;
        }
        return null;
    }

}
