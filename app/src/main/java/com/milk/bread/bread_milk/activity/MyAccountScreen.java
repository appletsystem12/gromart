package com.milk.bread.bread_milk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.milk.bread.bread_milk.R;

public class MyAccountScreen extends AppCompatActivity {
    ImageView backbutton;
    TextView tv_edit;
    RelativeLayout rl_wallet,rl_orders,rl_subscription;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        tv_edit = findViewById(R.id.tv_edit);
        backbutton = findViewById(R.id.backbutton);
        rl_wallet = findViewById(R.id.rl_wallet);
        rl_orders = findViewById(R.id.rl_orders);
        rl_subscription = findViewById(R.id.rl_subscription);

        tv_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyAccountScreen.this, EditAccount.class);
                startActivity(intent);
            }
        });

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rl_subscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyAccountScreen.this, SubscriptionScreen.class);
                startActivity(intent);
            }
        });

        rl_orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyAccountScreen.this, OrderScreen.class);
                startActivity(intent);
            }
        });

        rl_wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyAccountScreen.this, WalletScreen.class);
                startActivity(intent);
            }
        });

    }
}
