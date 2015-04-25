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

public class ChatHelper extends BaseAdapter {

    private Context mContext;
    public ArrayList<String> name;
    public ArrayList<String> chtext;

    public ChatHelper(Context context,ArrayList<String> name,ArrayList<String> chtext) {
        mContext = context;
        this.name=name;
        this.chtext=chtext;
    }

    @Override
    public int getCount() {
        return name.size();
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
                rowView = inflater.inflate(R.layout.chathelper, viewGroup, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.textView1 = (TextView) rowView
                        .findViewById(R.id.username);
                viewHolder.textView2 = (TextView) rowView
                        .findViewById(R.id.chatcontent);
                rowView.setTag(viewHolder);
            }
            ViewHolder viewHolder = (ViewHolder) rowView.getTag();
            viewHolder.textView1.setText(name.get(index));
            viewHolder.textView2.setText(chtext.get(index));
        } catch (Exception e) {

        }
        return rowView;
    }

}

