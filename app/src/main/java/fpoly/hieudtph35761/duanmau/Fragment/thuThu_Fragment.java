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

import fpoly.hieudtph35761.duanmau.Adapter.thuThuAdapter;
import fpoly.hieudtph35761.duanmau.DAO.thuThuDAO;
import fpoly.hieudtph35761.duanmau.Database.DbHelper;
import fpoly.hieudtph35761.duanmau.Model.thuThu;
import fpoly.hieudtph35761.duanmau.R;


public class thuThu_Fragment extends Fragment {


    RecyclerView recyclerView;
    FloatingActionButton btn_tt_add;

    ArrayList<thuThu> list;

    thuThuDAO ttDAO;

    DbHelper dbHelper;
    thuThuAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thu_thu_, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_thuthu);
        btn_tt_add = view.findViewById(R.id.btn_tt_add);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ttDAO = new thuThuDAO(getContext());
        list = ttDAO.getALl();

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new thuThuAdapter(list,getContext(),dbHelper);
        recyclerView.setAdapter(adapter);

        btn_tt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}