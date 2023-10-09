package fpoly.hieudtph35761.duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import fpoly.hieudtph35761.duanmau.DAO.thuThuDAO;
import fpoly.hieudtph35761.duanmau.Database.DbHelper;

public class dangKy extends AppCompatActivity {

    TextInputEditText edt_dky_username, edt_dky_password, edt_dky_Repassword;
    DbHelper dbHelper;
    Button btn_dky;
    thuThuDAO thuthuDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        edt_dky_username = findViewById(R.id.edt_signup_User);
        edt_dky_password = findViewById(R.id.edt_signup_password);
        edt_dky_Repassword = findViewById(R.id.edt_signup_Repassword);
        btn_dky = findViewById(R.id.btn_dangky);

        thuthuDAO = new thuThuDAO(this);
        btn_dky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edt_dky_username.getText().toString();
                String pass = edt_dky_password.getText().toString();
                String Repass = edt_dky_Repassword.getText().toString();

                if (user.equals("")||pass.equals("")||Repass.equals("")){
                    Toast.makeText(dangKy.this, "Can nhap du lieu", Toast.LENGTH_SHORT).show();
                }else{
                    if (pass.equals(Repass)){
                        boolean checkuser = thuthuDAO.checkMatt(user);
                        if (checkuser == false){
                            boolean insert = thuthuDAO.insertData(user, pass);
                            if (insert==true){
                                Toast.makeText(dangKy.this, "successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(dangKy.this, dangNhap.class));
                                finish();
                            }else{
                                Toast.makeText(dangKy.this, "failed !", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(dangKy.this, "tai khoan da ton tai", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(dangKy.this, "mat khau nhap lai sai", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}