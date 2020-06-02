package com.milk.bread.bread_milk.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.milk.bread.bread_milk.R;
import com.milk.bread.bread_milk.adapter.CategoryAdapter;
import com.milk.bread.bread_milk.adapter.ProductsAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class All_milk extends Fragment {
    RecyclerView rcvProducts;
    List<Integer> products_list;
    ProductsAdapter productsAdapter;
    public All_milk() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_milk, container, false);


        rcvProducts = view.findViewById(R.id.rcvProducts);

        products_list = new ArrayList<>();


        products_list.add(R.drawable.milk);
        products_list.add(R.drawable.toned);


        rcvProducts.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        productsAdapter = new ProductsAdapter(getActivity(), products_list);
        rcvProducts.setAdapter(productsAdapter);
        // Inflate the layout for this fragment
        return view;
    }
}
