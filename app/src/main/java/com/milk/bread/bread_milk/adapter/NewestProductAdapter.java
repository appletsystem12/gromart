package com.milk.bread.bread_milk.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.milk.bread.bread_milk.R;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NewestProductAdapter extends RecyclerView.Adapter<NewestProductAdapter.ViewHolder> {



    private LayoutInflater mInflater;
    Context context;
    List<Integer> product_list;
         //   ArrayList<HashMap<String,String>> arr_category;
       //     GlobalClass globalClass;
  /*  private final Integer[] category_img = new Integer[]{
            R.drawable.cereals,
            R.drawable.pulses_beans,
            R.drawable.spices,
            R.drawable.tea_coffee,
            R.drawable.dry_fruits

    };*/


    public NewestProductAdapter(Context c, List<Integer> product_list) {
            this.mInflater = LayoutInflater.from(c);
            context = c;
            this.product_list = product_list;

        //    globalClass = (GlobalClass)context.getApplicationContext();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.grid_item_product, parent, false);
            return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

          //  String name = arr_category.get(position).get("p_name");
         //   holder.tvProductName.setText(name);


            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher_round);


        Glide.with(context).load(product_list.get(position)).apply(options).into(holder.ivProduct);


   /*     assert name != null;
        switch (name) {
            case "CEREALS":

                Glide.with(context).load(R.drawable.cereals).apply(options).into(holder.ivProduct);
                break;
            case "PULSES & BEANS":

                Glide.with(context).load(R.drawable.pulses_beans).apply(options).into(holder.ivProduct);
                break;
            case "SPICES":
            case "CONDIMENTS":
                Glide.with(context).load(R.drawable.spices).apply(options).into(holder.ivProduct);

                break;
            case "Tea coffee & Jaggery and Others":
                Glide.with(context).load(R.drawable.tea_coffee).apply(options).into(holder.ivProduct);

                break;
            case "Dry Fruits":
                Glide.with(context).load(R.drawable.dry_fruits).apply(options).into(holder.ivProduct);

                break;

            case "Edible Oils & Ghee":
                Glide.with(context).load(R.drawable.oil).apply(options).into(holder.ivProduct);

                break;
        }*/

    }

    @Override
    public int getItemCount() {
            return product_list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        ImageView ivProduct;
        TextView tvProductName;


        ViewHolder(View itemView) {
            super(itemView);

            ivProduct = itemView.findViewById(R.id.ivProduct);
        //    tvProductName = itemView.findViewById(R.id.tvProductName);

        }


    }


}