package com.yupi.home.panikerapp.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.yupi.home.panikerapp.R;
import com.yupi.home.panikerapp.adapter.SwipeMainPager;
import com.yupi.home.panikerapp.fragments.MainFragment;
import com.yupi.home.panikerapp.fragments.MultiMediaFragment;
import com.yupi.home.panikerapp.fragments.PanicFragment;
import com.yupi.home.panikerapp.utils.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.viewpager)
    public ViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Nullable
    @BindView(R.id.bottomNavigation)
    public LinearLayout linearLayout;
    @Nullable
    @BindView(R.id.main_button)
    ImageView mainButton;
    @BindView(R.id.add_post)
    LinearLayout addPost;
    @BindView(R.id.sendMsg)
    LinearLayout sendMsgLayout;
    @BindView(R.id.root_frameLayout)
    FrameLayout frameLayout;
    @BindView(R.id.profileImage)
    ImageView profileImage;
    @BindView(R.id.homeImage)
    ImageView homeImage;
    @BindView(R.id.write)
    ImageView write;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
        setupViewPager();
      //  addFragments(R.id.root_frameLayout, new RecipientFragment()).commit();
    }

    private void setupUI() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
          //  toolbar.setNavigationIcon(R.drawable.main_button_test);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_photo_camera_white_24dp);
        }
    }

    private void setupViewPager() {
        final SwipeMainPager swipeMainPager = new SwipeMainPager(getSupportFragmentManager(), getResources(), this);
        viewPager.setAdapter(swipeMainPager);
        viewPager.setCurrentItem(1);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
             //   Log.d("checkPosition", String.valueOf(position));
                if (position < 1) {
                    if (getSupportActionBar() != null)
                        getSupportActionBar().hide();
                    linearLayout.setVisibility(View.GONE);
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    RelativeLayout.LayoutParams relativeLayout = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    relativeLayout.setMargins(0, 0, 0, 0);
                    viewPager.setLayoutParams(relativeLayout);
                } else if(position >= 1)

                {
                    if (getSupportActionBar() != null)
                        if (!getSupportActionBar().isShowing())
                            getSupportActionBar().show();
                    if (linearLayout.getVisibility() == View.GONE)
                        linearLayout.setVisibility(View.VISIBLE);
                    RelativeLayout.LayoutParams relativeLayout = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    relativeLayout.setMargins(0,
                            getSupportActionBar().getHeight(), 0, getSupportActionBar().getHeight());
                    viewPager.setLayoutParams(relativeLayout);
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

                }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick({R.id.main_button, R.id.add_post, R.id.sendMsg, R.id.homeButton, R.id.viewProfile})
    public void setClickListeners(View view){
        switch (view.getId()){
            case R.id.main_button:
                if(getBackStackCount() > 0) {
                    clearBackStack();
                    transaction(R.id.root_frameLayout, new PanicFragment(), "Panic")
                            .addToBackStack(Constants.backStack).commit();
                }
                else
                    transaction(R.id.root_frameLayout, new PanicFragment(), "Panic")
                            .addToBackStack(Constants.backStack).commit();
                break;
            case R.id.add_post:
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                transaction(R.id.root_frameLayout, new MultiMediaFragment())
                        .addToBackStack(Constants.backStack).commit();
                break;
            case R.id.sendMsg:
                write.setImageResource(R.drawable.write_more_green);
                write.setAlpha(1f);
                profileImage.setImageResource(R.drawable.profile);
                homeImage.setImageResource(R.drawable.home_gray);
                if(getBackStackCount() > 0) {
                    clearBackStack();
                    transaction(R.id.root_frameLayout, new FriendsFragment())
                            .addToBackStack(Constants.backStack).commit();
                }
                else
                    transaction(R.id.root_frameLayout, new FriendsFragment())
                            .addToBackStack(Constants.backStack).commit();
                break;
            case R.id.homeButton:
                write.setImageResource(R.drawable.write);
                write.setAlpha(0.7f);
                profileImage.setImageResource(R.drawable.profile);
                homeImage.setImageResource(R.drawable.home);
                restartActivity();
                break;
            case R.id.viewProfile:
                write.setImageResource(R.drawable.write);
                write.setAlpha(0.7f);
                profileImage.setImageResource(R.drawable.profile_green);
                homeImage.setImageResource(R.drawable.home_gray);
                if(getBackStackCount() > 0) {
                  clearBackStack();
                    viewPager.setCurrentItem(Constants.ViewProfile);
                }
                else
                    viewPager.setCurrentItem(Constants.ViewProfile);
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if(getBackStackCount() > 0) {
                    clearBackStack();
                    viewPager.setCurrentItem(Constants.Gallery);
                    Log.d("PopUp", String.valueOf(getBackStackCount()));
                }
                else
                    viewPager.setCurrentItem(Constants.Gallery);
                break;
            case R.id.search:
                if(getBackStackCount() > 0) {
                    clearBackStack();
                    viewPager.setCurrentItem(Constants.Search);
                }
                else
                    viewPager.setCurrentItem(Constants.Search);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private AlertDialog.Builder builder(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.alert_dialog_layout, null);
        alert.setView(view);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return alert;
    }
    private FragmentTransaction transaction(int id, Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(id, fragment);
        return fragmentTransaction;
    }
    private FragmentTransaction transaction(int id, Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(id, fragment, tag);
        return fragmentTransaction;
    }

    private FragmentTransaction removeFragments(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(fragment);
        return fragmentTransaction;
    }
    private FragmentTransaction addToBackStack(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(Constants.backStack);
        return fragmentTransaction;
    }
    @Override
    public void onBackPressed() {
        clearFlags();
        //TODO back button not working on Panic Fragment
        Log.d("PopUp", String.valueOf(getBackStackCount()));
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("Panic");
        Log.d("PopUp", String.valueOf(fragment));
        if(fragment instanceof PanicFragment) {
          restartActivity();
        }

        if(getBackStackCount() == 0 && viewPager.getCurrentItem() != Constants.HomePage){
            viewPager.setCurrentItem(Constants.HomePage);
        }
        else if(getBackStackCount() == 0 && viewPager.getCurrentItem() == Constants.HomePage)
        super.onBackPressed();
        else {
            getSupportFragmentManager().popBackStack();
            Log.d("PopUp", String.valueOf(getBackStackCount()));
        }
    }
    private void clearFlags(){
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    private void restartActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    private int getBackStackCount(){
        return getSupportFragmentManager().getBackStackEntryCount();
    }
    private void clearBackStack(){
        FragmentManager.BackStackEntry entry =
                getSupportFragmentManager().getBackStackEntryAt(getBackStackCount() - 1);
        getSupportFragmentManager().popBackStack(entry.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
    private void clearBackStack(String path){
        getSupportFragmentManager().popBackStack(path, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
}
