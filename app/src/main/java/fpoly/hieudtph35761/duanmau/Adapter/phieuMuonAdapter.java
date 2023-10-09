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

import fpoly.hieudtph35761.duanmau.DAO.phieuMuonDAO;
import fpoly.hieudtph35761.duanmau.Model.phieuMuon;
import fpoly.hieudtph35761.duanmau.R;
import fpoly.hieudtph35761.duanmau.manHinhChinh;

public class phieuMuonAdapter extends RecyclerView.Adapter<phieuMuonViewHolder> {



    phieuMuonDAO pmDAO;

     Context context;
     ArrayList<phieuMuon> list;

    public phieuMuonAdapter(phieuMuonDAO pmDAO, Context context, ArrayList<phieuMuon> list) {
        this.pmDAO = pmDAO;
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public phieuMuonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((manHinhChinh)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_rcv_phieumuon, parent, false);
        return new phieuMuonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull phieuMuonViewHolder holder, int position) {
        holder.tv_pm_maPhieu.setText("ma phieu muon: "+String.valueOf(list.get(position).getMapm()));
        holder.tv_pm_thanhVien.setText("thanh vien: "+list.get(position).getTenTv());
        holder.tv_pm_tenSach.setText("ten sach: "+list.get(position).getTenSach());
        String tt = "";
        if(list.get(position).getTraSach()==1){
            tt = "da tra sach";
        }else{
            tt = "chua tra sach";
        }
        holder.tv_pm_trangThai.setText(tt);
        holder.tv_pm_giaThue.setText("gia thue: "+String.valueOf(list.get(position).getTienThue()));
        holder.tv_pm_ngayThue.setText("Ngay thue: "+list.get(position).getNgay());


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
                        int mapm = list.get(holder.getAdapterPosition()).getMapm();
                        boolean check = pmDAO.delete(mapm);
                        if (check){
                            Toast.makeText(context, "Sucessfully", Toast.LENGTH_SHORT).show();
                            list.clear();
                            list = pmDAO.getAllPhieuMuon();
                            notifyItemRemoved(holder.getAdapterPosition());
                        }else{
                            Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();
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
