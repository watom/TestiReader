package com.watom20171116.www.mytestdemo.second.ui.ui_common.listview.expandablelistView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.watom20171116.www.mytestdemo.R;

/**
 * Created by Administrator on 2018/8/20 0020.
 */

public class MyExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;

    public MyExpandableListAdapter(Context context) {
        this.context = context;
    }

    int[] logos = new int[]
            {
                    R.drawable.common_icon,
                    R.drawable.common_icon,
                    R.drawable.common_icon
            };
    private String[] groupTypes = new String[]
            {"处理中", "已销账", "待销账"};
    private String[][] childrenTypes = new String[][]
            {
                    {"宝鸡", "铜川", "杨凌", "咸阳"},
                    {"大叔", "大妈", "孩子", "老人"},
                    {"洋葱", "大蒜", "韭黄"}
            };

    @Override
    public int getGroupCount() {
        return groupTypes.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childrenTypes[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupTypes[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childrenTypes[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder groupHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_online_grounp, null);
            groupHolder = new GroupHolder(convertView);
            convertView.setTag(groupHolder);
        } else {
            groupHolder = (GroupHolder) convertView.getTag();
        }
        groupHolder.ivPic.setImageResource(logos[groupPosition]);
        groupHolder.tvOnline.setText(getGroup(groupPosition).toString());

        if (isExpanded) {
            groupHolder.tvArrow.setText(getGroup(groupPosition).toString() + "  ------  ↓");
        } else {
            groupHolder.tvArrow.setText(getGroup(groupPosition).toString() + "  ------  ↑");
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildrenHolder childrenHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_online_children, null);
            childrenHolder = new ChildrenHolder(convertView);
            convertView.setTag(childrenHolder);
        } else {
            childrenHolder = (ChildrenHolder) convertView.getTag();
        }
        childrenHolder.tvContent.setText(getChild(groupPosition,childPosition).toString());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class GroupHolder {
        private ImageView ivPic;
        private TextView tvOnline;
        private TextView tvArrow;

        public GroupHolder(View content) {
            ivPic = (ImageView) content.findViewById(R.id.iv_pic);
            tvOnline = (TextView) content.findViewById(R.id.tv_online);
            tvArrow = (TextView) content.findViewById(R.id.tv_arrow);
        }
    }

    class ChildrenHolder {
        private TextView tvContent;

        public ChildrenHolder(View content) {
            tvContent = (TextView) content.findViewById(R.id.tv_content);
        }
    }
}
