package projects.main;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
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
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.haitao.www.myformer.R;
import com.haitao.www.myformer.SampleActivity;
import com.haitao.www.myformer.h5.h5_dome.WebViewPlatform;
import projects.main.main_fragement.DiscoveryFragment;
import projects.main.main_fragement.LookFragment;
import projects.main.main_fragement.NewsFragment;
import projects.main.main_fragement.TalkFragment;
import projects.main.main_fragement.WodeFragment;
import com.haitao.www.myformer.second.structure_design.StructureDesignActivity;
import com.haitao.www.myformer.second.function.kernel_module.share.ShareTestActivity;
import com.haitao.www.myformer.utils.Lout;

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
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        findViews();
//        setSupportActionBar(toolbar);
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
//        toolbar.
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {  //版本检测
//            SystemBarTintManager tintManager = new SystemBarTintManager(this);
//            tintManager.setStatusBarTintEnabled(true);  //更改状态栏设置
//            setSupportActionBar(toolbar);  //将ToolBar设置成ActionBar
//            tintManager.setStatusBarTintResource(android.R.color.holo_blue_bright);
//        }
//        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
        ImageView geekPortrait = (ImageView) findViewById(R.id.Geek_Portrait);
        TextView geekName = (TextView) findViewById(R.id.Geek_Name);
        TextView geekMotto = (TextView) findViewById(R.id.Geek_Motto);

//        geekPortrait.setImageResource(R.drawable.lunbotu_01);
//        geekName.setText("王海涛");
//        geekMotto.setText("灵感会稍纵即逝，机会也会相伴而来，请抓住它！");

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
//            System.exit(0);//退出比较突兀，不推荐使用
            moveTaskToBack(false);//退出界面比较柔和
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

        if (id == R.id.nav_studio) {
            startActivity(new Intent(MainActivity.this, SampleActivity.class));
        } else if (id == R.id.nav_source) {

        } else if (id == R.id.nav_stream) {

        } else if (id == R.id.nav_voyage) {
            startActivity(new Intent(this, StructureDesignActivity.class));
        } else if (id == R.id.nav_earth) {

        } else if (id == R.id.nav_interest) {
            startActivity(new Intent(MainActivity.this, WebViewPlatform.class));
        } else if (id == R.id.nav_favorite) {

        } else if (id == R.id.nav_share) {
            new ShareTestActivity(this).showShare();
        } else if (id == R.id.nav_secure) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_settings) {
            startActivity(new Intent(this, SettingActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Lout.e("group", "" + group.getCheckedRadioButtonId());
        Lout.e("checkedId", "" + checkedId);
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

//    @Override
//    public boolean onKeyUp(int keyCode, KeyEvent event) {
//        // return false 或者return true 都不会走onBackPressed了
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            Lout.e("onKeyUp","111");
//            return false;
//        }
//        Lout.e("onKeyUp","222");
//        return false;
//    }
//
//    /**
//     * 目标做成点击一下：弹出对话框，连续点击两下：退出APP
//     * @param keyCode
//     * @param event
//     * @return
//     */
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        // 不拦截，如果这里拦截了，也不会走到onBackPressed方法了
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            Lout.e("onKeyDown","111");
//            return super.onKeyDown(keyCode, event);
//        }
//        Lout.e("onKeyDown","222");
//        return false;
//    }

}
