package fpoly.hieudtph35761.duanmau.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fpoly.hieudtph35761.duanmau.R;

public class thanhVienViewHolder extends RecyclerView.ViewHolder {
    TextView tv_tv_matv,tv_tv_hoTen,tv_tv_namSinh;
    View mview;
    public thanhVienViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_tv_matv = itemView.findViewById(R.id.tv_thanhVien_matv);
        tv_tv_hoTen = itemView.findViewById(R.id.tv_thanhVien_hoTen);
        tv_tv_namSinh = itemView.findViewById(R.id.tv_thanhVien_namSinh);

        mview = itemView;
    }
}
