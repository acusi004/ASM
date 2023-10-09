package fpoly.hieudtph35761.duanmau.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fpoly.hieudtph35761.duanmau.R;

public class loaiSachViewHolder extends RecyclerView.ViewHolder{
    TextView tv_ls_maLoai,tv_ls_tenLoai;
    View mview;
    public loaiSachViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_ls_maLoai = itemView.findViewById(R.id.tv_ls_maLoai);
        tv_ls_tenLoai = itemView.findViewById(R.id.tv_ls_tenLoai);

        mview = itemView;
    }
}
