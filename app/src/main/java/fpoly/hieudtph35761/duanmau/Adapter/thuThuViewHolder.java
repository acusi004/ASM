package fpoly.hieudtph35761.duanmau.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fpoly.hieudtph35761.duanmau.R;

public class thuThuViewHolder extends RecyclerView.ViewHolder {

    TextView tv_tt_matt,tv_tt_hoTen,tv_tt_password;
    View mview;
    public thuThuViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_tt_matt = itemView.findViewById(R.id.tv_thuthu_matt);
        tv_tt_hoTen = itemView.findViewById(R.id.tv_thuthu_hoTen);
        tv_tt_password = itemView.findViewById(R.id.tv_thuthu_Password);
        mview = itemView;
    }
}
