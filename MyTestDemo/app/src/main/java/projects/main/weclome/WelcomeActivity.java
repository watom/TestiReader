package projects.main.weclome;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import com.dk.view.patheffect.PathTextView;
import com.haitao.www.myformer.R;
import com.haitao.www.myformer.utils.CountDownTimerUtils;
import com.haitao.www.myformer.utils.Lout;

import projects.main.MainActivity;

/**
 * 渐变动画和倒计时同时进行，倒计时多执行1秒
 */
public class WelcomeActivity extends AppCompatActivity {
    private View welcome;
    private TextView tvSkip;
    private PathTextView createdTime;
    private CountDownTimerUtils mCountDownTimerUtils;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_launcher_background);

        findViews();
        initData();
        setAnimation();
        initEvent();
    }

    private void findViews() {
        welcome = findViewById(R.id.welcome);
        tvSkip = findViewById(R.id.tv_skip);
        createdTime = findViewById(R.id.created_time);
    }

    private void initData() {
        //设置倒计时功能
        mCountDownTimerUtils = new CountDownTimerUtils(tvSkip, 3000, 1000);
        mCountDownTimerUtils.start();
        mCountDownTimerUtils.setCountDownListener(new CountDownTimerUtils.OnCountDownListener() {
            @Override
            public void onTickDispose(View view, long millisUntilFinished) {
                TextView tv = (TextView) view;
                tv.setClickable(false); //设置不可点击

                SpannableString text = new SpannableString("跳过 剩余0秒");
                text.setSpan(new ForegroundColorSpan(Color.RED), 5, 6, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
                tv.setText("跳过 剩余" + Long.toString(millisUntilFinished / 1000) + "秒");
            }

            @Override
            public void onFinishDispose(View view) {
                TextView tv = (TextView) view;
                tv.setText("点击跳过");
                tv.setClickable(true);//重新获得点击
            }
        });

        //设置艺术字效果
        createdTime.init("2017.11.16");

        createdTime.setPaintType(PathTextView.Type.MULTIPLY);
        createdTime.setTextColor(Color.BLUE);
        createdTime.setTextSize(50);
        createdTime.setTextWeight(10);
        createdTime.setDuration(2000);
        createdTime.setShadow(0, 0, 0, Color.RED);
    }

    private void initEvent() {
        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private void setAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
        alphaAnimation.setDuration(2000);
        welcome.setAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Lout.e("Start", "strat");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Lout.e("End", "End");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Lout.e("Repeat", "Repeat");
            }
        });
    }
}