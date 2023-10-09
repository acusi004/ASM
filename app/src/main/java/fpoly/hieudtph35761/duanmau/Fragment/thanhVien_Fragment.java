package fpoly.hieudtph35761.duanmau.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import fpoly.hieudtph35761.duanmau.Adapter.thanhVienAdapter;
import fpoly.hieudtph35761.duanmau.DAO.thanhVienDAO;
import fpoly.hieudtph35761.duanmau.Database.DbHelper;
import fpoly.hieudtph35761.duanmau.Model.thanhVien;
import fpoly.hieudtph35761.duanmau.R;


public class thanhVien_Fragment extends Fragment {

    DbHelper dbHelper;
    thanhVienDAO tvDAO;

    ArrayList<thanhVien>list;

    RecyclerView recyclerView;
    FloatingActionButton btn_tv_add;

    thanhVienAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thanh_vien_, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_tv);
        btn_tv_add = view.findViewById(R.id.btn_tv_add);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvDAO = new thanhVienDAO(getContext());
        list = tvDAO.getALl();

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new thanhVienAdapter(getContext(),list,dbHelper);
        recyclerView.setAdapter(adapter);



    }
}