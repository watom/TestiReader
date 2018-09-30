package com.watom20171116.www.mytestdemo.second.function.kernel_module.share;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.watom20171116.www.mytestdemo.R;
import com.watom20171116.www.mytestdemo.second.function.kernel_module.share.onekeyshare.OnekeyShare;

import static com.mob.tools.utils.Strings.getString;

/**
 * 使用的平台：Mob，官网：http://dashboard.mob.com/#!/share/dashboard
 * label：超级测试  Appkey:247303d390ef8    App Secret:11bf0f3a364e10f1be29bc8bcf21dc91
 * Created by Administrator on 2018/3/1 0001.
 */

public class ShareTestActivity {
    private Context context;

    public ShareTestActivity(Context context) {
        this.context=context;
    }

    public void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("分享");
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是王海涛，分享一个有趣的APP，欢迎您畅游互联网~");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

        // 启动分享GUI
        oks.show(context);
    }

}
