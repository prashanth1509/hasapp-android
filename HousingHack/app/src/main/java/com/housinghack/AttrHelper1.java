package com.housinghack;

/**
 * Created by susee on 25/4/15.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.housinghack.entities.AttributeCollection;

import java.util.ArrayList;

public class AttrHelper1 extends BaseAdapter {

    private Context mContext;
    public AttributeCollection atr;

    public AttrHelper1(Context context, AttributeCollection name) {
        mContext = context;
        this.atr = name;
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public int getCount() {
        return atr.attributeList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        public TextView textView1;
        public TextView textView2;
        public TextView textView3;
    }

    // Override this method according to your need
    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {
        // TODO Auto-generated method stub
        View rowView = view;
        try {
            if (rowView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                rowView = inflater.inflate(R.layout.attrhelper1, viewGroup, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.textView1 = (TextView) rowView
                        .findViewById(R.id.attrname);
                viewHolder.textView2 = (TextView) rowView
                        .findViewById(R.id.like);
                viewHolder.textView3 = (TextView) rowView
                        .findViewById(R.id.unlike);
                rowView.setTag(viewHolder);
            }
            ViewHolder viewHolder = (ViewHolder) rowView.getTag();
            viewHolder.textView1.setText(atr.attributeList.get(index).title);
            viewHolder.textView2.setText("" + atr.attributeList.get(index).getVotesUp().size());
            viewHolder.textView3.setText("" + atr.attributeList.get(index).getVotesDown().size());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowView;
    }

}