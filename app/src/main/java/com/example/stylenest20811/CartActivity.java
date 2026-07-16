package com.example.stylenest20811;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView totalPriceText;
    private MaterialButton checkoutButton;
    private CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.cartRecyclerView);
        totalPriceText = findViewById(R.id.totalPriceText);
        checkoutButton = findViewById(R.id.checkoutButton);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        List<Product> items = CartManager.getInstance().getCartItems();
        cartAdapter = new CartAdapter(items, this::updateTotal);
        recyclerView.setAdapter(cartAdapter);

        updateTotal();

        checkoutButton.setOnClickListener(v -> {
            if (items.isEmpty()) {
                Toast.makeText(this, R.string.cart_empty, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, R.string.order_placed, Toast.LENGTH_LONG).show();
                CartManager.getInstance().clearCart();
                finish();
            }
        });
    }

    private void updateTotal() {
        double total = CartManager.getInstance().getTotalPrice();
        totalPriceText.setText(String.format("$%.2f", total));
    }
}
