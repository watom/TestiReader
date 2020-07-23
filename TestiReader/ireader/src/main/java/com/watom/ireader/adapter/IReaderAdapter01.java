package com.watom.ireader.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.watom.ireader.R;
import com.watom.ireader.widget.ReaderView01;

import java.util.List;

public class IReaderAdapter01 extends RecyclerView.Adapter<IReaderAdapter01.ViewHolder> {
    private List<String> dataList;

    public IReaderAdapter01(List<String> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reader01, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemIreaderPerpage.setText(dataList.get(position));
        holder.itemIreaderPageIndex.setText("第 "+(position+1)+" 页");
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ReaderView01 itemIreaderPerpage;
        TextView itemIreaderPageIndex;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemIreaderPerpage = itemView.findViewById(R.id.item_ireader_perpage);
            itemIreaderPageIndex = itemView.findViewById(R.id.item_ireader_pageIndex);
        }
    }
}
