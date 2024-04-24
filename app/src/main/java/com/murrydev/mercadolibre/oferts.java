package com.murrydev.mercadolibre;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class oferts extends AppCompatActivity {

    List <ofertElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_oferts);
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

    public void cartViewbutton(View view){
        Intent cart = new Intent(this, cartpurchase.class);
        startActivity(cart);
    }
    public void init(){
        elements = new ArrayList<>();
        elements.add(new ofertElement("Todas las ofertas", "@drawable/icoutlinelocaloffer"));
        elements.add(new ofertElement("Ofertas relampago", "@drawable/lightblue"));
        elements.add(new ofertElement("Mobile y Smartwatches", "@drawable/celulcaricon"));
        elements.add(new ofertElement("Martes descuentos", "@drawable/sudaderaicon"));
        elements.add(new ofertElement("Ofertas celulares", "@drawable/icoutlinelocaloffer"));

        ofertAdapter ofertAdapter = new ofertAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.iconlistrecycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(ofertAdapter);

    }
}
