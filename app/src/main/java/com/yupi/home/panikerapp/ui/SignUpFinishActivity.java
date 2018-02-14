package com.yupi.home.panikerapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.yupi.home.panikerapp.R;
import com.yupi.home.panikerapp.adapter.MainAdapterFeed;

public class SignUpFinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_finish_layout);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    public void finishSigningUp(View view){
        Intent intent = new Intent(SignUpFinishActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
