package fpoly.hieudtph35761.duanmau.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import fpoly.hieudtph35761.duanmau.Adapter.loaiSachAdapter;
import fpoly.hieudtph35761.duanmau.DAO.loaiSachDAO;
import fpoly.hieudtph35761.duanmau.Database.DbHelper;
import fpoly.hieudtph35761.duanmau.Model.loaiSach;
import fpoly.hieudtph35761.duanmau.R;


public class loaiSach_Fragment extends Fragment {

    RecyclerView recyclerView;
    FloatingActionButton btn_ls_add;

    loaiSachAdapter adapter;
    ArrayList<loaiSach> list;

    DbHelper dbHelper;
    Context context;
    loaiSachDAO lsDAO;

    EditText edt_ls_tenloai;
    Button btn_dialog_add;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_loai_sach_, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_ls);
        btn_ls_add = view.findViewById(R.id.btn_ls_add);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lsDAO = new loaiSachDAO(getContext());
        list = lsDAO.getALl();

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new loaiSachAdapter(list,getContext(),dbHelper);
        recyclerView.setAdapter(adapter);

        btn_ls_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View view1 = LayoutInflater.from(getContext()).inflate(R.layout.item_dialog_add_loaisach,null);
                builder.setView(view1);

                edt_ls_tenloai = view1.findViewById(R.id.edt_ls_tenloai);
                btn_dialog_add = view1.findViewById(R.id.btn_ls_dialog_add);

                btn_dialog_add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String tenLoai = edt_ls_tenloai.getText().toString();
                        if (tenLoai.equals("")){
                            Toast.makeText(getContext(), "can nhap du lieu", Toast.LENGTH_SHORT).show();
                        }else{
                            if (lsDAO.add(tenLoai)){
                                Toast.makeText(getContext(), "Them thanh cong", Toast.LENGTH_SHORT).show();

                                list = lsDAO.getALl();
                                adapter = new loaiSachAdapter(list,getContext(),dbHelper);
                                recyclerView.setAdapter(adapter);
                            }else{
                                Toast.makeText(getContext(), "them that bai", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                builder.create().show();
            }
        });
    }
}