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

public class GalHelper extends BaseAdapter {

    private Context mContext;
    int[] data={R.drawable.room1,R.drawable.room2,R.drawable.room3,R.drawable.room1,R.drawable.room2,};


    public GalHelper(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return data.length;
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
        public ImageView imageView;
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
                rowView = inflater.inflate(R.layout.galleryview, viewGroup, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.imageView = (ImageView) rowView
                        .findViewById(R.id.imageview1);
                rowView.setTag(viewHolder);
            }
            ViewHolder viewHolder = (ViewHolder) rowView.getTag();
            viewHolder.imageView.setImageResource(data[index]);
        } catch (Exception e) {

        }
        return rowView;
    }

}

