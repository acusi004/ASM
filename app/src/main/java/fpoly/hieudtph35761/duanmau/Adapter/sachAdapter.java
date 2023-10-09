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

import fpoly.hieudtph35761.duanmau.DAO.sachDAO;
import fpoly.hieudtph35761.duanmau.Database.DbHelper;
import fpoly.hieudtph35761.duanmau.Model.sach;
import fpoly.hieudtph35761.duanmau.R;
import fpoly.hieudtph35761.duanmau.manHinhChinh;

public class sachAdapter extends RecyclerView.Adapter<sachViewHolder> {

    ArrayList<sach> list ;
    DbHelper dbHelper;

    Context context;

    sachDAO scDAO;

    public sachAdapter(ArrayList<sach> list, DbHelper dbHelper, Context context) {
        this.list = list;
        this.dbHelper = dbHelper;
        this.context = context;
    }


    @NonNull
    @Override
    public sachViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((manHinhChinh)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_rcv_sach,parent,false);
        return new sachViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull sachViewHolder holder, int position) {
        holder.tv_sc_maSach.setText("Ma sach: "+String.valueOf(list.get(position).getSach()));
        holder.tv_sc_tenSach.setText("Ten sach: "+list.get(position).getTenSach());
        holder.tv_sc_maSach.setText("Gia thue: "+String.valueOf(list.get(position).getGiaThue()));
        holder.tv_sc_maLoai.setText("Ma loai: "+String.valueOf(list.get(position).getMaLoai()));

        holder.mview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thong bao");
                builder.setIcon(R.drawable.baseline_warning_amber_24);
                builder.setMessage("ban co chac chan muon xoa khong ");
                builder.setCancelable(false);

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int maSach = list.get(holder.getAdapterPosition()).getSach();
                        boolean check = scDAO.delete(maSach);
                        if (check) {
                            Toast.makeText(context, "Sucessfully", Toast.LENGTH_SHORT).show();
                            list.clear();
                            list = scDAO.getall();
                            notifyItemRemoved(holder.getAdapterPosition());

                        }else{
                            Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.create().show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
