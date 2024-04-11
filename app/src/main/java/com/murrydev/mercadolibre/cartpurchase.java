package com.murrydev.mercadolibre;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class cartpurchase extends AppCompatActivity {
    List<liselement> elements;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cartpurchase);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TypedArray barC = obtainStyledAttributes(new int[]{R.attr.barcolor});
        int barTint = barC.getColor(0, 0);
        barC.recycle();
        getWindow().setStatusBarColor(barTint);

        init();
    }
    public  void backHome(View view){
        onBackPressed();
    }

    public  void init(){
        elements = new ArrayList<>();
        elements.add(new liselement("Visto recientemente","Motherboard","$40000","@drawable/moderboard"));
        elements.add(new liselement("Te podria interesar","Motherboard","$40000","@drawable/moderboard"));
        elements.add(new liselement("Lo quieres","Motherboard","$40000","@drawable/moderboard"));
        elements.add(new liselement("LLevate tu favorito","Motherboard","$40000","@drawable/moderboard"));

        listAdapterCard listAdapter = new listAdapterCard(elements, this);
        RecyclerView recyclerView = findViewById(R.id.interesting);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(listAdapter);
    }
}