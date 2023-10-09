package fpoly.hieudtph35761.duanmau.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fpoly.hieudtph35761.duanmau.R;

public class sachViewHolder extends RecyclerView.ViewHolder {

    TextView tv_sc_maSach,tv_sc_tenSach,tv_sc_giaThue,tv_sc_maLoai;
    View mview;
    public sachViewHolder(@NonNull View itemView) {
        super(itemView);

        tv_sc_maSach = itemView.findViewById(R.id.tv_sach_maSach);
        tv_sc_tenSach = itemView.findViewById(R.id.tv_sach_tenSach);
        tv_sc_giaThue = itemView.findViewById(R.id.tv_sach_giaThue);
        tv_sc_maLoai = itemView.findViewById(R.id.tv_sach_maLoai);


        mview = itemView;
    }
}
