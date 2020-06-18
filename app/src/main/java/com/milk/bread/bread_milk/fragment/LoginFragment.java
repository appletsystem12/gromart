package com.milk.bread.bread_milk.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.milk.bread.bread_milk.ApplicationConstants;
import com.milk.bread.bread_milk.GlobalClass;
import com.milk.bread.bread_milk.R;
import com.milk.bread.bread_milk.Shared_Preference;
import com.milk.bread.bread_milk.ViewDialog;
import com.milk.bread.bread_milk.activity.HomeScreen;
import com.milk.bread.bread_milk.activity.LoginActivity;
import com.rilixtech.widget.countrycodepicker.CountryCodePicker;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LoginFragment extends Fragment {

    TextView tv_login,tv_generate_otp;
    RelativeLayout rl_otp,rl_mobile,rl_logo,rl_login,rl_down;
    RelativeLayout rl_main_layout;
    ImageView iv_logo;
    String TAG = "profile";
    ViewDialog viewDialog;
    private GlobalClass globalClass;
    Shared_Preference shared_preference;
    EditText mobile_edt,otp_edt;
    CountryCodePicker ccp;
    View view_otp;
    
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_login, container, false);

        globalClass = (GlobalClass) Objects.requireNonNull(getActivity()).getApplicationContext();
        shared_preference = new Shared_Preference(getActivity());
        shared_preference.loadPrefrence();
        viewDialog = new ViewDialog(getActivity());
        tv_login = view.findViewById(R.id.tv_login);
        tv_generate_otp = view.findViewById(R.id.tv_generate_otp);
        rl_otp = view.findViewById(R.id.rl_otp);
        rl_mobile = view.findViewById(R.id.rl_mobile);
        rl_main_layout = view.findViewById(R.id.rl_main_layout);
        rl_logo = view.findViewById(R.id.rl_logo);
        iv_logo = view.findViewById(R.id.iv_logo);
        rl_login = view.findViewById(R.id.rl_login);
        rl_down = view.findViewById(R.id.rl_down);
        mobile_edt = view.findViewById(R.id.mobile_edt);
        otp_edt = view.findViewById(R.id.otp_edt);
        ccp = view.findViewById(R.id.ccp);
        view_otp = view.findViewById(R.id.view_otp);

        tv_generate_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(getActivity(), HomeScreen.class);
                startActivity(intent);*/

                if(globalClass.isNetworkAvailable()) {
                    if (!mobile_edt.getText().toString().trim().isEmpty()) {
                        request_otp(mobile_edt.getText().toString());
                    } else {
                        Toast.makeText(getActivity(), "Please enter the mobile number.", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getActivity(),  "Check your internet connection.", Toast.LENGTH_LONG).show();
                }
            }
        });

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(getActivity(), HomeScreen.class);
                startActivity(intent);*/

                if(globalClass.isNetworkAvailable()) {
                    if (!otp_edt.getText().toString().trim().isEmpty()) {
                        validate_otp(mobile_edt.getText().toString(),otp_edt.getText().toString());
                    } else {
                        Toast.makeText(getActivity(), "Please enter the mobile number.", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getActivity(),  "Check your internet connection.", Toast.LENGTH_LONG).show();
                }
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

//        tv_text.setText(String.valueOf(screenInches));
        if(screenInches >= 5.5){
           /* logo_iv_placement();
            mobile_rl_placement();
            otp_rl_placement();
            login_tv_placement();*/
            main_rl_placement();
            rl_down_placement();
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


        rl_layoutParams.setMargins(dpToPx(50),dpToPx(120),dpToPx(50),dpToPx(50)); //ltrb
        rl_main_layout.setLayoutParams(rl_layoutParams);


    }

    public void rl_down_placement(){


        RelativeLayout rl = new RelativeLayout(getActivity());
        RelativeLayout.LayoutParams rl_layoutParams = new RelativeLayout.LayoutParams(
                dpToPx(50), dpToPx(50));

        rl_layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        rl_layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        rl_layoutParams.setMargins(dpToPx(0),dpToPx(0),dpToPx(33),dpToPx(95)); //ltrb
        rl_down.setLayoutParams(rl_layoutParams);


    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    private void request_otp( final String mobile) {
        // Tag used to cancel the request
        final String tag_string_req = "req_login";

        viewDialog.showDialog();
        String url = ApplicationConstants.request_otp;
        Log.d(TAG, "request_otp: url >> "+url);
        JSONObject js = new JSONObject();
        try {

            js.put("request_key",  "sdf97ds9f7sdf98");
            js.put("request_token", "dsfds9f79sd7fdsf");
            js.put("device", "mobile");
            js.put("mobile", mobile_edt.getText().toString());
            js.put("country_code", ccp.getSeglectedCountryCode());

            Log.d(TAG, "reference_book: js >  "+js.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                    Request.Method.POST, url, js,
                    new Response.Listener<JSONObject>() {


                @Override
                public void onResponse(JSONObject jobj) {
                    Log.d(TAG, "registration Response: " + jobj);


                    Gson gson = new Gson();

                    try {

                      /*  JsonObject jobj = gson.fromJson(response, JsonObject.class);
                        String result = response.get("result").g;
                        String message = response.get("message").getAsString().replaceAll("\"", "");*/

                        String result =jobj.getString("result");
                        String message =jobj.getString("message");
                        Log.d(TAG, "Message: "+message);

                        //if(status.equals("1")) {
                        if(result.equals("true")) {
                            ///  showOptDialog(mobile);


                            JSONObject data = jobj.getJSONObject("data");
                            String mobile = data.getString("mobile");
                            String country_code = data.getString("country_code");

                            Log.d(TAG, "onResponse:request_key>>>> " + mobile);
                            Log.d(TAG, "onResponse:request_token>>> " + country_code);

                            //globalClass.setRequest_token(request_token);
                            globalClass.setPhone_number(mobile);
                            shared_preference.savePrefrence();


                            tv_generate_otp.setVisibility(View.GONE);
                            rl_otp.setVisibility(View.VISIBLE);
                            view_otp.setVisibility(View.VISIBLE);
                            tv_login.setVisibility(View.VISIBLE);
                            mobile_edt.setEnabled(false);
                            viewDialog.hideDialog();
                            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "onSuccess:id "+message);
                        }else {

                            viewDialog.hideDialog();
                            Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                        }



                    }catch (Exception e){
                        e.printStackTrace();

                    }

                }
            }, new Response.ErrorListener() {

                @Override

                public void onErrorResponse(VolleyError error) {
                    Log.e(TAG, "registration Error: " + error.getMessage());
                    Toast.makeText(getActivity(),
                            "Connection Error", Toast.LENGTH_LONG).show();
                    //  pd.dismiss();
                    viewDialog.hideDialog();
                }
            }) {

                @Override
                protected Map<String, String> getParams() {
                    // Posting parameters to login url
                    Map<String, String> params = new HashMap<>();

           /*      *//*   params.put("request_key", globalClass.getRequest_key());
                    params.put("request_token", globalClass.getRequest_token());*//*
                    params.put("request_key", "sdf97ds9f7sdf98");
                    params.put("request_token", "dsfds9f79sd7fdsf");
                    params.put("device", "mobile");
                    params.put("mobile", mobile);
                    params.put("country_code", ccp.getSelectedCountryCode());*/


                    Log.d(TAG, "getParams: "+params);

                    return params;
                }

            };
            Volley.newRequestQueue(Objects.requireNonNull(getActivity())).add(jsonObjReq);
           // globalClass.addToRequestQueue(getActivity(), strReq, tag_string_req);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void validate_otp(final String mobile,final String otp) {
        // Tag used to cancel the request
        final String tag_string_req = "req_login";

        viewDialog.showDialog();
        String url = ApplicationConstants.validate_otp;
        Log.d(TAG, "validate_otp: url>> "+url);
        try{
            StringRequest strReq = new StringRequest(Request.Method.POST,
                    url, new Response.Listener<String>(){


                @Override
                public void onResponse(String response) {
                    Log.d(TAG, "registration Response: " + response);


                    Gson gson = new Gson();

                    try {


                        JsonObject jobj = gson.fromJson(response, JsonObject.class);
                        String result = jobj.get("result").getAsString().replaceAll("\"", "");
                        String message = jobj.get("message").getAsString().replaceAll("\"", "");


                        Log.d(TAG, "Message: "+message);

                        //if(status.equals("1")) {
                        if(result.equals("true")) {
                            ///  showOptDialog(mobile);
                            JsonObject data = jobj.getAsJsonObject("data");
                            String token = data.get("token").getAsString().replaceAll("\"", "");
                            String mobile = data.get("mobile").getAsString().replaceAll("\"", "");
                            String country_code = data.get("country_code").getAsString().replaceAll("\"", "");
                            String email = data.get("email").getAsString().replaceAll("\"", "");
                            String first_name = data.get("first_name").getAsString().replaceAll("\"", "");
                            String last_name = data.get("last_name").getAsString().replaceAll("\"", "");

                           /* Log.d(TAG, "onResponse:email>>>> " + email);
                            Log.d(TAG, "onResponse:last_name>>> " + last_name);
                            Log.d(TAG, "onResponse:first_name>>> " + first_name);
                            Log.d(TAG, "onResponse:token>>> " + token);*/


                            globalClass.setPhone_number(mobile);
                            globalClass.setEmail(email);
                            globalClass.setF_name(first_name);
                            globalClass.setL_name(last_name);
                            globalClass.setUser_token(token);
                            globalClass.setLogin_status(true);
                            shared_preference.savePrefrence();



                          /*  tv_generate_otp.setVisibility(View.GONE);
                            tv_login.setVisibility(View.VISIBLE);
                            mobile_edt.setEnabled(true);*/

                            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "onSuccess:id "+message);
                            viewDialog.hideDialog();
                          /*  Intent intent = new Intent(getActivity(), MainActivity.class);
                            intent.putExtra("token",token);
                            startActivity(intent);*/
                            Fragment fragment2 = new RegistrationFragment();
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.nav_host_fragment, fragment2);
                            fragmentTransaction.commit();
                            fragmentTransaction.setCustomAnimations(R.anim.slide_in_bottom, R.anim.no_animation);

                        }else{
                            viewDialog.hideDialog();
                            Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                        }



                    }catch (Exception e){
                        e.printStackTrace();

                    }

                }
            }, new Response.ErrorListener() {

                @Override

                public void onErrorResponse(VolleyError error) {
                    Log.e(TAG, "registration Error: " + error.getMessage());
                    Toast.makeText(getActivity(),
                            "Connection Error", Toast.LENGTH_LONG).show();
                    //  pd.dismiss();
                    viewDialog.hideDialog();
                }
            }) {

                @Override
                protected Map<String, String> getParams() {
                    // Posting parameters to login url
                    Map<String, String> params = new HashMap<>();

                   /*   params.put("request_key", globalClass.getRequest_key());
                    params.put("request_token", globalClass.getRequest_token());*/
                    params.put("request_key", "sdf97ds9f7sdf98");
                    params.put("request_token", "dsfds9f79sd7fdsf");
                    params.put("device", "mobile");
                    params.put("mobile", mobile);
                    params.put("country_code", ccp.getSelectedCountryCode());
                    params.put("otp", otp);



                    return params;
                }

            };

            Volley.newRequestQueue(Objects.requireNonNull(getActivity())).add(strReq);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
