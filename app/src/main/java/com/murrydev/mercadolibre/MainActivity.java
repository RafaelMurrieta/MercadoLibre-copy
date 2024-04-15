package com.murrydev.mercadolibre;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<liselement> elements;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        SearchView searchView = findViewById(R.id.searchView);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TypedArray barC = obtainStyledAttributes(new int[]{R.attr.barcolor});
        int barTint = barC.getColor(0, 0);
        barC.recycle();
        getWindow().setStatusBarColor(barTint);

        RecyclerView recyclerView = findViewById(R.id.recyclerIcons);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("https://http2.mlstatic.com/storage/homes-korriban/assets/images/quick_access/home_row_mercado_pago_carousel_mobile.webp");
        arrayList.add("https://http2.mlstatic.com/storage/homes-korriban/assets/images/quick_access/home_row_ofertas_carousel_mobile.webp");
        arrayList.add("https://http2.mlstatic.com/storage/homes-korriban/assets/images/quick_access/home_row_supermercado_carousel_mobile.webp");
        arrayList.add("https://http2.mlstatic.com/storage/homes-korriban/assets/images/quick_access/home_row_celulares_carousel_mobile.webp");
        arrayList.add("https://http2.mlstatic.com/storage/homes-korriban/assets/images/quick_access/home_row_style_summer_carousel_mobile.webp");
        arrayList.add("https://http2.mlstatic.com/storage/homes-korriban/assets/images/quick_access/home_row_vehiculos_carousel_red2_mobile.webp");
        arrayList.add("https://http2.mlstatic.com/storage/homes-korriban/assets/images/quick_access/home_row_best_sellers_carousel_mobile.webp");
        arrayList.add("https://http2.mlstatic.com/storage/homes-korriban/assets/images/quick_access/home_row_computacion_carousel_mobile.webp");
        arrayList.add("https://http2.mlstatic.com/storage/homes-korriban/assets/images/quick_access/home_row_armchair_carousel_mobile.webp");

        imageAdapter adapter = new imageAdapter(MainActivity.this, arrayList);
        adapter.setOnItemClickListener(new imageAdapter.OnItemClickListener() {
            @Override
            public void onClick(ImageView imageView, String url) {
                startActivity(new Intent(MainActivity.this, ImageViewActivity.class).putExtra("image", url), ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, imageView, "image").toBundle());
            }
        });
        recyclerView.setAdapter(adapter);

        init();
    }

    public void cartView(View view){
        Intent cart = new Intent(this, cartpurchase.class);
        startActivity(cart);
    }

    public void direction(View view){
        Intent direct = new Intent(this, directions.class);
        startActivity(direct);
    }

    public  void init(){
        elements = new ArrayList<>();
        elements.add(new liselement("Visto recientemente","Kit de actualizacion Gamer AMD Ryzen 5 5600g + A520","$4,000","@drawable/moderboard"));
        elements.add(new liselement("Te podria interesar","Comodas pantunflas de gato","$109","@drawable/pantun"));
        elements.add(new liselement("Lo quieres","Cinturon coach Reversible Soble vista","$311","@drawable/cinto"));
        elements.add(new liselement("LLevate tu favorito","Motherboard","$40000","@drawable/moderboard"));

        listAdapterCard listAdapter = new listAdapterCard(elements, this);
        RecyclerView recyclerView = findViewById(R.id.recicleCards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(listAdapter);
    }

    public void productView(View view){
        ImageView imageView = findViewById(R.id.iconImage);
        Drawable imagenDraw = imageView.getDrawable();

        TextView precioTextView = findViewById(R.id.pricep);
        String precioString = precioTextView.getText().toString();
        precioString = precioString.replaceAll("[^\\d.]", "");
        float precio = Float.parseFloat(precioString);

        Bitmap bitmap = ((BitmapDrawable) imagenDraw).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] imagenBytes = stream.toByteArray();


        TextView titlep = findViewById(R.id.titlep);
        String titleptext = String.valueOf(titlep.getText());

        Intent productIntent = new Intent(this, productView.class);
        productIntent.putExtra("imagend", imagenBytes);
        productIntent.putExtra("precio", precio);

        productIntent.putExtra("title", titleptext);
        startActivity(productIntent);

    }

}