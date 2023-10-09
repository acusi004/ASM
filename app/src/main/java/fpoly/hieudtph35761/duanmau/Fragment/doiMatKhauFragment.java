package fpoly.hieudtph35761.duanmau.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import fpoly.hieudtph35761.duanmau.DAO.thuThuDAO;
import fpoly.hieudtph35761.duanmau.R;


public class doiMatKhauFragment extends Fragment {

    TextInputEditText edt_rs_Re_password,edt_rs_Old_password, edt_rs_New_password;
    Button btn_rs_Submit;

    thuThuDAO ttDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doi_mat_khau, container, false);
        edt_rs_Old_password = view.findViewById(R.id.edt_rs_Old_password);
        edt_rs_New_password = view.findViewById(R.id.edt_rs_New_password);
        edt_rs_Re_password = view.findViewById(R.id.edt_rs_Re_password);
        btn_rs_Submit = view.findViewById(R.id.btn_rs_submit);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_rs_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String old_password = edt_rs_Old_password.getText().toString();
                String new_password = edt_rs_New_password.getText().toString();
                String Re_password = edt_rs_Re_password.getText().toString();

                if (old_password.equals("")||new_password.equals("")||Re_password.equals("")){
                Toast.makeText(getContext(), "Can nhap du lieu !", Toast.LENGTH_SHORT).show();
                }else{
                    if(new_password.equals(Re_password)){
                        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("TT", Context.MODE_PRIVATE);
                        String matt = sharedPreferences.getString("MATT","");
                        ttDAO = new thuThuDAO(getContext());
                        boolean check = ttDAO.updatePassword(matt, old_password, new_password);
                        if (check){
                            Toast.makeText(getContext(), "cap nhap mat khau thanh cong", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getContext(), "cap nhat thai bai ", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getContext(), "mat khau nhap lai sai", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}