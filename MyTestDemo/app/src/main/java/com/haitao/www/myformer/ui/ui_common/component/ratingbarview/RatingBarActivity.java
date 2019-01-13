package com.haitao.www.myformer.second.ui.ui_common.component.ratingbarview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.haitao.www.myformer.R;

import java.math.BigDecimal;

public class RatingBarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratingbar);
        setRatingBar();
    }

    private void setRatingBar() {
        final RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(RatingBarActivity.this,String.format("current rating val:%f, fromUser = %d", rating, fromUser ? 1:0),
                        Toast.LENGTH_SHORT).show();
                if(new BigDecimal(1.0).equals(new BigDecimal(rating))){
                    ratingBar.setRating(1);
                    ratingBar.setIndeterminateDrawable(getDrawable(R.drawable.ic_anger));
                }else if(new BigDecimal(2.0).equals(new BigDecimal(rating))){

                }else{

                }
            }
        });
        final RatingBarView ratingBar2 = (RatingBarView) findViewById(R.id.ratingBar2);
        ratingBar2.setOnRatingListener(new RatingBarView.OnRatingListener() {
            @Override
            public void onRating(Object bindObject, int RatingScore) {
                if(RatingScore==1){
                    ratingBar2.setStarFillDrawable(getResources().getDrawable(R.drawable.ic_anger));
                }else if(RatingScore==2){
                    ratingBar2.setStarFillDrawable(getResources().getDrawable(R.drawable.ic_browse));
                }else {
                    ratingBar2.setStarFillDrawable(getResources().getDrawable(R.drawable.ic_chat));
                }
            }
        });
    }
}
