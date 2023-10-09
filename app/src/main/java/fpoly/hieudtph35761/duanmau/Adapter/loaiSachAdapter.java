package fpoly.hieudtph35761.duanmau.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fpoly.hieudtph35761.duanmau.DAO.loaiSachDAO;
import fpoly.hieudtph35761.duanmau.Database.DbHelper;
import fpoly.hieudtph35761.duanmau.Model.loaiSach;
import fpoly.hieudtph35761.duanmau.R;
import fpoly.hieudtph35761.duanmau.manHinhChinh;

public class loaiSachAdapter extends RecyclerView.Adapter<loaiSachViewHolder> {
    ArrayList<loaiSach> list;
    Context context;

    DbHelper dbHelper;

    loaiSachDAO lsDAO;

    public loaiSachAdapter(ArrayList<loaiSach> list, Context context, DbHelper dbHelper) {
        this.list = list;
        this.context = context;
        this.dbHelper = dbHelper;
    }

    @NonNull
    @Override
    public loaiSachViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((manHinhChinh)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_rcv_loaisach,parent,false);
        return new loaiSachViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull loaiSachViewHolder holder, int position) {
        holder.tv_ls_maLoai.setText("Ma loai: "+ String.valueOf(list.get(position).getMaLoai()));
        holder.tv_ls_tenLoai.setText("Ten loai: "+list.get(position).getTenLoai());

        holder.mview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thong bao");
                builder.setIcon(R.drawable.baseline_warning_amber_24);
                builder.setMessage("ban co chac chan muon xoa khong ");
                builder.setCancelable(false);

                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        lsDAO = new loaiSachDAO(context);
                        int check = lsDAO.delete(list.get(holder.getAdapterPosition()).getMaLoai());
                        if (check==1){
                            Toast.makeText(context, "Successfully", Toast.LENGTH_SHORT).show();
                            notifyItemRemoved(holder.getAdapterPosition());
                        }else if(check==-1){
                            Toast.makeText(context, "khong the xoa loai sach nay vi da co sach thuoc the loai nay", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(context, "xoa that bai", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create();
                builder.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
