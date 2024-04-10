package com.murrydev.mercadolibre;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        SearchView searchView = findViewById(R.id.searchView);
       /* searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        */

        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerIcons);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("https://http2.mlstatic.com/storage/homes-korriban/assets/images/quick_access/home_row_mercado_pago_carousel_mobile.webp");
        arrayList.add("https://http2.mlstatic.com/storage/homes-korriban/assets/images/quick_access/home_row_ofertas_carousel_mobile.webp");
        arrayList.add("https://http2.mlstatic.com/storage/homes-korriban/assets/images/quick_access/home_row_supermercado_carousel_mobile.webp");
        arrayList.add("https://http2.mlstatic.com/storage/homes-korriban/assets/images/quick_access/home_row_mercado_pago_carousel_mobile.webp");
        arrayList.add("https://http2.mlstatic.com/storage/homes-korriban/assets/images/quick_access/home_row_ofertas_carousel_mobile.webp");
        arrayList.add("https://http2.mlstatic.com/storage/homes-korriban/assets/images/quick_access/home_row_supermercado_carousel_mobile.webp");
        arrayList.add("https://http2.mlstatic.com/storage/homes-korriban/assets/images/quick_access/home_row_mercado_pago_carousel_mobile.webp");
        arrayList.add("https://http2.mlstatic.com/storage/homes-korriban/assets/images/quick_access/home_row_ofertas_carousel_mobile.webp");
        arrayList.add("https://http2.mlstatic.com/storage/homes-korriban/assets/images/quick_access/home_row_supermercado_carousel_mobile.webp");

        imageAdapter adapter = new imageAdapter(MainActivity.this, arrayList);
        adapter.setOnItemClickListener(new imageAdapter.OnItemClickListener() {
            @Override
            public void onClick(ImageView imageView, String url) {
                startActivity(new Intent(MainActivity.this, ImageViewActivity.class).putExtra("image", url), ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, imageView, "image").toBundle());
            }
        });
        recyclerView.setAdapter(adapter);
    }
}