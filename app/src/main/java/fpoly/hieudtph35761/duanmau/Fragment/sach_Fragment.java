package fpoly.hieudtph35761.duanmau.Fragment;

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
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

import fpoly.hieudtph35761.duanmau.Adapter.sachAdapter;
import fpoly.hieudtph35761.duanmau.DAO.sachDAO;
import fpoly.hieudtph35761.duanmau.Database.DbHelper;
import fpoly.hieudtph35761.duanmau.Model.sach;
import fpoly.hieudtph35761.duanmau.R;


public class sach_Fragment extends Fragment {

    RecyclerView recyclerView;
    FloatingActionButton btn_sc_add;
    sachDAO sachDAO;

    ArrayList<sach> list;
    sachAdapter adapter;

    DbHelper dbHelper;
    Spinner spn_sc_sach;
    EditText edt_sc_giaThue;
    Button btn_add;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sach_, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_sach);
        btn_sc_add = view.findViewById(R.id.btn_sc_add);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sachDAO = new sachDAO(getContext());
        list = sachDAO.getall();

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new sachAdapter(list,dbHelper,getContext());
        recyclerView.setAdapter(adapter);

        btn_sc_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view1 = inflater.inflate(R.layout.item_dialog_add_sach,null);

                spn_sc_sach = view1.findViewById(R.id.spn_sc_sach);
                edt_sc_giaThue = view1.findViewById(R.id.edt_sc_giaThue);
                btn_add = view1.findViewById(R.id.btn_sc_dialog_add);

                btn_add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });


            }
        });





    }

    public  void getDataSach(Spinner spnSach){
        sachDAO sachdao = new sachDAO(getContext());
        ArrayList<sach> list = sachdao.getall();

        ArrayList<HashMap<String ,Object>> listHM = new ArrayList<>();
        for(sach sc: list){
            HashMap<String, Object> hs = new HashMap<>();
            hs.put("MASACH", sc.getSach());
            hs.put("TENSACH", sc.getTenSach());

            listHM.add(hs);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(
                getContext(),
                listHM,
                android.R.layout.simple_list_item_1,
                new String[]{"TENSACH"},
                new int[]{android.R.id.text1});
        spnSach.setAdapter(simpleAdapter);

    }
}