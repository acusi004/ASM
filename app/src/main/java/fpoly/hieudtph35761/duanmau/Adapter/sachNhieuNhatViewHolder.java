package fpoly.hieudtph35761.duanmau.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fpoly.hieudtph35761.duanmau.R;

public class sachNhieuNhatViewHolder extends RecyclerView.ViewHolder {

    TextView tv_top10_maSach,tv_top10_tenSach,tv_top10_nhieuNhat;
    public sachNhieuNhatViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_top10_maSach = itemView.findViewById(R.id.tv_top10_maSach);
        tv_top10_tenSach = itemView.findViewById(R.id.tv_top10_tenSach);
        tv_top10_nhieuNhat = itemView.findViewById(R.id.tv_top10_soLuongMuon);
    }
}
