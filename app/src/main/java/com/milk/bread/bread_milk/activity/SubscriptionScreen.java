package com.milk.bread.bread_milk.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.milk.bread.bread_milk.R;
import com.milk.bread.bread_milk.adapter.CartAdapter;
import com.milk.bread.bread_milk.adapter.SubscriptionAdapter;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionScreen extends AppCompatActivity {

    RecyclerView rvSubscription;
    private SubscriptionAdapter subscriptionAdapter;
    List<Integer> subscription_list;
    ImageView backbutton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subscription_screen);

        rvSubscription= findViewById(R.id.rvSubscription);
        backbutton= findViewById(R.id.backbutton);
        //  rcvCategories.setNestedScrollingEnabled(false);

        subscription_list = new ArrayList<>();

       /* subscription_list.add(R.drawable.milks);
        subscription_list.add(R.drawable.vegetable);*/
        subscription_list.add(R.drawable.toned);
        subscription_list.add(R.drawable.milk);


        rvSubscription.setLayoutManager(new LinearLayoutManager(SubscriptionScreen.this, LinearLayoutManager.VERTICAL, false));
        subscriptionAdapter = new SubscriptionAdapter(SubscriptionScreen.this, subscription_list);
        rvSubscription.setAdapter(subscriptionAdapter);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
