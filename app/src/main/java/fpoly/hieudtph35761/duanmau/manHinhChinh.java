package fpoly.hieudtph35761.duanmau;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import fpoly.hieudtph35761.duanmau.Fragment.doanhThu_Fragment;
import fpoly.hieudtph35761.duanmau.Fragment.doiMatKhauFragment;
import fpoly.hieudtph35761.duanmau.Fragment.loaiSach_Fragment;
import fpoly.hieudtph35761.duanmau.Fragment.phieuMuon_Fragment;
import fpoly.hieudtph35761.duanmau.Fragment.sachMuaNhieuNhatFragment;
import fpoly.hieudtph35761.duanmau.Fragment.sach_Fragment;
import fpoly.hieudtph35761.duanmau.Fragment.thanhVien_Fragment;

public class manHinhChinh extends AppCompatActivity {


    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    Fragment fragment;
    public  void mipMap(){
        drawerLayout = findViewById(R.id.drawewrLayout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh);

        mipMap();
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()==R.id.QuanLyDangXuat){
                    AlertDialog.Builder builder = new AlertDialog.Builder(manHinhChinh.this);
                    builder.setTitle("Thông báo");
                    builder.setIcon(R.drawable.baseline_warning_amber_24);
                    builder.setMessage("Bạn có chắc chắn muốn đăng xuất không?");
                    builder.setCancelable(false);

                    builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startActivity(new Intent(manHinhChinh.this, dangNhap.class));
                            finish();
                        }
                    });
                    builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.create();
                    builder.show();

                }else if(item.getItemId()==R.id.QuanLyDoanhThu){
                    toolbar.setTitle("Doanh thu");
                    fragment = new doanhThu_Fragment();
                }else if(item.getItemId()==R.id.QuanLyDoiMatKhau){
                    toolbar.setTitle("Doi mat khau");
                    fragment = new doiMatKhauFragment();
                }else if(item.getItemId()==R.id.QuanLySach){
                    toolbar.setTitle("Sach");
                    fragment = new sach_Fragment();
                }else if(item.getItemId()==R.id.QuanLyPhieuMuon){
                    toolbar.setTitle("phieu muon");
                    fragment = new phieuMuon_Fragment();
                }else if(item.getItemId()==R.id.QuanLySachNhieuNhat){
                    toolbar.setTitle("Top 10 sach mua nhieu nhat");
                    fragment = new sachMuaNhieuNhatFragment();
                }else if (item.getItemId()==R.id.QuanLyThanhVien){
                    toolbar.setTitle("Thanh vien");
                    fragment = new thanhVien_Fragment();
                }else if(item.getItemId()==R.id.QuanLyThemNguoiDung){
                    toolbar.setTitle("Nguoi dung");

                }else if(item.getItemId()==R.id.QuanLyLoaiSach){
                    toolbar.setTitle("Loai sach");
                    fragment = new loaiSach_Fragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();


                drawerLayout.close();
                return true;
            }
        });
    }
}