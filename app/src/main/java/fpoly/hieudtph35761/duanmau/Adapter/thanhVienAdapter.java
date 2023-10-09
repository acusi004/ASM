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

import fpoly.hieudtph35761.duanmau.DAO.thanhVienDAO;
import fpoly.hieudtph35761.duanmau.Database.DbHelper;
import fpoly.hieudtph35761.duanmau.Model.thanhVien;
import fpoly.hieudtph35761.duanmau.R;
import fpoly.hieudtph35761.duanmau.manHinhChinh;

public class thanhVienAdapter extends RecyclerView.Adapter<thanhVienViewHolder> {

    Context context;
    ArrayList<thanhVien> list;
    DbHelper dbHelper;
    thanhVienDAO tvDAO;



    public thanhVienAdapter(Context context, ArrayList<thanhVien> list, DbHelper dbHelper) {
        this.context = context;
        this.list = list;
        this.dbHelper = dbHelper;
    }

    @NonNull
    @Override
    public thanhVienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((manHinhChinh)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_rcv_thanhvien,parent,false);
        return new thanhVienViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull thanhVienViewHolder holder, int position) {
        holder.tv_tv_matv.setText("Ma thanh vien: "+String.valueOf(list.get(position).getMatv()));
        holder.tv_tv_hoTen.setText("Ho ten: "+ list.get(position).getHoTen());
        holder.tv_tv_namSinh.setText("Nam sinh: "+ list.get(position).getNamSinh());


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
                        int matv = list.get(holder.getAdapterPosition()).getMatv();
                        boolean check = tvDAO.delete(matv);
                        if (check) {
                            Toast.makeText(context, "Successfully", Toast.LENGTH_SHORT).show();
                            list.clear();
                            list = tvDAO.getALl();
                            notifyItemRemoved(holder.getAdapterPosition());
                        }else{
                            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

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
