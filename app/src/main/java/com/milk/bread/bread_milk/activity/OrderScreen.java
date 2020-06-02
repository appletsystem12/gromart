package com.milk.bread.bread_milk.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.milk.bread.bread_milk.R;
import com.milk.bread.bread_milk.fragment.OrderFragment;
import com.milk.bread.bread_milk.fragment.WalletFragment;

public class OrderScreen extends AppCompatActivity {
   // SmoothBottomBar bottomBar;
    ImageView backbutton;
    Fragment fragment;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_screen);

      //  bottomBar = findViewById(R.id.bottomBar);
        backbutton = findViewById(R.id.backbutton);
//        bottomBar.setVisibility(View.GONE);
      //  menu.setVisibility(View.GONE);

        fragment = new OrderFragment();
        loadFragment(fragment);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, fragment);
        transaction.addToBackStack(null);
        // transaction.addToBackStack("home_frag");
        transaction.commit();
    }

}
