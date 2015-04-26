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

import com.housinghack.entities.MessageCollection;
import com.housinghack.entities.User;
import com.housinghack.entities.UserCollection;

import java.util.ArrayList;
import java.util.List;

public class ChatHelper extends BaseAdapter {

    private Context mContext;
    public MessageCollection cont;

    public ChatHelper(Context context, MessageCollection cont) {
        mContext = context;
        this.cont = cont;
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public int getCount() {
        return cont.getMessages().size();
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
    public View getView(int index, View view, ViewGroup viewGroup) {
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
            viewHolder.textView1.setText(cont.getMessages().get(index).getAuthor());
            viewHolder.textView2.setText("" + cont.getMessages().get(index).getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowView;
    }

}

