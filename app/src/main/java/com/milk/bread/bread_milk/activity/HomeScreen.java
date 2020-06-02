package com.milk.bread.bread_milk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.milk.bread.bread_milk.fragment.CategoryFragment;
import com.milk.bread.bread_milk.fragment.HomeFragment;
import com.milk.bread.bread_milk.R;
import com.milk.bread.bread_milk.fragment.OrderFragment;
import com.milk.bread.bread_milk.fragment.WalletFragment;

import it.sephiroth.android.library.bottomnavigation.BottomNavigation;
import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class HomeScreen extends AppCompatActivity implements BottomNavigation.OnMenuItemSelectionListener{
    ImageView ivCloseDrawer;
    TextView tvHome;
    String TAG="main";
    RelativeLayout rl_slide_layout;
    LinearLayout llLeftDrawer;
    ImageButton cart,menu,account;
    private ImageSwitcher sw;
    Fragment fragment;
    Button milk,promo,selling,fruit,product,vegetable,food,cabbage,brocolli,carrot,potato,rice,salad;
    ViewFlipper vflipper;
    ImageView slide1,slide2;
    TextView tvVegetables;
    LinearLayout ll_list_vegetable;

  //  SmoothBottomBar bottomBar;
    BottomNavigation bottomNavigation;
    LinearLayout ll_logout,ll_share,ll_refer,ll_help,ll_category,ll_subscription,ll_account;
    Animation slideout;
    boolean doubleBackToExitPressedOnce = false;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        ivCloseDrawer = findViewById(R.id.ivCloseDrawer);
       // bottomBar = findViewById(R.id.bottomBar);
        bottomNavigation = findViewById(R.id.bottomNavigation);
        account = findViewById(R.id.account);
        cart = findViewById(R.id.cart);



        menu=findViewById(R.id.menu);

        llLeftDrawer=findViewById(R.id.llLeftDrawer);
        tvHome=findViewById(R.id.tvHome);

        ll_logout  =findViewById(R.id.ll_logout);
        ll_share   =findViewById(R.id.ll_share);
        ll_refer=findViewById(R.id.ll_refer);
        ll_help=findViewById(R.id.ll_help);
        ll_category=findViewById(R.id.ll_category);
        ll_subscription=findViewById(R.id.ll_subscription);
        ll_account=findViewById(R.id.ll_account);


        llLeftDrawer.setVisibility(View.GONE);

    //    bottomNavigation.onItemClick(this);

        slideout = AnimationUtils.loadAnimation(HomeScreen.this, R.anim.slide_out);

        fragment = new HomeFragment();
        loadFragment(fragment);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation RightSwipe = AnimationUtils.loadAnimation(HomeScreen.this, R.anim.anim_slide_in_right);
                llLeftDrawer.startAnimation(RightSwipe);
                llLeftDrawer.setVisibility(View.VISIBLE);
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this,MyAccountScreen.class);
                startActivity(intent);

            }
        });


        ivCloseDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                llLeftDrawer.startAnimation(slideout);
                llLeftDrawer.setVisibility(View.GONE);
            }
        });



       /* tvVegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // ll_list_vegetable.setVisibility(View.VISIBLE);

                if(ll_list_vegetable.getVisibility() == View.VISIBLE){
                    ll_list_vegetable.setVisibility(View.GONE);
                } else {
                    ll_list_vegetable.setVisibility(View.VISIBLE);
                }
            }
        });*/


       /* bottomBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelect(int i) {
                if (i==0){
                    Log.d(TAG, "onItemSelect: 0");
                    fragment = new HomeFragment();
                    loadFragment(fragment);

                }else if(i==1){

                    Log.d(TAG, "onItemSelect: 1");
                }else if(i==2){
                    fragment = new WalletFragment();
                    loadFragment(fragment);
                    Log.d(TAG, "onItemSelect: 2");

                }
            }
        });
*/

        bottomNavigation.setMenuItemSelectionListener(new BottomNavigation.OnMenuItemSelectionListener() {
            @Override
            public void onMenuItemSelect(int i, int position, boolean b) {
                Log.d(TAG, "onMenuItemSelect: "+position);

                if (position==0){
                    Log.d(TAG, "onItemSelect: 0");
                    fragment = new HomeFragment();
                    loadFragment(fragment);

                }else if(position==1){

                    fragment = new CategoryFragment();
                    loadFragment(fragment);

                    Log.d(TAG, "onItemSelect: 1");
                }else if(position==2){

                    fragment = new OrderFragment();
                    loadFragment(fragment);
                    Log.d(TAG, "onItemSelect: 2");

                }else if(position==3){
                    fragment = new WalletFragment();
                    loadFragment(fragment);
                    Log.d(TAG, "onItemSelect: 3");

                }else if(position==4){

                    Log.d(TAG, "onItemSelect: 4");

                }
            }

            @Override
            public void onMenuItemReselect(int i, int position, boolean b) {
                Log.d(TAG, "onMenuItemReselect: "+position);

                if (position==0){
                    Log.d(TAG, "onMenuItemReselect: 0");
                    fragment = new HomeFragment();
                    loadFragment(fragment);

                }else if(position==1){
                    fragment = new CategoryFragment();
                    loadFragment(fragment);
                    Log.d(TAG, "onMenuItemReselect: 1");
                }else if(position==2){
                    fragment = new OrderFragment();
                    loadFragment(fragment);
                    Log.d(TAG, "onMenuItemReselect: 2");

                }else if(position==3){
                    fragment = new WalletFragment();
                    loadFragment(fragment);
                    Log.d(TAG, "onMenuItemReselect: 3");

                }else if(position==4){

                    Log.d(TAG, "onMenuItemReselect: 4");

                }
            }
        });



        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeScreen.this,CartScreen.class);
                startActivity(intent);
            }
        });


        ll_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llLeftDrawer.startAnimation(slideout);
                llLeftDrawer.setVisibility(View.GONE);
                Intent intent = new Intent(HomeScreen.this,ShopByCategoryScreen.class);
                startActivity(intent);
            }
        });

        ll_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                llLeftDrawer.startAnimation(slideout);
                llLeftDrawer.setVisibility(View.GONE);

                Intent intent = new Intent(HomeScreen.this,MyAccountScreen.class);
                startActivity(intent);
            }
        });

        ll_subscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                llLeftDrawer.startAnimation(slideout);
                llLeftDrawer.setVisibility(View.GONE);

                Intent intent = new Intent(HomeScreen.this,SubscriptionScreen.class);
                startActivity(intent);
            }
        });

         ll_share.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 llLeftDrawer.startAnimation(slideout);
                 llLeftDrawer.setVisibility(View.GONE);
             }
         });

         ll_refer.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 llLeftDrawer.startAnimation(slideout);
                 llLeftDrawer.setVisibility(View.GONE);
             }
         });

         ll_help.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 llLeftDrawer.startAnimation(slideout);
                 llLeftDrawer.setVisibility(View.GONE);
             }
         });


    }

/*    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.milk:
                *//*Intent i = new Intent(this, milk.class);
                startActivity(i);*//*
                break;

            case R.id.promo:
                Toast.makeText(this,"promo clicked",Toast.LENGTH_SHORT).show();
                break;

            case R.id.selling:
                Toast.makeText(this,"selling clicked",Toast.LENGTH_SHORT).show();
                break;

            case R.id.fruit:
                Toast.makeText(this,"fruit clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.newpdt:
                Toast.makeText(this,"New Product clicked",Toast.LENGTH_SHORT).show();
                break;

            case R.id.vegetable:
                Toast.makeText(this,"vegetable clicked",Toast.LENGTH_SHORT).show();
                break;

            case R.id.fastfood:
                Toast.makeText(this,"Fast food  clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Cabbage:
                Toast.makeText(this,"Cabbage  clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Carrot:
                Toast.makeText(this,"Carrot  clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.broccoli:
                Toast.makeText(this,"broccoli  clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Potato:
                Toast.makeText(this,"Potato  clicked",Toast.LENGTH_SHORT).show();
                break;

            case R.id.Rice:
                Toast.makeText(this,"Rice  clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Salad:
                Toast.makeText(this,"Salad  clicked",Toast.LENGTH_SHORT).show();
                break;



            default:
                break;
        }
    }*/

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, fragment);
        transaction.addToBackStack(null);
        // transaction.addToBackStack("home_frag");
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStackImmediate();
        } else {
            //  super.onBackPressed();


            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                finish();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please press again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }
    }

    @Override
    public void onMenuItemReselect(int itemId, int position, boolean b) {
        if (position==0){
            Log.d(TAG, "onItemSelect: 0");
            fragment = new HomeFragment();
            loadFragment(fragment);

        }else if(position==1){

            Log.d(TAG, "onItemSelect: 1");
        }else if(position==2){

            Log.d(TAG, "onItemSelect: 2");

        }else if(position==3){
            fragment = new WalletFragment();
            loadFragment(fragment);
            Log.d(TAG, "onItemSelect: 3");

        }else if(position==4){

            Log.d(TAG, "onItemSelect: 4");

        }
    }

    @Override
    public void onMenuItemSelect(int itemId, int position, boolean b) {
        if (position==0){
            Log.d(TAG, "onItemSelect: 0");
            fragment = new HomeFragment();
            loadFragment(fragment);

        }else if(position==1){

            Log.d(TAG, "onItemSelect: 1");
        }else if(position==2){

            Log.d(TAG, "onItemSelect: 2");

        }else if(position==3){
            fragment = new WalletFragment();
            loadFragment(fragment);
            Log.d(TAG, "onItemSelect: 3");

        }else if(position==4){

            Log.d(TAG, "onItemSelect: 4");

        }
    }
}
