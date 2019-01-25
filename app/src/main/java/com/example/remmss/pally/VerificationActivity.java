package com.example.remmss.pally;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import me.relex.circleindicator.CircleIndicator;

public class VerificationActivity extends AppCompatActivity {



    ViewPager viewPager;
    LinearLayout dotsLayout1;
    private int[] layouts;

    VerificationActivity.MyViewPagerAdapter myViewPagerAdapter;
    private TextView[] dots1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);



        viewPager = (ViewPager) findViewById(R.id.view_pager);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);






        layouts = new int[]{

                R.layout.activity_slding1,
                R.layout.activity_slding2,
                R.layout.activity_slding3,
                R.layout.activity_slding4



        };


        // addBottomDots(0);

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        indicator.setViewPager(viewPager);


    }



    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

  /*  private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
        //  startActivity(new Intent(MainActivity.this, MainSplashActivity.class));
        finish();
    }
*/
    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            // addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                //  txtnext.setText(getString(R.string.start));
                //  txtskip.setText(getString(R.string.back));
            } else {
                // still pages are left
                //txtnext.setText(getString(R.string.next));
                //txtskip.setText(getString(R.string.skip));
               // txtskip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    /**
     * Making notification bar transparent
     */
/*    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ColorData.TRANSPARENT);
        }
    }*/

    private class MyViewPagerAdapter extends PagerAdapter {

        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }


        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
