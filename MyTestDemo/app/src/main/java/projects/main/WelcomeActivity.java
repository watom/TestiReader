package projects.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import com.haitao.www.myformer.R;
import com.haitao.www.myformer.utils.CountDownTimerUtils;
import com.haitao.www.myformer.utils.Lout;

public class WelcomeActivity extends AppCompatActivity {
    private View welcome;
    private TextView tvSkip;
    private CountDownTimerUtils mCountDownTimerUtils;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_launcher_background);

        findViews();
        initData();
        setAnimation();
    }

    private void initData() {
        mCountDownTimerUtils = new CountDownTimerUtils(tvSkip, 5000, 1000);
        mCountDownTimerUtils.start();
        mCountDownTimerUtils.setCountDownListener(new CountDownTimerUtils.OnCountDownListener() {
            @Override
            public void onTickDispose(View view, long millisUntilFinished) {
                TextView tv = (TextView) view;
                tv.setClickable(false); //设置不可点击

//                SpannableString spannableString = new SpannableString(tv.getText().toString());  //获取按钮上的文字
//                ForegroundColorSpan span = new ForegroundColorSpan(Color.WHITE);//将倒计时的时间设置为白色
//                /**
//                 * public void setSpan(Object what, int start, int end, int flags) {
//                 * 主要是start跟end，start是起始位置,无论中英文，都算一个。
//                 * 从0开始计算起。end是结束位置，所以处理的文字，包含开始位置，但不包含结束位置。
//                 */
//                spannableString.setSpan(span, 4, 6, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                tv.setText(Long.toString(millisUntilFinished / 1000) + "秒");
            }

            @Override
            public void onFinishDispose(View view) {
                TextView tv = (TextView) view;
                tv.clearComposingText();
                tv.setText("点击跳过");
                tv.setClickable(true);//重新获得点击
            }
        });
    }

    private void findViews() {
        welcome = findViewById(R.id.welcome);
        tvSkip = findViewById(R.id.tv_skip);
    }

    private void setAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
        alphaAnimation.setDuration(3000);
        welcome.setAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Lout.e("Start", "strat");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
                Lout.e("End", "End");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Lout.e("Repeat", "Repeat");
            }
        });
    }
}
