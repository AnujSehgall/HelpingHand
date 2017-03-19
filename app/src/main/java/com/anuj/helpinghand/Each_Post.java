package com.anuj.helpinghand;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Each_Post extends AppCompatActivity {

    public ImageView Post_view;
    public TextView Post_name;
    public TextView About_att;
    public Button DtoP;
    public Button DtoS;
    public String post_name,info,urll;

    private String TAG = Each_Post.class.getSimpleName();

    private ProgressDialog pDialog;
    public Toolbar toolbar;


    // URL to get contacts JSON
    //private static String info_url = "http://www.json-generator.com/api/json/get/bTwiKgcyjS?indent=2";

    ArrayList<HashMap<String, String>> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each__post);


        SharedPreferences ab = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String purl = ab.getString("URL", "");

        SharedPreferences cd = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        urll= cd.getString("info", "");

        // Toast.makeText(getApplicationContext(),url,Toast.LENGTH_SHORT).show();

        Post_view = (ImageView) findViewById(R.id.post_pic);

        Picasso.with(this).load(purl).into(Post_view);

        Post_name= (TextView) findViewById(R.id.post_name);
        About_att = (TextView) findViewById(R.id.content);

        contactList = new ArrayList<>();
        new GetContacts().execute();

        DtoP = (Button) findViewById(R.id.button);
        DtoS=(Button) findViewById(R.id.button2);

        DtoS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j= new Intent(Each_Post.this,Donate_martyr.class);
                startActivity(j);
                finish();

            }
        });

        DtoP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(Each_Post.this,Donate_to_Post.class);
                startActivity(m);
                finish();
            }
        });
    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Each_Post.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(urll);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray contacts = jsonObj.getJSONArray("postinfo");

                    // looping through All Contacts
                   for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                         post_name = c.getString("pname");
                         info = c.getString("about");

                        // tmp hash map for single contact
                        HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value
                        contact.put("postname", post_name);
                        contact.put("aboutpost", info);

                        // adding contact to contact list
                        contactList.add(contact);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            About_att.setText(info);
            Post_name.setText(post_name);

        }

    }

}