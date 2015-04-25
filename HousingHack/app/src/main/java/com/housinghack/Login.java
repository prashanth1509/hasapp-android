package com.housinghack;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class Login extends ActionBarActivity {
    public static final String userstr = "usrstr";
    public static final String MyPREFERENCES = "MyPrefs";
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences sharedPreferences=getSharedPreferences(Login.MyPREFERENCES,context.MODE_PRIVATE);
        String sess=""+sharedPreferences.getString(Login.userstr,null);
        if(!sess.equals("null")){
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
    public void start(View view){
        EditText editText=(EditText)findViewById(R.id.editname);
        String name=editText.getText().toString();
        if(name.length()==0){
            editText.setError("Please Enter Your name");
        }else {
            SharedPreferences sharedPreferences = getSharedPreferences(MyPREFERENCES, context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(userstr, name);
            editor.commit();
            finish();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
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
