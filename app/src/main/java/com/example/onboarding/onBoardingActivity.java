package com.example.onboarding;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class onBoardingActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private sliderAdapter slideradapter;
    private TextView[] mDots;

    private Button nextButton,backButton;
    public int mcurrentpg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        mSlideViewPager=findViewById(R.id.slideViewPager);
        mDotLayout=findViewById(R.id.dotsLayout);

        nextButton=findViewById(R.id.nextbutton);
        backButton=findViewById(R.id.backbutton);

        slideradapter=new sliderAdapter(this);

        mSlideViewPager.setAdapter(slideradapter);
        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);
    }

    public void addDotsIndicator(int position)
    {
        mDots=new TextView[3];
        mDotLayout.removeAllViews();
        for(int i=0;i< mDots.length;i++)
        {
            mDots[i]=new TextView(this);

            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length>0)
        {
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener=new ViewPager.SimpleOnPageChangeListener()
    {
        @Override
        public void onPageSelected(int i)
        {
            addDotsIndicator(i);
            mcurrentpg=i;
            if(i==0)
            {
                nextButton.setEnabled(true);
                backButton.setEnabled(false);

                nextButton.setText("Next");
                backButton.setText("");

                backButton.setVisibility(View.INVISIBLE);
            }
            if(i==1)
            {
                nextButton.setEnabled(true);
                backButton.setEnabled(true);

                nextButton.setText("Next");
                backButton.setText("BAck");

                backButton.setVisibility(View.INVISIBLE);
            }
            if(i==2)
            {
                nextButton.setEnabled(true);
                backButton.setEnabled(true);

                nextButton.setText("Finish");
                backButton.setText("Back");

                backButton.setVisibility(View.VISIBLE);
            }
        }
    };
}
