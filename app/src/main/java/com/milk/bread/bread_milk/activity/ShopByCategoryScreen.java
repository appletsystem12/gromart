package com.milk.bread.bread_milk.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.milk.bread.bread_milk.R;
import com.milk.bread.bread_milk.adapter.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;

import me.ibrahimsn.lib.SmoothBottomBar;

public class ShopByCategoryScreen extends AppCompatActivity {
   // SmoothBottomBar bottomBar;
    ImageView backbutton;
    RecyclerView rcvCategories;
    private CategoryAdapter categoryAdapter;
    List<Integer> category_list;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_screen);

      //  bottomBar = findViewById(R.id.bottomBar);
        backbutton = findViewById(R.id.backbutton);
//        bottomBar.setVisibility(View.GONE);
      //  menu.setVisibility(View.GONE);

        rcvCategories=findViewById(R.id.rcvCategories);
        rcvCategories.setNestedScrollingEnabled(false);

        category_list = new ArrayList<>();

        category_list.add(R.drawable.milks);
        category_list.add(R.drawable.vegetable);
        category_list.add(R.drawable.fruits);
        category_list.add(R.drawable.egg);
        category_list.add(R.drawable.beverages);
        category_list.add(R.drawable.snacks);
        category_list.add(R.drawable.foodgrain);
        category_list.add(R.drawable.pooja);
        category_list.add(R.drawable.baby);
        category_list.add(R.drawable.beauty);
        category_list.add(R.drawable.cleaning);
        category_list.add(R.drawable.petcare);

        rcvCategories.setLayoutManager(new GridLayoutManager(ShopByCategoryScreen.this, 3));
        categoryAdapter = new CategoryAdapter(ShopByCategoryScreen.this, category_list);
        rcvCategories.setAdapter(categoryAdapter);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
