package com.example.manhinhungdung;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.manhinhungdung.MainActivity;
import com.example.manhinhungdung.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText edtName123, edtEmail123, edtPhone123, edtPassword123, edtConfirmPassword123;
    private MaterialButton btnRegister123;
    private android.widget.TextView tvLogin123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName123 = findViewById(R.id.edtName);
        edtEmail123 = findViewById(R.id.edtEmail);
        edtPhone123 = findViewById(R.id.edtPhone);
        edtPassword123 = findViewById(R.id.edtPassword);
        edtConfirmPassword123 = findViewById(R.id.edtConfirmPassword);
        btnRegister123 = findViewById(R.id.btnRegister);
        tvLogin123 = findViewById(R.id.tvLogin);

        btnRegister123.setOnClickListener(v -> attemptRegister123());
        tvLogin123.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }

    private void attemptRegister123() {
        String name123 = edtName123.getText() != null ? edtName123.getText().toString().trim() : "";
        String email123 = edtEmail123.getText() != null ? edtEmail123.getText().toString().trim() : "";
        String phone123 = edtPhone123.getText() != null ? edtPhone123.getText().toString().trim() : "";
        String pass123 = edtPassword123.getText() != null ? edtPassword123.getText().toString() : "";
        String confirm123 = edtConfirmPassword123.getText() != null ? edtConfirmPassword123.getText().toString() : "";

        if (TextUtils.isEmpty(name123)) { edtName123.setError("Vui lòng nhập họ tên"); return; }
        if (TextUtils.isEmpty(email123)) { edtEmail123.setError("Vui lòng nhập email"); return; }
        if (TextUtils.isEmpty(phone123)) { edtPhone123.setError("Vui lòng nhập số điện thoại"); return; }
        if (TextUtils.isEmpty(pass123)) { edtPassword123.setError("Vui lòng nhập mật khẩu"); return; }
        if (!pass123.equals(confirm123)) { edtConfirmPassword123.setError("Mật khẩu xác nhận không khớp"); return; }

        Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
