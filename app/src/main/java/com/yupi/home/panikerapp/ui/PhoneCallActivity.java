package com.yupi.home.panikerapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.yupi.home.panikerapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhoneCallActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_call_answered_layout);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.endPhoneCall)
    public void handleClicks(View view){
        switch (view.getId()){
            case R.id.endPhoneCall:
                finish();
                break;
        }
    }
}
