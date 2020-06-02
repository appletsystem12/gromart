package com.milk.bread.bread_milk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.milk.bread.bread_milk.R;

public class RegistrationScreen extends AppCompatActivity {

    RelativeLayout rl_up;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        rl_up = findViewById(R.id.rl_up);

        rl_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(LoginActivity.this,RegistrationScreen.class);
                startActivity(intent);*/

                startActivity(new Intent(RegistrationScreen.this, LoginActivity.class));
                overridePendingTransition(R.anim.slide_out_bottom, R.anim.no_animation);
            }
        });
    }
}
