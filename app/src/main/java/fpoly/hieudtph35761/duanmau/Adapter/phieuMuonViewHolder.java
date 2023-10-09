package fpoly.hieudtph35761.duanmau.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fpoly.hieudtph35761.duanmau.R;

public class phieuMuonViewHolder extends RecyclerView.ViewHolder{

    TextView tv_pm_maPhieu,tv_pm_thanhVien, tv_pm_tenSach,tv_pm_trangThai,tv_pm_giaThue,tv_pm_ngayThue;

    View mview;

    public phieuMuonViewHolder(@NonNull View itemView) {
        super(itemView);

        tv_pm_maPhieu = itemView.findViewById(R.id.tv_pm_MaPhieu);
        tv_pm_thanhVien = itemView.findViewById(R.id.tv_pm_thanhVien);
        tv_pm_tenSach = itemView.findViewById(R.id.tv_pm_tenSach);
        tv_pm_trangThai = itemView.findViewById(R.id.tv_pm_trangThai);
        tv_pm_giaThue = itemView.findViewById(R.id.tv_pm_giaThue);
        tv_pm_ngayThue = itemView.findViewById(R.id.tv_pm_ngayThue);
        mview = itemView;
    }
}
