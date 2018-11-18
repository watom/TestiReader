package projects.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.haitao.www.myformer.R;
import com.haitao.www.myformer.utils.Lout;

public class WelcomeActivity extends AppCompatActivity {
    private View welcome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher_background);

        findViews();
        setAnimation();
    }

    private void findViews() {
        welcome = findViewById(R.id.welcome);
    }

    private void setAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
        alphaAnimation.setDuration(1000);
        welcome.setAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Lout.e("Start","strat");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                Lout.e("End","End");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Lout.e("Repeat","Repeat");
            }
        });
    }
}
