package com.example.manhinhungdung;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText edtEmail123, edtPassword123;
    private MaterialButton btnLogin123;
    private CheckBox chkRemember123;
    private TextView tvRegister123, tvForgot123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // dùng layout activity_login.xml

        edtEmail123 = findViewById(R.id.edtEmail);
        edtPassword123 = findViewById(R.id.edtPassword);
        btnLogin123 = findViewById(R.id.btnLogin);
        chkRemember123 = findViewById(R.id.chkRemember);
        tvRegister123 = findViewById(R.id.tvRegister);
        tvForgot123 = findViewById(R.id.tvForgot);

        btnLogin123.setOnClickListener(v -> attemptLogin123());

        tvRegister123.setOnClickListener(v -> startActivity(new Intent(this, RegisterActivity.class)));
        tvForgot123.setOnClickListener(v -> {
            // mở màn hình quên mật khẩu nếu có
        });
    }

    private void attemptLogin123() {
        String account123 = edtEmail123.getText() != null ? edtEmail123.getText().toString().trim() : "";
        String password123 = edtPassword123.getText() != null ? edtPassword123.getText().toString() : "";

        if (TextUtils.isEmpty(account123)) {
            edtEmail123.setError("Vui lòng nhập Email hoặc SĐT");
            return;
        }
        if (TextUtils.isEmpty(password123)) {
            edtPassword123.setError("Vui lòng nhập mật khẩu");
            return;
        }
        String password = edtPassword123.getText().toString().trim();
        // demo: mật khẩu "123456" là hợp lệ
        if ("123456".equals(password123)) {
            Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            finish();
        } else {
            edtPassword123.setError("Email/SĐT hoặc mật khẩu không đúng");
        }
    }
}
