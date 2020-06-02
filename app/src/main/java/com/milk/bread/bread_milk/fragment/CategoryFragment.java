package com.milk.bread.bread_milk.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.milk.bread.bread_milk.R;
import com.milk.bread.bread_milk.activity.ShopByCategoryScreen;
import com.milk.bread.bread_milk.adapter.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {
    RecyclerView rcvCategories;
    private CategoryAdapter categoryAdapter;
    List<Integer> category_list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);


        rcvCategories=view.findViewById(R.id.rcvCategories);
      //  rcvCategories.setNestedScrollingEnabled(false);

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


   //     RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
        rcvCategories.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        categoryAdapter = new CategoryAdapter(getActivity(), category_list);
        rcvCategories.setAdapter(categoryAdapter);
        return view;
    }
}
