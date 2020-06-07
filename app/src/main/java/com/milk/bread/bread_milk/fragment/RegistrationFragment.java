package com.milk.bread.bread_milk.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.milk.bread.bread_milk.R;
import com.milk.bread.bread_milk.activity.LoginActivity;
import java.util.Objects;

public class RegistrationFragment extends Fragment {

    RelativeLayout rl_up;
    RelativeLayout rl_main_layout;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_registration, container, false);

        rl_up = view.findViewById(R.id.rl_up);
        rl_main_layout = view.findViewById(R.id.rl_main_layout);



        rl_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Fragment fragment2 = new LoginFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, fragment2);
                fragmentTransaction.commit();
                fragmentTransaction.setCustomAnimations(R.anim.slide_out_bottom, R.anim.no_animation);
            }
        });

        getScreenSize();
        return view;

    }

    public void getScreenSize(){

        DisplayMetrics dm = new DisplayMetrics();
        Objects.requireNonNull(getActivity()).getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width=dm.widthPixels;
        int height=dm.heightPixels;
        double wi=(double)width/(double)dm.xdpi;
        double hi=(double)height/(double)dm.ydpi;
        double x = Math.pow(wi,2);
        double y = Math.pow(hi,2);
        double screenInches = Math.sqrt(x+y);

      //  tv_text.setText(String.valueOf(screenInches));
        if(screenInches >= 5.5){
           /* logo_iv_placement();
            mobile_rl_placement();
            otp_rl_placement();
            login_tv_placement();*/
            main_rl_placement();
        }

    }

    public void main_rl_placement(){


        RelativeLayout rl = new RelativeLayout(getActivity());
        RelativeLayout.LayoutParams rl_layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);


        rl_layoutParams.setMargins(dpToPx(50),dpToPx(150),dpToPx(50),dpToPx(100)); //ltrb
        rl_main_layout.setLayoutParams(rl_layoutParams);
        rl_main_layout.setGravity(RelativeLayout.CENTER_IN_PARENT);


    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

}
