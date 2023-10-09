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

import java.util.ArrayList;

import fpoly.hieudtph35761.duanmau.Adapter.sachNhieuNhatAdapter;
import fpoly.hieudtph35761.duanmau.DAO.sachDAO;
import fpoly.hieudtph35761.duanmau.Database.DbHelper;
import fpoly.hieudtph35761.duanmau.Model.sach;
import fpoly.hieudtph35761.duanmau.R;


public class sachMuaNhieuNhatFragment extends Fragment {

    ArrayList<sach> list;
    sachDAO scDAO;
    DbHelper dbHelper;

    RecyclerView recyclerView;

    sachNhieuNhatAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sach_mua_nhieu_nhat, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_sachNhieuNhat);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        scDAO = new sachDAO(getContext());
        list = scDAO.getSachNhieuNhat();

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new sachNhieuNhatAdapter(list,getContext(), dbHelper);
        recyclerView.setAdapter(adapter);

    }
}