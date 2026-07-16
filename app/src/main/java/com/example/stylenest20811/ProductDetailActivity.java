package com.example.stylenest20811;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ImageView detailImage = findViewById(R.id.detailImage);
        TextView detailName = findViewById(R.id.detailName);
        TextView detailPrice = findViewById(R.id.detailPrice);
        TextView detailDescription = findViewById(R.id.detailDescription);
        MaterialButton addToCartButton = findViewById(R.id.addToCartButton);
        MaterialButton viewCartButton = findViewById(R.id.viewCartButton);

        String name = getIntent().getStringExtra("name");
        String price = getIntent().getStringExtra("price");
        String description = getIntent().getStringExtra("description");
        int image = getIntent().getIntExtra("image", R.mipmap.ic_launcher);

        detailName.setText(name);
        detailPrice.setText(price);
        detailDescription.setText(description);
        detailImage.setImageResource(image);

        addToCartButton.setOnClickListener(v -> {
            CartManager.getInstance().addProduct(new Product(name, price, image, description));
            Toast.makeText(this, name + " added to cart", Toast.LENGTH_SHORT).show();
        });

        viewCartButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
        });
    }
}
