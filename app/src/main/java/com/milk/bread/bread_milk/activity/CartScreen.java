package com.milk.bread.bread_milk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.milk.bread.bread_milk.R;
import com.milk.bread.bread_milk.adapter.CartAdapter;

import java.util.ArrayList;
import java.util.List;

public class CartScreen extends AppCompatActivity {

    ImageView backbutton;
    List<Integer> cart_list;
    RecyclerView rvCart;
    CartAdapter cartAdapter;
    TextView tvContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        backbutton = findViewById(R.id.backbutton);
        tvContinue = findViewById(R.id.tvContinue);
        rvCart = findViewById(R.id.rcvCart);

        cart_list = new ArrayList<>();
        cart_list.add(R.drawable.toned);
        cart_list.add(R.drawable.milk);

        rvCart.setLayoutManager(new LinearLayoutManager(CartScreen.this, LinearLayoutManager.VERTICAL, false));
        cartAdapter = new CartAdapter(CartScreen.this, cart_list);
        rvCart.setAdapter(cartAdapter);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartScreen.this,DeliveryScreen.class);
                startActivity(intent);
            }
        });
    }
}
