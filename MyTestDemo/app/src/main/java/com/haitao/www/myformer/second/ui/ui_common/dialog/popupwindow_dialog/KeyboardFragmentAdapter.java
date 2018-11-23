package com.haitao.www.myformer.second.ui.ui_common.dialog.popupwindow_dialog;

import android.app.Activity;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.haitao.www.myformer.R;
import com.haitao.www.myformer.second.ui.ui_common.tabActivity.tablayout.MyFragment;
import com.haitao.www.myformer.utils.ToastUtils;


public class KeyboardFragmentAdapter extends FragmentPagerAdapter{
    private Activity activity;
    private ImageView point;
    String[] tabs = {"Emoji","表情","斗图","自定义","表情","斗图","自定义","表情","斗图","自定义","表情"};

    public KeyboardFragmentAdapter(FragmentManager fm, Activity activity) {
        super(fm);
        this.activity=activity;
    }

    @Override
    public Fragment getItem(int position) {
        return KeyboardFragment.getInstance(position, tabs.length);
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
