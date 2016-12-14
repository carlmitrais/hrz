package com.cssolution.horizon.horizon_v01.activities;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cssolution.horizon.horizon_v01.R;
import com.cssolution.horizon.horizon_v01.adapters.ScreenSlidePageAdapter;
import com.cssolution.horizon.horizon_v01.helpers.ZoomOutPageTransformer;

public class WelcomeScreenActivity extends FragmentActivity implements View.OnClickListener {
    // Number of pages that showed in welcome screen
    private final static int PAGE_NUMBER = 3;

    // Pager widget that handles animation and allows swiping horizontally to access previous and next content in welcome screen
    private ViewPager pager;

    // Pager adapter which provides the pages to the view pager widget
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        final ImageView img1 = (ImageView) findViewById(R.id.imageView1);
        img1.setImageAlpha(150);
        final ImageView img2 = (ImageView) findViewById(R.id.imageView2);
        final ImageView img3 = (ImageView) findViewById(R.id.imageView3);

        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePageAdapter(getSupportFragmentManager(), PAGE_NUMBER);

        pager.setAdapter(pagerAdapter);
        //pager.setPageTransformer(true, new ZoomOutPageTransformer());
        pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                switch (position){
                    case 0:
                        img1.setImageAlpha(150);
                        img2.setImageAlpha(255);
                        img3.setImageAlpha(255);
                        break;
                    case 1:
                        img1.setImageAlpha(255);
                        img2.setImageAlpha(150);
                        img3.setImageAlpha(255);
                        break;
                    case 2:
                        img1.setImageAlpha(255);
                        img2.setImageAlpha(255);
                        img3.setImageAlpha(150);
                        break;
                }
            }
        });

        LinearLayout loginLayout = (LinearLayout)findViewById(R.id.loginLayout);
        TextView loginTextView = (TextView)findViewById(R.id.loginTextView);

        loginLayout.setOnClickListener(this);
        loginTextView.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        if (pager.getCurrentItem() == 0){
            super.onBackPressed();
        }
        else {
            pager.setCurrentItem(pager.getCurrentItem() - 1);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}
