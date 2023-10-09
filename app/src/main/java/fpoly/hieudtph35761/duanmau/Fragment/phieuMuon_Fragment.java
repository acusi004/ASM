package fpoly.hieudtph35761.duanmau.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import fpoly.hieudtph35761.duanmau.Adapter.phieuMuonAdapter;
import fpoly.hieudtph35761.duanmau.DAO.phieuMuonDAO;
import fpoly.hieudtph35761.duanmau.DAO.sachDAO;
import fpoly.hieudtph35761.duanmau.DAO.thanhVienDAO;
import fpoly.hieudtph35761.duanmau.Model.phieuMuon;
import fpoly.hieudtph35761.duanmau.Model.sach;
import fpoly.hieudtph35761.duanmau.Model.thanhVien;
import fpoly.hieudtph35761.duanmau.R;


public class phieuMuon_Fragment extends Fragment {

    RecyclerView recyclerView;
    FloatingActionButton btn_pm_add;

    phieuMuonDAO pmDAO;

    ArrayList<phieuMuon> list;
    phieuMuonAdapter adapterPm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_phieu_muon_, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        btn_pm_add = view.findViewById(R.id.btn_add);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pmDAO = new phieuMuonDAO(getContext());
        list = pmDAO.getAllPhieuMuon();

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapterPm= new phieuMuonAdapter(pmDAO, getContext(), list);
        recyclerView.setAdapter(adapterPm);

        btn_pm_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog();
            }
        });
    }
    private void Dialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.item_dialog_add_pm, null);
        Spinner spnTV = view.findViewById(R.id.spn_thanVien);
        Spinner spnSach = view.findViewById(R.id.spn_pm_sach);
        EditText edt_tieThue = view.findViewById(R.id.edt_pm_tien);
        Button btn_themPM = view.findViewById(R.id.btn_pm_add);
        getDataThanhVien(spnTV);
        getDataSach(spnSach);
        builder.setView(view);

        btn_themPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // lay matv
                HashMap<String, Object> hsTV = (HashMap<String, Object>) spnTV.getSelectedItem();
                int matv = (int) hsTV.get("MATV");
                HashMap<String, Object> hsSach = (HashMap<String, Object>) spnSach.getSelectedItem();
                int maSach = (int) hsSach.get("MASACH");
                int tienThue = Integer.parseInt(edt_tieThue.getText().toString());

                // lay matt
                SharedPreferences sharedPreferences = getContext(). getSharedPreferences("TT", Context.MODE_PRIVATE);
                String matt = sharedPreferences.getString("MATT", "");
                // lay ngay hien tai
                Date date = Calendar.getInstance().getTime();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                String ngay = simpleDateFormat.format(date);

                phieuMuon pm = new phieuMuon(matv,matt, maSach,ngay, 0,tienThue);
                boolean check =  pmDAO.themPM(pm);
                if (check) {
                    Toast.makeText(getContext(), "Successfully", Toast.LENGTH_SHORT).show();
                    loadData();
                }else{
                    Toast.makeText(getContext(), "failed", Toast.LENGTH_SHORT).show();
                }


            }
        });





        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void loadData(){
        pmDAO = new phieuMuonDAO(getContext());
        list = pmDAO.getAllPhieuMuon();
        
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapterPm= new phieuMuonAdapter(pmDAO, getContext(), list);
        recyclerView.setAdapter(adapterPm);
    }

    // ham lat data thanh vien
    public  void getDataThanhVien(Spinner spnTV){
        thanhVienDAO thanhVienDao = new thanhVienDAO(getContext());
        ArrayList<thanhVien> list = thanhVienDao.getALl();

        ArrayList<HashMap<String ,Object>> listHM = new ArrayList<>();
        for(thanhVien tv: list){
            HashMap<String, Object> hs = new HashMap<>();
            hs.put("MATV", tv.getMatv());
            hs.put("HOTEN",tv.getHoTen());
            listHM.add(hs);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(
                getContext(),
                listHM,
                android.R.layout.simple_list_item_1,
                new String[]{"HOTEN"},
                new int[]{android.R.id.text1});
                spnTV.setAdapter(simpleAdapter);

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