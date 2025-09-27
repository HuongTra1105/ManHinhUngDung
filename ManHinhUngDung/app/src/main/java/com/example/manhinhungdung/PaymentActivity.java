package com.example.manhinhungdung;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {

    private TextView tvMovieInfo123, tvTotalPrice123;
    private RadioGroup radioGroupPayment123;
    private Button btnConfirmPayment123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment); // activity_payment.xml

        tvMovieInfo123 = findViewById(R.id.tvMovieInfo);
        tvTotalPrice123 = findViewById(R.id.tvTotalPrice);
        radioGroupPayment123 = findViewById(R.id.radioGroupPayment);
        btnConfirmPayment123 = findViewById(R.id.btnConfirmPayment);

        String seats123 = getIntent().getStringExtra("seats");
        int total123 = getIntent().getIntExtra("total", 0);
        tvMovieInfo123.setText("Ghế: " + seats123);
        tvTotalPrice123.setText("Tổng tiền: " + total123 + "đ");

        btnConfirmPayment123.setOnClickListener(v -> {
            int id123 = radioGroupPayment123.getCheckedRadioButtonId();
            if (id123 == -1) {
                Toast.makeText(this, "Vui lòng chọn phương thức thanh toán!", Toast.LENGTH_SHORT).show();
                return;
            }
            RadioButton rb123 = findViewById(id123);
            String method123 = rb123.getText().toString();

            // TODO: tích hợp payment SDK tùy phương thức
            Intent intent123 = new Intent(this, TicketActivity.class);
            intent123.putExtra("seats", seats123);
            intent123.putExtra("total", total123);
            intent123.putExtra("paymentMethod", method123);
            startActivity(intent123);
        });
    }
}
