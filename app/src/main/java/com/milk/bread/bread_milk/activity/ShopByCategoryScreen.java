package com.milk.bread.bread_milk.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.milk.bread.bread_milk.R;
import com.milk.bread.bread_milk.adapter.CategoryAdapter;
import com.milk.bread.bread_milk.fragment.CategoryFragment;

import java.util.ArrayList;
import java.util.List;

import me.ibrahimsn.lib.SmoothBottomBar;

public class ShopByCategoryScreen extends AppCompatActivity {
   // SmoothBottomBar bottomBar;
    ImageView backbutton;
    Fragment fragment;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_screen);

      //  bottomBar = findViewById(R.id.bottomBar);
        backbutton = findViewById(R.id.backbutton);
//        bottomBar.setVisibility(View.GONE);
      //  menu.setVisibility(View.GONE);

        fragment = new CategoryFragment();
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
