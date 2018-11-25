package com.haitao.www.myformer.second.ui.ui_common.dialog.popupwindow_dialog;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;

import com.haitao.www.myformer.R;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * emoji的Unicode编码
 * 网站：Emoji Unicode Tables，该网站上面给出了每个emoji表情的图片,描述,Unicode编码的对照表,点击表中每一项emoji就可以得到这个表情对应的Unicode，
 * 在java中的Unicode表示就是:”\ud83d\ude01”,该编码字符可以直接被Android的TextView和EditText控件识别成对应的emoji表情.
 * https://apps.timwhitlock.info/emoji/tables/unicode
 * <p>
 * 添加表情
 * https://www.2cto.com/kf/201610/556687.html
 */
public class KeyboardFragment extends Fragment {
    private static final String Arguments = "position";
    Activity activity;
    TextView context_title;
    View view;

    /**
     * 创建页面并传入参数
     *
     * @param position 传入的参数
     * @return 为调用者返回一个fragment对象
     */
    public static KeyboardFragment getInstance(int position, int total) {
        KeyboardFragment fragment = new KeyboardFragment();
        Bundle args = new Bundle();
        args.putInt(Arguments, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_text, container, false);
        activity = getActivity();
        findView(view);
        initView();
        initData();
        return view;
    }

    private void initData() {
        String[] emojis = getEmojis();
        getPagerList(emojis);
    }

    /**
     * 从assets目录下获取所有表情
     *
     * @return
     */
    public String[] getEmojis() {
        BufferedReader br = null;
        String emojis[] = null;
        try {
            InputStream is = activity.getAssets().open("Emoji.json");
            StringBuffer sb = new StringBuffer();
            br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while (null != (line = br.readLine())) {
                sb.append(line).append("\r\n");
            }
            JSONArray emojiArray = new JSONArray(sb.toString());
            if (null != emojiArray && emojiArray.length() > 0) {
                emojis = new String[emojiArray.length()];
                for (int i = 0; i < emojiArray.length(); i++) {
                    emojis[i] = emojiArray.optString(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return emojis;
    }

    /**
     * 获取所有表情GridView页面的集合
     *
     * @param emojis
     * @return
     */
    public List<View> getPagerList(String[] emojis) {
        List<View> pagers = null;
        String[] eachPageEmojis = null;
        if (null != emojis && emojis.length > 0) {
            pagers = new ArrayList<>();
            int pageCount = emojis.length / 27;//共8页表情
            for (int i = 0; i < pageCount; i++) {
                GridView gridView = new GridView(activity);
                gridView.setNumColumns(7);
                gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
                gridView.setCacheColorHint(Color.TRANSPARENT);
                gridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
                gridView.setGravity(Gravity.CENTER);
                eachPageEmojis = new String[28];
                //总共216个表情字符,索引变化为:0-26,27-53,54-80,81-107,108-134,135-161,162-188,189-215
                System.arraycopy(emojis, i * 27, eachPageEmojis, 0, 27);
                eachPageEmojis[27] = "del";//第28是删除按钮,用特殊字符串表示
//                gridView.setAdapter(new EmojiGvAdapter(mContext, eachPageEmojis));
//                //点击表情监听
//                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                        //获取选中的表情字符
//                        String emoji = (String) parent.getAdapter().getItem(position);
//                        if (null != mEmojiClickListener) {
//                            mEmojiClickListener.onClick(emoji);
//                        }
//                    }
//                });
                pagers.add(gridView);
            }
        }
        return pagers;
    }


    private void initView() {
        int value = getArguments().getInt(Arguments);
        context_title.setText("页面" + value);
        if (value % 2 == 0) {
            view.setBackgroundColor(getResources().getColor(R.color.red));
        } else {
            view.setBackgroundColor(getResources().getColor(R.color.blue));
        }

    }

    private void findView(View view) {
        context_title = view.findViewById(R.id.context_title);
    }
}
