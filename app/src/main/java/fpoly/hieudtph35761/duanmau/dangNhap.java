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

public class dangNhap extends AppCompatActivity {
    Button btn_dangNhap, btn_cancel;
    TextView btn_register, btn_forgotPassword;
    TextInputLayout textInputLayout;
    TextInputEditText edt_lg_username, edt_lg_password;

    DbHelper dbHelper;

    thuThuDAO thuthudao;
    CheckBox chk_remember_password;

    public void mipMap(){
        btn_register = findViewById(R.id.btn_register);
        btn_dangNhap = findViewById(R.id.btn_dang_nhap);
        btn_cancel = findViewById(R.id.btn_cancel);
        edt_lg_password = findViewById(R.id.edt_login_password);
        edt_lg_username = findViewById(R.id.edt_login_username);
        chk_remember_password = findViewById(R.id.chk_remember_password);
        btn_forgotPassword = findViewById(R.id.btn_forgotPassword);
        textInputLayout = findViewById(R.id.textInputLayout);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        mipMap();
        thuthudao = new thuThuDAO(this);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dangNhap.this, dangKy.class));

            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt_lg_username.setText("");
                edt_lg_password.setText("");
            }
        });
        btn_forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_dangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edt_lg_username.getText().toString();
                String pass = edt_lg_password.getText().toString();

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(dangNhap.this, "Can nhap du lieu", Toast.LENGTH_SHORT).show();
                }else{
                    boolean checkRemember = chk_remember_password.isChecked();
                    if (checkRemember==true){
                        SharedPreferences sharedPreferences = getSharedPreferences("TT", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("MATT", user);
                        editor.commit();

                    }
                    boolean checkmattpass = thuthudao.checkMattPass(user, pass);
                    if(checkmattpass == true){
                        Toast.makeText(dangNhap.this, "Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(dangNhap.this, manHinhChinh.class));
                        finish();
                    }else{
                        Toast.makeText(dangNhap.this, "nhap lai user or pass", Toast.LENGTH_SHORT).show();
                    }
             }
            }
        });
    }
}