package com.housinghack;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.housinghack.datasources.UsersDataSource;


public class Login extends ActionBarActivity {
    public static final String userstr = "usrstr";
    public static final String MyPREFERENCES = "MyPrefs";
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable e) {
                e.printStackTrace();
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences(Login.MyPREFERENCES, context.MODE_PRIVATE);
        String sess = "" + sharedPreferences.getString(Login.userstr, null);
        if (!sess.equals("null")) {
            finish();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void start(View view) {
        EditText editText = (EditText) findViewById(R.id.editname);
        String name = editText.getText().toString();
        if (name.length() == 0) {
            editText.setError("Please Enter Your name");
        } else {
            new Senduser().execute(name);
            SharedPreferences sharedPreferences = getSharedPreferences(MyPREFERENCES, context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(userstr, name);
            editor.commit();
            finish();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    private class Senduser extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... urls) {
            Intent intent = getIntent();
            Boolean mmm = true;
            String rmid = intent.getStringExtra(Getqr.Data);
            System.out.println("asdfas" + rmid);
            for (String url : urls) {
                try {
                    UsersDataSource attributeDataSource = new UsersDataSource();
                    mmm = attributeDataSource.addUser(rmid, url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return mmm;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result == true)
                Toast.makeText(getBaseContext(), "User Registered Successful", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getBaseContext(), "Error in User register", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
