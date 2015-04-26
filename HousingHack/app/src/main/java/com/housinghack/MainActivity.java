package com.housinghack;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.housinghack.datasources.AttributeDataSource;
import com.housinghack.datasources.MessageDataSource;
import com.housinghack.datasources.UsersDataSource;
import com.housinghack.entities.AttributeCollection;
import com.housinghack.entities.MessageCollection;
import com.housinghack.entities.User;
import com.housinghack.entities.UserCollection;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.lucasr.twowayview.TwoWayView;
//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.web.client.RestTemplate;
;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {
    SlidingPaneLayout mSlidingPanel;
    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    UserCollection userColl;
    String uuuname = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable e) {
                e.printStackTrace();
            }
        });

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        GalHelper galHelper = new GalHelper(this);
        gallery.setAdapter(galHelper);
        mSlidingPanel = (SlidingPaneLayout) findViewById(R.id.SlidingPanel);
        mSlidingPanel.setParallaxDistance(180);
        mSlidingPanel.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(Login.MyPREFERENCES, Context.MODE_PRIVATE);
        uuuname = "" + sharedPreferences.getString(Login.userstr, null);

        TextView textView = (TextView) findViewById(R.id.userr);
        textView.setText("Hi " + uuuname);

//        Intent intent=getIntent();
//        String rmid=""+intent.getStringExtra(Getqr.Data);

        SharedPreferences sharedPreferences1 = getSharedPreferences(Getqr.MyPREFERENCES, Context.MODE_PRIVATE);
        String rmid = "" + sharedPreferences1.getString(Getqr.use, null);

        if (!rmid.equals("null")) {
            new Getdata().execute("");
            new GetMsgdata().execute("");
            new GetUserdata().execute("");

        }

    }

    private class Getdata extends AsyncTask<String, Void, AttributeCollection> {
        @Override
        protected AttributeCollection doInBackground(String... urls) {
            AttributeCollection attributeCollection = new AttributeCollection();
//            Intent intent=getIntent();
//            String rmid=intent.getStringExtra(Getqr.Data);
            SharedPreferences sharedPreferences1 = getSharedPreferences(Getqr.MyPREFERENCES, Context.MODE_PRIVATE);
            String rmid = "" + sharedPreferences1.getString(Getqr.use, null);
            System.out.println("asdfas" + rmid);
            for (String url : urls) {
                try {
                    AttributeDataSource attributeDataSource = new AttributeDataSource();
                    attributeCollection = attributeDataSource.getAttributes(rmid);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return attributeCollection;
        }

        @Override
        protected void onPostExecute(AttributeCollection result) {
            name(result);
        }
    }

    public void name(AttributeCollection res) {
        ListView listView1 = (ListView) findViewById(R.id.list2);
        AttrHelper1 attrHelper1 = new AttrHelper1(this, res);
        listView1.setAdapter(attrHelper1);
    }

    private class GetMsgdata extends AsyncTask<String, Void, MessageCollection> {
        @Override
        protected MessageCollection doInBackground(String... urls) {
            MessageCollection attributeCollection = new MessageCollection();
//            Intent intent=getIntent();
//            String rmid=intent.getStringExtra(Getqr.Data);
            SharedPreferences sharedPreferences1 = getSharedPreferences(Getqr.MyPREFERENCES, Context.MODE_PRIVATE);
            String rmid = "" + sharedPreferences1.getString(Getqr.use, null);
            System.out.println("asdfas" + rmid);
            for (String url : urls) {
                try {
                    MessageDataSource attributeDataSource = new MessageDataSource();
                    attributeCollection = attributeDataSource.getContents(rmid, 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return attributeCollection;
        }

        @Override
        protected void onPostExecute(MessageCollection result) {
            user(result);
        }
    }

    public void user(MessageCollection ress) {
        try {
            ListView listView = (ListView) findViewById(R.id.list1);
            ChatHelper chatHelper = new ChatHelper(this, ress);
            listView.setAdapter(chatHelper);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class GetUserdata extends AsyncTask<String, Void, UserCollection> {
        @Override
        protected UserCollection doInBackground(String... urls) {
            Intent intent = getIntent();
            UserCollection uc = new UserCollection();
            //String rmid=intent.getStringExtra(Getqr.Data);
            SharedPreferences sharedPreferences1 = getSharedPreferences(Getqr.MyPREFERENCES, Context.MODE_PRIVATE);
            String rmid = "" + sharedPreferences1.getString(Getqr.use, null);
            try {
                UsersDataSource attributeDataSource = new UsersDataSource();
                uc = attributeDataSource.getUsers(rmid);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return uc;
        }

        @Override
        protected void onPostExecute(UserCollection result) {
            getuser(result);
        }
    }

    public void getuser(UserCollection res) {
        TwoWayView listview = (TwoWayView) findViewById(R.id.lvItems);
        GalleryImageAdapter galleryImageAdapter = new GalleryImageAdapter(this, res);
        listview.setAdapter(galleryImageAdapter);

    }

    public void send(View view) {
        EditText editText = (EditText) findViewById(R.id.sendtext);
        String text = editText.getText().toString();
        new Senddata().execute("" + text);
    }

    private class Senddata extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... urls) {
            Boolean attributeCollection = true;
            Intent intent = getIntent();
            //String rmid=intent.getStringExtra(Getqr.Data);
            SharedPreferences sharedPreferences1 = getSharedPreferences(Getqr.MyPREFERENCES, Context.MODE_PRIVATE);
            String rmid = "" + sharedPreferences1.getString(Getqr.use, null);
            System.out.println("asdfas" + rmid);
            for (String url : urls) {
                try {
                    MessageDataSource attributeDataSource = new MessageDataSource();
                    attributeCollection = attributeDataSource.sendMessage(true, rmid, uuuname, "", "", url, "");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return attributeCollection;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result == true)
                Toast.makeText(getBaseContext(), "Message Sent Successful", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getBaseContext(), "Error in Message sent", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(getBaseContext(), "Example action.", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (item.getItemId() == R.id.bsearch) {
            Toast.makeText(getBaseContext(), "Example action.", Toast.LENGTH_SHORT).show();
            mSlidingPanel.openPane();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
