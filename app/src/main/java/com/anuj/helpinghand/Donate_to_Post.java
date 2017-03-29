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
import com.anuj.helpinghand.AppCont;
import com.anuj.helpinghand.R;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.squareup.picasso.Picasso;


import org.json.JSONException;
import org.json.JSONObject;

public class Donate_to_Post extends AppCompatActivity {

    ImageView Post;
    TextView pname,about_post,detoll;
    Button homebtn,soldier,paytm,card,bankbtn,chk;

    private static String TAG = Donate_to_Post.class.getSimpleName();
    // Progress dialog
    private ProgressDialog pDialog;

//    private TextView txtResponse;

    // temporary string to show the parsed response
    private String Respname,Respabout,Resptoll,Respdonate,Respemail;
    public String phint="",post_pic="",post_info="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_to__post);

        SharedPreferences ij = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        phint=ij.getString("hint", "");

        switch (phint){

            case "hand" :post_pic="https://s18.postimg.org/tld984ly1/1414928675-5383.jpg";
                         post_info="http://www.json-generator.com/api/json/get/cgueJlyCqa?indent=2";
                break;

            case "bara" :post_pic="https://s14.postimg.org/5q2w3dm4x/LABS-master675.jpg";
                         post_info="http://www.json-generator.com/api/json/get/ciJiCeAyDC?indent=2";
                break;
            case "uri" : post_pic="https://s30.postimg.org/4ts2hx0mp/With_Indian_Army_9.jpg";
                        post_info="http://www.json-generator.com/api/json/get/bJpOzMqMde?indent=2";
                break;
            case "pam" : post_pic="https://s-media-cache-ak0.pinimg.com/originals/33/53/5c/33535c441b263a330648c4accfc7dc71.jpg";
                        post_info="http://www.json-generator.com/api/json/get/coTgbrbdDS?indent=2";
                break;
            case "path" :post_pic="http://cdn0.wn.com/ph/img/cf/30/d8afa63811e6f330106a25bf2893-grande.jpg";
                        post_info="http://www.json-generator.com/api/json/get/cuwTpdyeRe?indent=2";
                break;
            case "gur" :post_pic="https://i.dawn.com/large/2016/01/5688c4036ad1b.jpg";
                        post_info="http://www.json-generator.com/api/json/get/cvnEWHlujS?indent=2";
                break;
        }
        Post= (ImageView) findViewById(R.id.imageView2);
        Picasso.with(this).load(post_pic).into(Post);

        pname= (TextView) findViewById(R.id.pname);
        about_post= (TextView) findViewById(R.id.abt);
        detoll=(TextView)findViewById(R.id.dtoll);


        homebtn=(Button) findViewById(R.id.button);
        soldier=(Button) findViewById(R.id.button2);
        paytm=(Button)findViewById(R.id.paytm);
        card=(Button)findViewById(R.id.card);
        bankbtn=(Button)findViewById(R.id.bankno);
        chk=(Button)findViewById(R.id.cheque);


        paytm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Coming soon !",Toast.LENGTH_SHORT).show();
            }
        });

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Coming soon !",Toast.LENGTH_SHORT).show();
            }
        });

        bankbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Donate_to_Post.this);

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

        chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Donate_to_Post.this);

                // Setting Dialog Title
                alertDialog.setTitle("Send the cheques on: ");

                // Setting Dialog Message
                alertDialog.setMessage(Respname);

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
                Intent i = new Intent(Donate_to_Post.this,Home_activity.class);
                startActivity(i);

            }
        });

        soldier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Donate_to_Post.this,Donate_martyr.class);
                startActivity(j);

            }
        });


        // Volley Code

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        makeJsonObjectRequest();


    }

    private void makeJsonObjectRequest() {

        showpDialog();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                post_info, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    // Parsing json object response
                    // response will be a json object
                    String name = response.getString("post_name");
                    String donate = response.getString("donat");
                    String about = response.getString("about_post");
                    String number = response.getString("dtoll");
                    Respemail=response.getString("email");
                 /*   JSONObject phone = response.getJSONObject("phone");
                    String home = phone.getString("home");
                    String mobile = phone.getString("mobile");
*/
                   // jsonResponse = "";
                    Respname = name;
                    Respabout= about + "\n";
                    Respdonate = donate + "\n";
                    Resptoll = number + "\n";

                   // jsonResponse += "Home: " + home + "\n\n";
                    //jsonResponse += "Mobile: " + mobile + "\n\n";

                    pname.setText(Respname);
                    about_post.setText(Respabout);
                    detoll.setText(Resptoll);
                    //bank_det.setText(Respdonate);

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
