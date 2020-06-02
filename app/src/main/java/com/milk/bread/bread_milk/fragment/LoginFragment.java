package com.milk.bread.bread_milk.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.milk.bread.bread_milk.R;
import com.milk.bread.bread_milk.activity.HomeScreen;
import com.milk.bread.bread_milk.activity.LoginActivity;
import com.milk.bread.bread_milk.activity.RegistrationScreen;

import java.util.Objects;

public class LoginFragment extends Fragment {

    TextView tv_login,tv_text;
    RelativeLayout rl_otp,rl_mobile,rl_logo,rl_login,rl_down;
    RelativeLayout rl_main_layout;
    ImageView iv_logo;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_login, container, false);

        tv_login = view.findViewById(R.id.tv_login);
        tv_text = view.findViewById(R.id.tv_text);
        rl_otp = view.findViewById(R.id.rl_otp);
        rl_mobile = view.findViewById(R.id.rl_mobile);
        rl_main_layout = view.findViewById(R.id.rl_main_layout);
        rl_logo = view.findViewById(R.id.rl_logo);
        iv_logo = view.findViewById(R.id.iv_logo);
        rl_login = view.findViewById(R.id.rl_login);
        rl_down = view.findViewById(R.id.rl_down);

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomeScreen.class);
                startActivity(intent);
            }
        });

        rl_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(LoginActivity.this,RegistrationScreen.class);
                startActivity(intent);*/
/*
                startActivity(new Intent(getActivity(), RegistrationScreen.class));
                overridePendingTransition(R.anim.slide_in_bottom, R.anim.no_animation);*/

                Fragment fragment2 = new RegistrationFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, fragment2);
                fragmentTransaction.commit();
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_bottom, R.anim.no_animation);
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

        tv_text.setText(String.valueOf(screenInches));
        if(screenInches >= 5.5){
           /* logo_iv_placement();
            mobile_rl_placement();
            otp_rl_placement();
            login_tv_placement();*/
            main_rl_placement();
        }

    }

 /*   public void logo_iv_placement(){

        RelativeLayout imageLayout = new RelativeLayout(this);

        ImageView imageview = new ImageView(this);
        //  imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageview.setImageResource(R.drawable.sampl_logo);


        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, dpToPx(180));
        if(iv_logo.getParent() != null) {
            ((ViewGroup)iv_logo.getParent()).removeView(iv_logo); // <- fix
        }
        imageLayout.addView(iv_logo, lp);

    }
    public void mobile_rl_placement(){

        RelativeLayout rl = new RelativeLayout(this);
        RelativeLayout.LayoutParams rl_layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        rl_layoutParams.setMargins(0, dpToPx(25), 0, 0);
        rl_mobile.setLayoutParams(rl_layoutParams);
    }
    public void otp_rl_placement(){

        RelativeLayout rl = new RelativeLayout(this);
        RelativeLayout.LayoutParams rl_layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        rl_layoutParams.setMargins(0, dpToPx(25), 0, 0);
        rl_otp.setLayoutParams(rl_layoutParams);
        // rl_otp
    }
    public void login_tv_placement(){

        RelativeLayout rl = new RelativeLayout(this);
        RelativeLayout.LayoutParams rl_layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        rl_layoutParams.setMargins(0, dpToPx(80), 0, 0);
        rl_login.setLayoutParams(rl_layoutParams);


       *//* TextView tv = new TextView(this);
        final ViewGroup.MarginLayoutParams lpt =(ViewGroup.MarginLayoutParams)tv.getLayoutParams();
        lpt.setMargins(0,dpToPx(40),0,0);

        rl_login.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));*//*
    }*/

    public void main_rl_placement(){


        RelativeLayout rl = new RelativeLayout(getActivity());
        RelativeLayout.LayoutParams rl_layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);


        rl_layoutParams.setMargins(dpToPx(50),dpToPx(100),dpToPx(50),dpToPx(50)); //ltrb
        rl_main_layout.setLayoutParams(rl_layoutParams);


    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }
}
