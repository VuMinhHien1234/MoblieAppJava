package com.example.myapplication.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.R;
import com.example.myapplication.model.Nganh;
import com.example.myapplication.model.Truong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<List<Nganh>> nganhList = new MutableLiveData<>();
    private final MutableLiveData<List<Truong>> truongList = new MutableLiveData<>();
    private int idCounter = 1; // để tạo id duy nhất

    public HomeViewModel() {
        // Danh sách ngành mẫu
        List<Nganh> list = new ArrayList<>();
        list.add(new Nganh("Công nghệ thông tin"));
        list.add(new Nganh("Kinh tế"));
        list.add(new Nganh("Y dược"));
        list.add(new Nganh("Luật"));
        list.add(new Nganh("Ngôn ngữ Anh"));
        nganhList.setValue(list);

        // Load mặc định trường ngành đầu tiên
        loadTruongTheoNganh("Công nghệ thông tin");
    }

    public LiveData<List<Nganh>> getNganhList() {
        return nganhList;
    }

    public LiveData<List<Truong>> getTruongList() {
        return truongList;
    }

    public void loadTruongTheoNganh(String tenNganh) {
        List<Truong> ds = new ArrayList<>();

        if (tenNganh.equals("Công nghệ thông tin")) {
            ds.add(new Truong(
                    idCounter++,
                    "ĐH Bách Khoa",
                    "Trường top đầu về CNTT",
                    R.drawable.ic_launcher_background,
                    "10,000,000 VNĐ/năm",
                    4.5f,
                    Arrays.asList("img1.jpg","img2.jpg","img3.jpg"),
                    Arrays.asList("Khuôn viên rộng", "Giảng viên chất lượng", "Hoạt động ngoại khóa", "Đối tác doanh nghiệp")
            ));
            ds.add(new Truong(
                    idCounter++,
                    "ĐH FPT",
                    "Mạnh về lập trình và công nghệ",
                    R.drawable.ic_launcher_background,
                    "12,000,000 VNĐ/năm",
                    4.2f,
                    Arrays.asList("img4.jpg","img5.jpg","img6.jpg"),
                    Arrays.asList("Học bổng hấp dẫn", "Cơ sở vật chất hiện đại", "Hợp tác doanh nghiệp", "Đa dạng ngành học")
            ));
        } else if (tenNganh.equals("Kinh tế")) {
            ds.add(new Truong(
                    idCounter++,
                    "ĐH Kinh tế Quốc dân",
                    "Đào tạo kinh tế chất lượng",
                    R.drawable.ic_launcher_background,
                    "11,000,000 VNĐ/năm",
                    4.3f,
                    Arrays.asList("img7.jpg","img8.jpg"),
                    Arrays.asList("Giảng viên tốt", "Cơ sở vật chất đầy đủ", "Hoạt động ngoại khóa", "Hợp tác doanh nghiệp")
            ));
        } else if (tenNganh.equals("Y dược")) {
            ds.add(new Truong(
                    idCounter++,
                    "ĐH Y Hà Nội",
                    "Trường đầu ngành về Y",
                    R.drawable.ic_launcher_background,
                    "15,000,000 VNĐ/năm",
                    4.6f,
                    Arrays.asList("img9.jpg","img10.jpg"),
                    Arrays.asList("Trang thiết bị hiện đại", "Bác sĩ giỏi", "Thực hành bệnh viện", "Học bổng")
            ));
        } else if (tenNganh.equals("Luật")) {
            ds.add(new Truong(
                    idCounter++,
                    "ĐH Luật Hà Nội",
                    "Trường chuyên ngành Luật",
                    R.drawable.ic_launcher_background,
                    "9,000,000 VNĐ/năm",
                    4.1f,
                    Arrays.asList("img11.jpg"),
                    Arrays.asList("Giảng viên uy tín", "Cơ sở vật chất", "Hoạt động ngoại khóa", "Hợp tác doanh nghiệp")
            ));
        } else if (tenNganh.equals("Ngôn ngữ Anh")) {
            ds.add(new Truong(
                    idCounter++,
                    "ĐH Hà Nội",
                    "Mạnh về ngoại ngữ",
                    R.drawable.ic_launcher_background,
                    "10,500,000 VNĐ/năm",
                    4.2f,
                    Arrays.asList("img12.jpg","img13.jpg"),
                    Arrays.asList("Giảng viên nước ngoài", "Cơ sở vật chất hiện đại", "Chương trình trao đổi", "Hoạt động ngoại khóa")
            ));
        }

        truongList.setValue(ds);
    }
}
