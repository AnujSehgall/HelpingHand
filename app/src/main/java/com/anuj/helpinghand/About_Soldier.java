package com.anuj.helpinghand;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class About_Soldier extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__soldier);

        SharedPreferences kl = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        int pos = kl.getInt("pos", 0);
        ImageView img= (ImageView)findViewById(R.id.sol_pic);

        if (pos==1) {
            //Picasso.with(this).load().into(img);
        }
    }
}
