package com.example.remmss.pally;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.FrameLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import fragment.Home_Fragment;

public class Home_Activity extends AppCompatActivity {


    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        frameLayout = (FrameLayout) findViewById(R.id.framelayout);


        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottombar);
        for (int i = 0; i < bottomBar.getTabCount(); i++) {
            bottomBar.getTabAtPosition(i).setGravity(Gravity.CENTER_VERTICAL);
        }
        frameLayout = (FrameLayout) findViewById(R.id.framelayout);


        /*roughike bottombar library code is here*/

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {

            @Override
            public void onTabSelected(@IdRes int tabId) {
                Fragment fragment = null;
                switch (tabId) {
                    case R.id.home:

                        replace_fragment(new Home_Fragment());

                        break;
                    case R.id.topchart:
                        replace_fragment(new JobSearch4());
                        break;
                    case R.id.likeyou:
                        replace_fragment(new JobSearch4());
                        break;

                    case R.id.profile:
                        replace_fragment(new JobSearch4());
                        break;

                }


            }
        });
    }


    public void replace_fragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        transaction.commit();

    }
}
