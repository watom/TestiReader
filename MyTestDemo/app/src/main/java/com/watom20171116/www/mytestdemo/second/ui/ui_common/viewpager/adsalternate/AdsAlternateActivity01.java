package com.watom20171116.www.mytestdemo.second.ui.ui_common.viewpager.adsalternate;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.watom20171116.www.mytestdemo.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/6 0006.
 */

public class AdsAlternateActivity01 extends AppCompatActivity{

    private MyViewPager myviewpager;
    private TextView tvImageDesc;
    private LinearLayout roundPointGroup;
    // 图片资源ID
    private final int[] imageIds = { R.drawable.lunbotu_00, R.drawable.lunbotu_01, R.drawable.lunbotu_02,R.drawable.lunbotu_03, R.drawable.lunbotu_04 };
    // 图片标题集合
    private final String[] imageDes = { "经典家装设计","美女香车西安车展！", "新款宝马7系驾车上市", "城市车展美女香车", "上海天价车展女模" };

    private ArrayList<ImageView> imageList;
    protected int lastPosition;  //上一个页面的位置
    private boolean isRunning = false;  //判断是否自动滚动

    /**
     * 需要达到延时自动循环的效果，可以使用下面的方式：（这里用handler）
     * 1、定时器：Timer 2、开子线程 while true 循环 3、ColckManager 4、用handler
     */
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            // 让viewPager 滑动到下一页
            myviewpager.setCurrentItem(myviewpager.getCurrentItem() + 1);
            if (isRunning) {
                handler.sendEmptyMessageDelayed(0, 3000);
            }
        };
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myviewpager);
        findViews();
        initDate();
        myviewpager.setAdapter(new MyPagerAdapter());
    }

    private void initDate() {
        imageList=new ArrayList<>();
        for (int i = 0; i < imageIds.length; i++) {
            // 初始化图片资源
            ImageView image = new ImageView(this);
            image.setBackgroundResource(imageIds[i]);
            imageList.add(image);

            // 添加指示点
            ImageView point = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.rightMargin = 20;
            point.setLayoutParams(params);
            point.setBackgroundResource(R.drawable.lunbotu_round_point_selector);
            if (i == 0) {
                point.setEnabled(true);
            } else {
                point.setEnabled(false);
            }
            roundPointGroup.addView(point);
        }

        myviewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /**
             * 页面切换后调用
             * position  新的页面位置
             * @param position
             */
            @Override
            public void onPageSelected(int position) {
                position = position % imageList.size();

                // 设置文字描述内容
                tvImageDesc.setText(imageDes[position]);

                // 改变指示点的状态
                roundPointGroup.getChildAt(position).setEnabled(true); // 把当前点enbale 为true
                roundPointGroup.getChildAt(lastPosition).setEnabled(false); // 把上一个点设为false
                lastPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {} //当页面状态发生变化的时候，回调

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}  //页面正在滑动的时候，回调
        });

        isRunning = true;
        handler.sendEmptyMessageDelayed(0, 3000); //设置图片的自动滑动
    }

    //当退出轮播图界面时，停止滚动
    protected void onDestroy() {
        super.onDestroy();
        isRunning = false;
    };

    private void findViews() {
        myviewpager = (MyViewPager)findViewById( R.id.myviewpager );
        tvImageDesc = (TextView)findViewById( R.id.tv_image_desc );
        roundPointGroup = (LinearLayout)findViewById( R.id.round_point_group );
    }


    private class MyPagerAdapter extends PagerAdapter {
        /**
         * 获得页面的总数
         */
        @Override
        public int getCount() {
            return Integer.MAX_VALUE; // 使得图片可以循环
        }

        /**
         * 获得相应位置上的view
         * container  view的容器，其实就是viewpager自身
         * position    相应的位置
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // 给 container 添加一个view
            container.addView(imageList.get(position % imageList.size()));
            // 返回一个和该view相对的object
            return imageList.get(position % imageList.size());
        }

        /**
         * 判断 view和object的对应关系
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            if (view == object) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * 销毁对应位置上的object
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }

}
