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

import java.util.ArrayList;

public class AttrHelper1 extends BaseAdapter {

    private Context mContext;
    public ArrayList<String> atr;

    public AttrHelper1(Context context,ArrayList<String> name) {
        mContext = context;
        this.atr=name;
    }

    @Override
    public int getCount() {
        return atr.size();
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
    }

    // Override this method according to your need
    @Override
    public View getView(int index,View view, ViewGroup viewGroup) {
        // TODO Auto-generated method stub
        View rowView = view;
        try {
            if (rowView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                rowView = inflater.inflate(R.layout.attrhelper1, viewGroup, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.textView1 = (TextView) rowView
                        .findViewById(R.id.atrname);
            }
            ViewHolder viewHolder = (ViewHolder) rowView.getTag();
            viewHolder.textView1.setText(atr.get(index));
        } catch (Exception e) {

        }
        return rowView;
    }

}

