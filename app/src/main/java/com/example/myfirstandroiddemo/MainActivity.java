package com.example.myfirstandroiddemo;

import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TabFragment.OnFragmentInteractionListener{

    private String[] titles = new String[]{"微信", "通讯录", "发现", "我"};
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MyFragmentAdapter adapter;
    //ViewPage选项卡页面集合
    private List<Fragment> mFragments;
    //Tab标题集合
    private List<String> mTitles;
    /**
     * 图片数组
     */
    private int[] mImgs=new int[]{R.drawable.selector_tab_weixin, R.drawable.selector_tab_friends, R.drawable.selector_tab_find,
            R.drawable.selector_tab_me};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.viewpager);
        mTabLayout = findViewById(R.id.tablayout);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = MainActivity.this.getWindow();
            window.setStatusBarColor(Color.TRANSPARENT);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(MainActivity.this.getResources().getColor(R.color.colorPrimary));
        }

        mTitles = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            mTitles.add(titles[i]);
        }

        mFragments = new ArrayList<>();
        for (int i = 0; i < mTitles.size(); i++) {
            mFragments.add(TabFragment.newInstance(i));
        }
        adapter = new MyFragmentAdapter(getSupportFragmentManager(), mFragments, mTitles);
        mViewPager.setAdapter(adapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来

        mTabLayout.setSelectedTabIndicatorHeight(0);
        for (int i = 0; i < mTitles.size(); i++) {
            TabLayout.Tab itemTab = mTabLayout.getTabAt(i);
            if (itemTab != null) {
                itemTab.setCustomView(R.layout.item_tab);
                TextView textView = itemTab.getCustomView().findViewById(R.id.tv_name);
                textView.setText(mTitles.get(i));
                ImageView imageView= itemTab.getCustomView().findViewById(R.id.iv_img);
                imageView.setImageResource(mImgs[i]);
            }
        }
        mTabLayout.getTabAt(0).getCustomView().setSelected(true);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
