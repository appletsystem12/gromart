package com.milk.bread.bread_milk.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.milk.bread.bread_milk.R;
import com.milk.bread.bread_milk.adapter.CategoryAdapter;
import com.milk.bread.bread_milk.adapter.NewestProductAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button milk,promo,selling,fruit,product,vegetable,food,cabbage,brocolli,carrot,potato,rice,salad;
    ViewFlipper vflipper;
    ImageView slide1,slide2,ivCloseDrawer;
    RecyclerView  rcvProduct,rcvCategories;
   // private ArrayList<HashMap<String, String>> product_list;
    List<Integer> product_list , category_list;
    private NewestProductAdapter newestProductAdapter;
    private CategoryAdapter categoryAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        vflipper=view.findViewById(R.id.v_flipper);// to make it move able
        slide1=view.findViewById(R.id.slide1); // slide 1
        slide2=view.findViewById(R.id.slide2);// slide 2
   /*     promo=view.findViewById(R.id.promo);
        selling=view.findViewById(R.id.selling);
        fruit=view.findViewById(R.id.fruits);
        product=view.findViewById(R.id.newpdt);
        vegetable=view.findViewById(R.id.vegetables);
        food=view.findViewById(R.id.fastfood);
        cabbage=view.findViewById(R.id.Cabbage);
        carrot=view.findViewById(R.id.Carrot);
        brocolli=view.findViewById(R.id.broccoli);
        salad=view.findViewById(R.id.Salad);
        potato=view.findViewById(R.id.Potato);
        rice=view.findVie'wById(R.id.Rice);
        milk=view.findViewById(R.id.milk);*/
        rcvProduct=view.findViewById(R.id.rcvProduct);
        rcvCategories=view.findViewById(R.id.rcvCategories);

        product_list = new ArrayList<>();
        category_list = new ArrayList<>();

        product_list.add(R.drawable.bestpromo);
        product_list.add(R.drawable.bestselling);
        product_list.add(R.drawable.fruit);
        product_list.add(R.drawable.newproduct);
        product_list.add(R.drawable.vegetables);
        product_list.add(R.drawable.fastfood);


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

        rcvProduct.setNestedScrollingEnabled(false);
        rcvCategories.setNestedScrollingEnabled(false);


        rcvProduct.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        newestProductAdapter = new NewestProductAdapter(getActivity(), product_list);
        rcvProduct.setAdapter(newestProductAdapter);

       // rcvCategories.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rcvCategories.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        categoryAdapter = new CategoryAdapter(getActivity(), category_list);
        rcvCategories.setAdapter(categoryAdapter);

        return view;

    }

    @Override
    public void onClick(View v) {

    }
}
