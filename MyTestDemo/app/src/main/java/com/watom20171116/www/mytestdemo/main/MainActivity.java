package com.watom20171116.www.mytestdemo.main;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.watom20171116.www.mytestdemo.R;
import com.watom20171116.www.mytestdemo.SampleActivity;
import com.watom20171116.www.mytestdemo.main.main_fragement.DiscoveryFragment;
import com.watom20171116.www.mytestdemo.main.main_fragement.LookFragment;
import com.watom20171116.www.mytestdemo.main.main_fragement.NewsFragment;
import com.watom20171116.www.mytestdemo.main.main_fragement.TalkFragment;
import com.watom20171116.www.mytestdemo.main.main_fragement.WodeFragment;
import com.watom20171116.www.mytestdemo.second.function.kernel_module.share.ShareTestActivity;
import com.watom20171116.www.mytestdemo.utils.Logout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, RadioGroup.OnCheckedChangeListener {
    private Context context;
    private Toolbar toolbar;
    private RadioGroup radiogroupBottomMenu;
    private RadioButton radiobutton01, radiobutton02, radiobutton03, radiobutton04, radiobutton05;
    private Fragment currentFragment, newsFragment, lookFragment, talkFragment, discoveryFragment, wodeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        findViews();
        setSupportActionBar(toolbar);
        setFloatingAndDrawe();
        initFragment();

    }

    private void findViews() {
        toolbar = findViewById(R.id.toolbar);
        radiogroupBottomMenu = (RadioGroup) findViewById(R.id.radiogroup_bottom_menu);
        radiobutton01 = (RadioButton) findViewById(R.id.radiobutton_01);
        radiobutton02 = (RadioButton) findViewById(R.id.radiobutton_02);
        radiobutton03 = (RadioButton) findViewById(R.id.radiobutton_03);
        radiobutton04 = (RadioButton) findViewById(R.id.radiobutton_04);
        radiobutton05 = (RadioButton) findViewById(R.id.radiobutton_05);
        radiogroupBottomMenu.setOnCheckedChangeListener(this);
    }

    private void initFragment() {
        FragmentManager fragmentManager;
        newsFragment = new NewsFragment();
        lookFragment = new LookFragment();
        talkFragment = new TalkFragment();
        discoveryFragment = new DiscoveryFragment();
        wodeFragment = new WodeFragment();
        currentFragment = talkFragment;
        radiobutton03.setChecked(true);
        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, currentFragment).commit();
    }

    private void setFloatingAndDrawe() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the MenuDefine; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            startActivity(new Intent(MainActivity.this, SampleActivity.class));
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {
            new ShareTestActivity(this).showShare();
        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Logout.e("group", "" + group.getCheckedRadioButtonId());
        Logout.e("checkedId", "" + checkedId);
        switch (group.getCheckedRadioButtonId()) {
            case R.id.radiobutton_01:
                switchFragment(newsFragment);
                break;
            case R.id.radiobutton_02:
                switchFragment(lookFragment);
                break;
            case R.id.radiobutton_03:
                switchFragment(talkFragment);
                break;
            case R.id.radiobutton_04:
                switchFragment(discoveryFragment);
                break;
            case R.id.radiobutton_05:
                switchFragment(wodeFragment);
                break;
        }
    }

    private void switchFragment(Fragment fragment) {
        //判断容器中当前显示的Fragment是不是和需要切换的Fragment相同。
        if (currentFragment != fragment) {
            //判断切换的Fragment是否已经添加过。
            if (!fragment.isAdded()) {
                //如果没有添加，则先把当前的Fragment隐藏，把切换的Fragment添加上。
                getSupportFragmentManager().beginTransaction().hide(currentFragment)
                        .add(R.id.frame_layout, fragment).commit();
            } else {
                //如果已经添加过，则先把当前的Fragment隐藏，把切换的Fragment显示出来。
                getSupportFragmentManager().beginTransaction().hide(currentFragment).show(fragment).commit();
            }
            currentFragment = fragment;
        }
    }

}
