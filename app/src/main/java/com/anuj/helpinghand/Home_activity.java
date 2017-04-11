package com.anuj.helpinghand;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.Timer;
import java.util.TimerTask;

public class Home_activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ListView listview ;

    String[] posts= {
            "Handwara attack",
            "Baramulla attack",
            "Uri attack",
            "Pampore attack",
            "Pathankot attack ",
            "Gurdaspur attack ",
    };

    public int currentimageindex=0;
    ImageView slidingimage;
    public String Pic_Url,Info_Url,post_pic,post_info,hint;
    private int[] IMAGE_IDS = {
            R.drawable.army, R.drawable.bsfnew, R.drawable.crpf

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listview = (ListView)findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (Home_activity.this,
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1,posts);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
            //    Toast.makeText(getApplicationContext(),"Click ListItem Number " + position, Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0: Pic_Url="https://s29.postimg.org/4x429t347/Handwara_attack.jpg";
                            Info_Url="http://www.json-generator.com/api/json/get/bTwiKgcyjS?indent=2";
                            hint="hand";

                        break;
                    case 1: Pic_Url="https://s28.postimg.org/egtnh9kzh/baramulla_attack.jpg";
                            Info_Url="http://www.json-generator.com/api/json/get/celSQxZyMi?indent=2";
                            hint="bara";
                        break;
                    case 2: Pic_Url="https://s24.postimg.org/sejft6tk5/uri_attack.jpg";
                            Info_Url="http://www.json-generator.com/api/json/get/bPLebaGjyq?indent=2";
                            hint="uri";
                        break;
                    case 3: Pic_Url="https://s30.postimg.org/sylk5l1f5/pampore_attack.jpg";
                            Info_Url="http://www.json-generator.com/api/json/get/cvqGuQMpaq?indent=2";
                            hint="pam";
                        break;
                    case 4: Pic_Url="https://s30.postimg.org/hpie63qzl/pathankot_air_base7591.jpg";
                            Info_Url="http://www.json-generator.com/api/json/get/cozqSFzNiW?indent=2";
                            hint="path";
                        break;
                    case 5: Pic_Url="https://s29.postimg.org/m0zynq087/gurdaspur_attack.jpg";
                            Info_Url="http://www.json-generator.com/api/json/get/ckcVspWICW?indent=2";
                            hint="gur";
                        break;
                }

                Intent i = new Intent(Home_activity.this,Each_Post.class);

                SharedPreferences cd = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                cd.edit().putString("info", Info_Url).apply();


                SharedPreferences ab = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                ab.edit().putString("URL", Pic_Url).apply();

                SharedPreferences ef = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                ef.edit().putString("post", post_pic).apply();

                SharedPreferences gh = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                gh.edit().putString("ac", post_info).apply();

                SharedPreferences ij = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                ij.edit().putString("hint", hint).apply();

                startActivity(i);
            }
        });

        listview.setAdapter(adapter);
        final Handler mHandler = new Handler();
           //Toast.makeText(getApplicationContext(),"hi",Toast.LENGTH_LONG).show();
        // Create runnable for posting
        final Runnable mUpdateResults = new Runnable() {
            public void run() {

                AnimateandSlideShow();

            }
        };

        int delay = 5000; // delay for 5 sec.

        int period = 3500; // repeat every 3.5 sec.

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {

                mHandler.post(mUpdateResults);

            }

        }, delay, period);

    }

    private void AnimateandSlideShow() {


        slidingimage = (ImageView)findViewById(R.id.gallery);
        slidingimage.setImageResource(IMAGE_IDS[currentimageindex%IMAGE_IDS.length]);
        if (currentimageindex==0){
        slidingimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home_activity.this,AboutBsf.class);
                startActivity(i);

            }
        });}
        if (currentimageindex==1)
        {
            slidingimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent j = new Intent(Home_activity.this,Join_Bsf.class);
                    startActivity(j);

                }
            });
        }
        if (currentimageindex==2){
            slidingimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent k = new Intent(Home_activity.this,Bsf_Achiv.class);
                    startActivity(k);

                }
            });
        }

        currentimageindex++;

        if (currentimageindex>2){
            currentimageindex=0;
        }

        Animation rotateimage = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);

        slidingimage.startAnimation(rotateimage);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_activity, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent i = new Intent(Home_activity.this,AboutBsf.class);
            startActivity(i);


        } else if (id == R.id.nav_gallery) {

            Intent j = new Intent(Home_activity.this,Join_Bsf.class);
            startActivity(j);


        } else if (id == R.id.nav_slideshow) {
            Intent k = new Intent(Home_activity.this,Bsf_Achiv.class);
            startActivity(k);


        }  else if (id == R.id.nav_share) {

            //Todo

        } else if (id == R.id.nav_send) {

            Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback for Helping Hand");
            intent.setData(Uri.parse("mailto: anujsehgal.04@gmail.com")); // or just "mailto:" for blank
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
