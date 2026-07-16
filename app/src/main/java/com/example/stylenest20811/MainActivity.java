package com.example.stylenest20811;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;
    private ImageButton cartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        cartButton = findViewById(R.id.cartButton);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        productList = new ArrayList<>();
        loadProducts();

        productAdapter = new ProductAdapter(productList);
        recyclerView.setAdapter(productAdapter);

        cartButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }

    private void loadProducts() {
        String desc = "This is a premium fashion item from our latest collection.";
        productList.add(new Product("Classic T-Shirt", "$25.00", R.mipmap.ic_launcher, desc));
        productList.add(new Product("Denim Jacket", "$85.00", R.mipmap.ic_launcher, desc));
        productList.add(new Product("Slim Fit Jeans", "$45.00", R.mipmap.ic_launcher, desc));
        productList.add(new Product("Leather Boots", "$120.00", R.mipmap.ic_launcher, desc));
        productList.add(new Product("Woolen Scarf", "$15.00", R.mipmap.ic_launcher, desc));
        productList.add(new Product("Cotton Hoodie", "$55.00", R.mipmap.ic_launcher, desc));
        productList.add(new Product("Silk Dress", "$150.00", R.mipmap.ic_launcher, desc));
        productList.add(new Product("Sports Watch", "$200.00", R.mipmap.ic_launcher, desc));
    }
}
