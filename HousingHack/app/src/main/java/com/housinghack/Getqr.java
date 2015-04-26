package com.housinghack;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Getqr extends ActionBarActivity {
    public static final String Data = "data";
    public static final String use = "usr";
    public static final String MyPREFERENCES = "MyPrefs";
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getqr);

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();
        String data1 = "" + data.toString();
        String[] uurl = data1.split("#");
        String room_id = uurl[1];
        System.out.println("rooom" + room_id);
        finish();

        Intent intent1 = new Intent(this, MainActivity.class);
        intent1.putExtra(Data, room_id);
        startActivity(intent1);

        SharedPreferences sharedPreferences = getSharedPreferences(MyPREFERENCES, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(use, room_id);
        editor.commit();

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable e) {
                e.printStackTrace();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_getqr, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
