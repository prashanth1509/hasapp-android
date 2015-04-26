package com.housinghack;

/**
 * Created by susee on 26/4/15.
 */

import android.content.Context;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.housinghack.entities.UserCollection;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class GalleryImageAdapter extends BaseAdapter {

    private Context mContext;
    UserCollection user;


    public GalleryImageAdapter(Context context, UserCollection user) {
        mContext = context;
        this.user = user;
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public int getCount() {
        return user.getUsers().size();
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
        public TextView textView;
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
                rowView = inflater.inflate(R.layout.gallery, viewGroup, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.textView = (TextView) rowView
                        .findViewById(R.id.galtxt);
                rowView.setTag(viewHolder);
            }
            ViewHolder viewHolder = (ViewHolder) rowView.getTag();
            viewHolder.textView.setText(user.getUsers().get(index).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowView;
    }

}
