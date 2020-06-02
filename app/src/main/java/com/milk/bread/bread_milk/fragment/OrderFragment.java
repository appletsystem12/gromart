package com.milk.bread.bread_milk.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.milk.bread.bread_milk.R;
import com.milk.bread.bread_milk.activity.CartScreen;
import com.milk.bread.bread_milk.adapter.CartAdapter;
import com.milk.bread.bread_milk.adapter.OrderAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class OrderFragment extends Fragment {

    RecyclerView rvOrder;
    List<Integer>  order_list;
    OrderAdapter orderAdapter;
    TextView tv_date;
    RelativeLayout rl_calendar;
    final Calendar myCalendar = Calendar.getInstance();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);


        rvOrder= view.findViewById(R.id.rvOrder);
        rl_calendar= view.findViewById(R.id.rl_calendar);
        tv_date= view.findViewById(R.id.tv_date);
        order_list = new ArrayList<>();

        order_list.add(R.drawable.toned);
        order_list.add(R.drawable.milk);

        rvOrder.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        orderAdapter = new OrderAdapter(getActivity(), order_list);
        rvOrder.setAdapter(orderAdapter);

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        rl_calendar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        Date c = Calendar.getInstance().getTime();
        Log.d("TAG", "onCreateView: Current time => "+ c);
    //    ("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd MMM");
        String formattedDate = df.format(c);
        tv_date.setText(formattedDate);
        return  view;
    }

    private void updateLabel() {
        String myFormat = "dd MMM"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        tv_date.setText(sdf.format(myCalendar.getTime()));
    }
}
