package com.haitao.www.myformer.ui.ui_common.component.ratingbarview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import com.haitao.www.myformer.R;
import com.haitao.www.myformer.utils.ToastUtils;

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
        final RatingBarView2 ratingBar2 = (RatingBarView2) findViewById(R.id.ratingBar2);
        ratingBar2.setOnRatingListener(new RatingBarView2.OnRatingListener() {
            @Override
            public void onRating(int mSelectedPosition) {
                ToastUtils.showToast(RatingBarActivity.this,""+mSelectedPosition);
            }
        });


        final RadioGroup rgSex = (RadioGroup) findViewById(R.id.rgSex);
        rgSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if(id==R.id.radio1){

                }

//               switch (checkedId){
//                   case R.id.radio1:
//                       RadioButton rbtn=radioGroup.getChildAt(0).findViewById(checkedId);
//                       rbtn.setButtonDrawable(R.drawable.ic_anger);
//                       break;
//                   case R.id.radio2:
//                       RadioButton rbtn=radioGroup.getChildAt(0).findViewById(checkedId);
//                       RadioButton rbtn1=radioGroup.getChildAt(1).findViewById(checkedId);
//                       rbtn.setButtonDrawable(R.drawable.ic_browse);
//                       rbtn1.setButtonDrawable(R.drawable.ic_browse);
//                       break;
//                   case R.id.radio3:
//                       RadioButton rbtn=radioGroup.getChildAt(0).findViewById(checkedId);
//                       RadioButton rbtn1=radioGroup.getChildAt(1).findViewById(checkedId);
//                       RadioButton rbtn2=radioGroup.getChildAt(2).findViewById(checkedId);
//                       RadioButton rbtn3=radioGroup.getChildAt(3).findViewById(checkedId);
//                       rbtn.setButtonDrawable(R.drawable.ic_chat);
//                       rbtn1.setButtonDrawable(R.drawable.ic_chat);
//                       rbtn2.setButtonDrawable(R.drawable.ic_chat);
//                       break;
//                   case R.id.radio4:
//                       RadioButton rbtn=radioGroup.getChildAt(0).findViewById(checkedId);
//                       RadioButton rbtn1=radioGroup.getChildAt(1).findViewById(checkedId);
//                       RadioButton rbtn2=radioGroup.getChildAt(2).findViewById(checkedId);
//                       RadioButton rbtn3=radioGroup.getChildAt(3).findViewById(checkedId);
//                       RadioButton rbtn4=radioGroup.getChildAt(4).findViewById(checkedId);
//                       rbtn.setButtonDrawable(R.drawable.ic_chat);
//                       rbtn1.setButtonDrawable(R.drawable.ic_chat);
//                       rbtn2.setButtonDrawable(R.drawable.ic_chat);
//                       rbtn3.setButtonDrawable(R.drawable.ic_chat);
//                       break;
//                   case R.id.radio5:
//                       rbtn.setButtonDrawable(R.drawable.ic_chat);
//                       rbtn1.setButtonDrawable(R.drawable.ic_chat);
//                       rbtn2.setButtonDrawable(R.drawable.ic_chat);
//                       rbtn3.setButtonDrawable(R.drawable.ic_chat);
//                       rbtn4.setButtonDrawable(R.drawable.ic_chat);
//                       break;
//               }
            }
        });

    }
}
