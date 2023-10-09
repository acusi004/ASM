package fpoly.hieudtph35761.duanmau.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fpoly.hieudtph35761.duanmau.Database.DbHelper;
import fpoly.hieudtph35761.duanmau.Model.sach;
import fpoly.hieudtph35761.duanmau.R;
import fpoly.hieudtph35761.duanmau.manHinhChinh;

public class sachNhieuNhatAdapter extends RecyclerView.Adapter<sachNhieuNhatViewHolder> {

    ArrayList<sach> list;
    Context context;

    DbHelper dbHelper;

    public sachNhieuNhatAdapter(ArrayList<sach> list, Context context, DbHelper dbHelper) {
        this.list = list;
        this.context = context;
        this.dbHelper = dbHelper;
    }

    @NonNull
    @Override
    public sachNhieuNhatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((manHinhChinh)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_top10sach, parent, false);
        return new sachNhieuNhatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull sachNhieuNhatViewHolder holder, int position) {
        holder.tv_top10_maSach.setText("Ma sach: "+ String.valueOf(list.get(position).getSach()));
        holder.tv_top10_tenSach.setText("Ten sach: "+list.get(position).getTenSach());
        holder.tv_top10_nhieuNhat.setText("Sach muon nhieu nhat: "+ String.valueOf(list.get(position).getSachNhieuNhat()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
