package com.murrydev.mercadolibre;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class productView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TypedArray barC = obtainStyledAttributes(new int[]{R.attr.barcolor});
        int barTint = barC.getColor(0, 0);
        barC.recycle();
        getWindow().setStatusBarColor(barTint);

        Intent intent = getIntent();
        byte[] imagenBytes = intent.getByteArrayExtra("imagend");
        Bitmap imagen = BitmapFactory.decodeByteArray(imagenBytes, 0, imagenBytes.length);
        float precio = intent.getFloatExtra("precio", 0.0f);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageBitmap(imagen);

        TextView precioTextView = findViewById(R.id.precio);
        precioTextView.setText(String.format(Locale.getDefault(), "$%.2f", precio));

        TextView titlePro = findViewById(R.id.titleProcut);
        String title = intent.getStringExtra("title");
        titlePro.setText(title);

        double msiNumber = precio / 12;
        String formattedMsi = String.format(Locale.getDefault(), "%.2f", msiNumber);

        TextView contmsi = findViewById(R.id.msi);
        String textorign = contmsi.getText().toString();
        String newmsi = textorign + formattedMsi;
        contmsi.setText(newmsi);

    }
}