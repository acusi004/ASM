package fpoly.hieudtph35761.duanmau.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import fpoly.hieudtph35761.duanmau.DAO.thuThuDAO;
import fpoly.hieudtph35761.duanmau.Database.DbHelper;
import fpoly.hieudtph35761.duanmau.Model.thuThu;
import fpoly.hieudtph35761.duanmau.R;
import fpoly.hieudtph35761.duanmau.manHinhChinh;

public class thuThuAdapter extends RecyclerView.Adapter<thuThuViewHolder>{

    ArrayList<thuThu> list;
    Context context;
    DbHelper dbHelper;
    thuThuDAO ttDAO;
    RecyclerView recyclerView;
    FloatingActionButton btn_tt_add;

    public thuThuAdapter(ArrayList<thuThu> list, Context context, DbHelper dbHelper) {
        this.list = list;
        this.context = context;
        this.dbHelper = dbHelper;
    }

    @NonNull
    @Override
    public thuThuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((manHinhChinh)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_rcv_thuthu,parent,false);
        return new thuThuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull thuThuViewHolder holder, int position) {
        holder.tv_tt_matt.setText(list.get(position).getMatt());
        holder.tv_tt_hoTen.setText(list.get(position).getHoTen());
        holder.tv_tt_password.setText(list.get(position).getPassWord());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
