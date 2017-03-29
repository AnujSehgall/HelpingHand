package com.anuj.helpinghand;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class About_Soldier extends AppCompatActivity {

    int pos;
    String pname,info,img;
    TextView sname, content ;
    private String Respname,Respabout,Resptoll,Respdonate,Respemail,Respadd;
    Button paytm_pay, card_pay, bank_pay, cheque_pay,homebtn,post;
    private static String TAG = Donate_to_Post.class.getSimpleName();
    // Progress dialog
    private ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__soldier);

        SharedPreferences ij = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        pname=ij.getString("hint", "");

        SharedPreferences kl = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        pos = kl.getInt("pos", 0);
        //ImageView img= (ImageView)findViewById(R.id.sol_pic);
        sname=(TextView)findViewById(R.id.sname);
        content=(TextView)findViewById(R.id.abt);

        contentforact();

        homebtn=(Button) findViewById(R.id.button);
        post=(Button) findViewById(R.id.button2);
        paytm_pay=(Button)findViewById(R.id.paytm);
        card_pay=(Button)findViewById(R.id.card);
        bank_pay=(Button)findViewById(R.id.bankno);
        cheque_pay=(Button)findViewById(R.id.cheque);


        paytm_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Coming soon !",Toast.LENGTH_SHORT).show();
            }
        });

        card_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Coming soon !",Toast.LENGTH_SHORT).show();
            }
        });

        bank_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(About_Soldier.this);

                // Setting Dialog Title
                alertDialog.setTitle("Bank Details");

                // Setting Dialog Message
                alertDialog.setMessage(Respdonate);

                // Setting Icon to Dialog
                alertDialog.setIcon(R.drawable.helping_hand);

                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("Share a Message also.", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {

                        Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_SUBJECT, "A message to greet");
                        intent.setData(Uri.parse("mailto:"+Respemail)); // or just "mailto:" for blank
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
                        startActivity(intent);
                    }
                });

                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });

                // Showing Alert Message
                alertDialog.show();
            }
        });

        cheque_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(About_Soldier.this);

                // Setting Dialog Title
                alertDialog.setTitle("Send the cheques on: ");

                // Setting Dialog Message
                alertDialog.setMessage(Respadd);    //Todo

                // Setting Icon to Dialog
                alertDialog.setIcon(R.drawable.helping_hand);

                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("Share a Message also.", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {

                        Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_SUBJECT, "A message to greet");
                        intent.setData(Uri.parse("mailto:"+Respemail)); // or just "mailto:" for blank
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
                        startActivity(intent);
                    }
                });

                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });

                // Showing Alert Message
                alertDialog.show();


            }
        });

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(About_Soldier.this,Home_activity.class);
                startActivity(i);

            }
        });

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(About_Soldier.this,Donate_to_Post.class);
                startActivity(j);

            }
        });

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        makeJsonObjectRequest();
    }

    private void contentforact() {
        if(pname.equals("hand")){

            switch (pos){

                case 0: info="http://www.json-generator.com/api/json/get/cmKJMJTPLS?indent=2";
                    break;
                case 1: info="http://www.json-generator.com/api/json/get/bSNauEzLNe?indent=2";
                    break;
                case 2: info="http://www.json-generator.com/api/json/get/ceZNGqEHDm?indent=2";
                    break;
                case 3: info="http://www.json-generator.com/api/json/get/bLDVQCtOiG?indent=2";
                    break;
                case 4: info="http://www.json-generator.com/api/json/get/cjZMDWiHAO?indent=2";
                    break;
                case 5: info="http://www.json-generator.com/api/json/get/csezOlmunC?indent=2";
                    break;
                case 6: info="http://www.json-generator.com/api/json/get/ccpTvlaCTC?indent=2";
                    break;
                case 7: info="http://www.json-generator.com/api/json/get/bMtMCedKaa?indent=2";
                    break;
                case 8: info="http://www.json-generator.com/api/json/get/bMzjyrmIRK?indent=2";
                    break;
                case 9: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
            }}

        else if (pname.equals("bara")){
            switch (pos){

                case 0: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 1: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 2: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 3: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 4: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 5: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 6: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 7: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 8: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 9: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
            }
        }

        else if (pname.equals("uri")){
            switch (pos){

                case 0: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 1: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 2: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 3: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 4: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 5: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 6: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 7: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 8: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 9: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
            }
        }

        else if (pname.equals("pam")){
            switch (pos){

                case 0: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 1: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 2: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 3: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 4: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 5: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 6: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 7: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 8: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 9: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
            }
        }

        else if (pname.equals("path"))
        {
            switch (pos){

                case 0: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 1: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 2: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 3: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 4: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 5: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 6: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 7: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 8: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 9: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
            }
        }

        else {
            switch (pos){

                case 0: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 1: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 2: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 3: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 4: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 5: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 6: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 7: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 8: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
                case 9: info="http://www.json-generator.com/api/json/get/cgIfmPgBYO?indent=2";
                    break;
            }

        }
    }

    private void makeJsonObjectRequest() {

        showpDialog();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, info, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    // Parsing json object response
                    // response will be a json object
                    String name = response.getString("post_name");
                    String donate = response.getString("donat");
                    String about = response.getString("about_post");
                    Respadd=response.getString("add");
                    Respemail=response.getString("email");
                    Respname = name;
                    Respabout= about + "\n";
                    Respdonate = donate + "\n";


                    sname.setText(Respname);
                    content.setText(Respabout);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
                hidepDialog();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                // hide the progress dialog
                hidepDialog();
            }
        });

        // Adding request to request queue
        AppCont.getInstance().addToRequestQueue(jsonObjReq);
    }

    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
