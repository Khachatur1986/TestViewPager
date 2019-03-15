package com.khach.myapplication;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import com.khach.myapplication.fragments.FirstFragment;
import com.khach.myapplication.fragments.SecondFragment;
import com.khach.myapplication.fragments.ThreeFragment;

import java.util.ArrayList;
import java.util.List;

import static com.khach.myapplication.Constants.FIRST;

public class MainActivity extends AppCompatActivity {
    public static final String  EXTRA_KEY= "key";
    private TabLayout tl_tabs;
    private ViewPager vp_main_container;

    private int[] tabIcons = {
            android.support.design.R.drawable.abc_btn_check_to_on_mtrl_000,
            android.support.design.R.drawable.abc_btn_switch_to_on_mtrl_00012,
            android.support.design.R.drawable.abc_btn_check_to_on_mtrl_015,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        setupViewPager(vp_main_container);
        tl_tabs.setupWithViewPager(vp_main_container);

        setupTabIcons();

        Intent intent = getIntent();
        int index = intent.getIntExtra(EXTRA_KEY, -1);

        vp_main_container.setCurrentItem(index);
    }

    private void initViews() {
        tl_tabs = findViewById(R.id.tl_tabs);
        vp_main_container = findViewById(R.id.vp_main_container);
    }


    private void setupTabIcons() {
        tl_tabs.getTabAt(0).setIcon(tabIcons[0]);
        tl_tabs.getTabAt(1).setIcon(tabIcons[1]);
        tl_tabs.getTabAt(2).setIcon(tabIcons[2]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FirstFragment(), "ONE");
        adapter.addFragment(new SecondFragment(), "TWO");
        adapter.addFragment(new ThreeFragment(), "THREE");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return mFragmentList.get(i);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
