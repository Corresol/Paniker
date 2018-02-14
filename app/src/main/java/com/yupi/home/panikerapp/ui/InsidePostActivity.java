package com.yupi.home.panikerapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.yupi.home.panikerapp.R;
import com.yupi.home.panikerapp.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InsidePostActivity extends AppCompatActivity {

  /*  @BindView(R.id.profileImage)
    ImageView profileImage;
    @BindView(R.id.profileName)
    TextView profileName;
    @BindView(R.id.mainImagePost)
    ImageView mainImagePost;
    @BindView(R.id.mainTextPost)
    TextView post;*/
    Intent intent;
    @BindView(R.id.btnComments)
    ImageView btnComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_full_screen);
        ButterKnife.bind(this);
      //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        intent = getIntent();
        btnComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_inside_post);
                ImageView returnBack = (ImageView)findViewById(R.id.returnBack);
                returnBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                });
            }
        });
    //    profileImage.setImageResource(returnImages(intent, Constants.profileImageKey));
    //    profileName.setText(getText(intent, Constants.profileNameKey));
    //    mainImagePost.setImageResource(returnImages(intent, Constants.mainImageKey));
    //    post.setText(getText(intent, Constants.postTextKey));

    }

    private int returnImages(Intent intent, String key) {
        return intent.getIntExtra(key, 0);
    }

    private String getText(Intent intent, String key) {
        return intent.getStringExtra(key);
    }
    @OnClick(R.id.returnBack)
    public void setReturnBack(View view){
        onBackPressed();
    }

}
