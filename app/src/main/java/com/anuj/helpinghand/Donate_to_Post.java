package com.anuj.helpinghand;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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
    TextView pname,about_post,detoll,bank_det;
    Button homebtn,soldier;

    private static String TAG = Donate_to_Post.class.getSimpleName();
    // Progress dialog
    private ProgressDialog pDialog;

//    private TextView txtResponse;

    // temporary string to show the parsed response
    private String Respname,Respabout,Resptoll,Respdonate;
    public String urlJsonObj="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_to__post);


        SharedPreferences ef = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String post = ef.getString("post", "");

        SharedPreferences gh = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        urlJsonObj=gh.getString("ac", "");

        Post= (ImageView) findViewById(R.id.imageView2);
        Picasso.with(this).load(post).into(Post);

        pname= (TextView) findViewById(R.id.pname);
        about_post= (TextView) findViewById(R.id.abt);
        detoll=(TextView)findViewById(R.id.dtoll);
        bank_det=(TextView)findViewById(R.id.bankdet);

        homebtn=(Button) findViewById(R.id.button);
        soldier=(Button) findViewById(R.id.button2);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Donate_to_Post.this,Home_activity.class);
                startActivity(i);
                finish();
            }
        });

        soldier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Donate_to_Post.this,Donate_martyr.class);
                startActivity(j);
                finish();
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
                urlJsonObj, null, new Response.Listener<JSONObject>() {

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
                    bank_det.setText(Respdonate);

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
