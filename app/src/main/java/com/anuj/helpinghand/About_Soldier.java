package com.anuj.helpinghand;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

public class About_Soldier extends AppCompatActivity {

    int pos;
    String pname,info,img;
    TextView sname, content ;
    private String Respname;
    private String Respabout;
    private String phn;
    private String Respdonate;
    private String Respemail;
    private String Respadd;
    Button paytm_pay, card_pay, bank_pay, cheque_pay,homebtn,post;
    private static String TAG = Donate_to_Post.class.getSimpleName();
    private ProgressDialog pDialog;
    ImageView image;

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
        image=(ImageView)findViewById(R.id.img);

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
                bank_alrt();
            }
        });

        cheque_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chq_alrt();
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
        Glide.with(About_Soldier.this).load(img).into(image);
        makeJsonObjectRequest();

    }

    private void chq_alrt() {
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

        alertDialog.setNeutralButton("Call", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: "+phn));
                if (ActivityCompat.checkSelfPermission(About_Soldier.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);

            }
        });


        // Showing Alert Message
        alertDialog.show();

    }

    private void bank_alrt() {

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

        alertDialog.setNeutralButton("Call", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: "+phn));
                if (ActivityCompat.checkSelfPermission(About_Soldier.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);

            }
        });

        // Showing Alert Message
        alertDialog.show();

    }

    private void contentforact() {
        if(pname.equals("hand")){

            switch (pos){

                case 0: info="http://www.json-generator.com/api/json/get/bTHyCusNhK?indent=2";
                        img="http://images.financialexpress.com/2016/09/uridead-1.jpg";
                    break;
                case 1: info="http://www.json-generator.com/api/json/get/bVbPkQCFrC?indent=2";
                        img="http://static.gulfnews.com/polopoly_fs/1.1899505!/image/1163286019.jpg_gen/derivatives/box_460346/1163286019.jpg";
                    break;
                case 2: info="http://www.json-generator.com/api/json/get/cccKmynhWq?indent=2";
                        img="http://news.xinhuanet.com/english/photo/2016-02/23/135122711_14561952977811n.jpg";
                    break;
                case 3: info="http://www.json-generator.com/api/json/get/bMTCyCQBYO?indent=2";
                        img="http://news.xinhuanet.com/english/photo/2016-02/23/135122711_14561952977811n.jpg";
                    break;
                case 4: info="http://www.json-generator.com/api/json/get/bXdbjGnote?indent=2";
                        img="http://bsmedia.business-standard.com/_media/bs/img/photo-gallery/current-affairs/final-journey-of-pampore-martyr/full/final-journey-of-pampore-martyr-14561491513047.jpg";

                    break;
                case 5: info="http://www.json-generator.com/api/json/get/bUznTcdJQi?indent=2";
                        img="http://www.freepressjournal.in/wp-content/uploads/2016/02/22B3-JAWAN-300x201.jpg";
                    break;
                case 6: info="http://www.json-generator.com/api/json/get/cbInVYDGMi?indent=2";
                        img="http://media2.intoday.in/dailyo//story/embed/201601/saif1mbed_010416021415.jpg";
                    break;
                case 7: info="http://www.json-generator.com/api/json/get/bRgJRLRZmG?indent=2";
                        img="http://media.indiatimes.in/media/content/2016/Jan/16_1451886694.jpg";
                    break;
                case 8: info="http://www.json-generator.com/api/json/get/bQZNucmHma?indent=2";
                        img="http://drop.ndtv.com/albums/NEWS/army-jawans/soldier_gal2.jpg";
                    break;
                case 9: info="http://www.json-generator.com/api/json/get/chWKHcnQXS?indent=2";
                        img="http://www.freepressjournal.in/wp-content/uploads/2016/02/22B3-JAWAN-300x201.jpg";
                    break;
            }}

        else if (pname.equals("bara")){
            switch (pos){

                case 0: info="http://www.json-generator.com/api/json/get/bICvGjAROW?indent=2";
                        img="http://m.hindustantimes.com/Images/popup/2015/6/Prakash1.jpg";
                    break;
                case 1: info="http://www.json-generator.com/api/json/get/cwmozBSYWG?indent=2";
                        img="https://jansattawpcontent.s3.amazonaws.com/uploads/2015/06/Manipur-ambush-himachal-pradesh.jpg";
                    break;
                case 2: info="http://www.json-generator.com/api/json/get/cdFDOIYgOa?indent=2";
                        img="http://cdn.deccanchronicle.com/sites/default/files/manipur-ambush-1.jpg";
                    break;
                case 3: info="http://www.json-generator.com/api/json/get/bXvgCPCjyq?indent=2";
                        img="http://static.dnaindia.com/sites/default/files/2015/06/06/343620-manipur1.jpg";
                    break;
                case 4: info="http://www.json-generator.com/api/json/get/cerjiHxaEO?indent=2";
                        img="http://img.amarujala.com/2015/06/05/manipur-ambush-7-jawan-from-himachal-5571e39f784b0_exlst.jpg";
                    break;
                case 5: info="http://www.json-generator.com/api/json/get/bTdZKwmzoy?indent=2";
                        img="http://www.e-pao.net/galleries/images/News_Related/IGP_Ambush_200601_4.jpg";
                    break;
                case 6: info="http://www.json-generator.com/api/json/get/cnqfkrzjxe?indent=2";
                        img="http://www.infokhyberpakhtunkhwa.gov.pk/doit/foin-tada/uploads/2014/12/24-12-14-CM-Photo-E-Mrs.Aamara-Khattak-Wife-of-KP-Chief-Minister-offering-fateha-for-late-Tahira-Qazi-martyred-school-principal-of-Peshawar-terror-incident..jpg";
                    break;
                case 7: info="http://www.json-generator.com/api/json/get/bVfbNyJSrm?indent=2";
                        img="http://images.indianexpress.com/2016/08/jharkhand1.jpg";
                    break;
                case 8: info="http://www.json-generator.com/api/json/get/cohhSVJOnC?indent=2";
                        img="http://newsrepublica.com/wp-content/uploads/2016/09/Reason-to-Why-did-India-bury-Uri-militants-just-one-day-after-the-attack.jpg";
                    break;
                case 9: info="http://www.json-generator.com/api/json/get/cnQVxSpmZK?indent=2";
                        img="http://static.dnaindia.com/sites/default/files/styles/square/public/2016/01/05/411464-niranjan-kumar-funeral-pti.jpg";
                    break;
            }
        }

        else if (pname.equals("uri")){
            switch (pos){

                case 0: info="http://www.json-generator.com/api/json/get/ccOvIYGtAi?indent=2";
                        img="http://images.indianexpress.com/2016/09/uri-martyr-4-7591.jpg";
                    break;
                case 1: info="http://www.json-generator.com/api/json/get/bNzYnmzhnS?indent=2";
                        img="http://images.indianexpress.com/2016/09/funeral-2-003.jpg?w=820?w=692";
                    break;
                case 2: info="http://www.json-generator.com/api/json/get/bTPFeuLtfm?indent=2";
                        img="http://images.indianexpress.com/2016/09/pti9_20_2016_000156a-007.jpg?w=820?w=720";
                    break;
                case 3: info="http://www.json-generator.com/api/json/get/cmjSalpolK?indent=2";
                        img="https://quintype-01.imgix.net/thequint%2F2016-09%2F036e01f1-35c7-44dc-94de-14eab0e7fc08%2Furi%20martyrs-pti.jpg?auto=format&q=60&w=976&fm=pjpg";
                    break;
                case 4: info="http://www.json-generator.com/api/json/get/bSmRELUMaG?indent=2";
                        img="http://images.indianexpress.com/2016/09/pti9_20_2016_000224b-010.jpg?w=820?w=540";
                    break;
                case 5: info="http://www.json-generator.com/api/json/get/cnpZNlsaZK?indent=2";
                        img="http://m.hindustantimes.com/Images/popup/2015/6/Prakash1.jpg";
                    break;
                case 6: info="http://www.json-generator.com/api/json/get/bRBgilBAwO?indent=2";
                        img="http://m.hindustantimes.com/rf/image_size_640x362/HT/p2/2016/09/19/Pictures/_45fa14da-7e42-11e6-b856-2be417b599e5.jpg";
                    break;
                case 7: info="http://www.json-generator.com/api/json/get/cpCwbBAYPm?indent=2";
                        img="http://images.indianexpress.com/2015/11/colonel-759.jpg";
                    break;
                case 8: info="http://www.json-generator.com/api/json/get/bVQTEiPcrS?indent=2";
                        img="http://www.sanjhamorcha.com/wp-content/uploads/2015/11/2015_11largeimg20_Friday_2015_011020394.jpg";
                    break;
                case 9: info="http://www.json-generator.com/api/json/get/bXpZxdIKle?indent=2";
                        img="http://newseastwest.com/wp-content/uploads/2013/01/army-chief-copy.jpg";
                    break;
            }
        }

        else if (pname.equals("pam")){
            switch (pos){

                case 0: info="http://www.json-generator.com/api/json/get/bLSUPFzizS?indent=2";
                        img="https://cdn2.newsok.biz/cache/r960-abfe4ec62135a3f6d170f0b43632b7f5.jpg";
                    break;
                case 1: info="http://www.json-generator.com/api/json/get/coSNmUiIeq?indent=2";
                        img="http://static.dnaindia.com/images/cache/1874610.jpg";
                    break;
                case 2: info="http://www.json-generator.com/api/json/get/bZhulRQLCa?indent=2";
                        img="http://im.rediff.com/news/2016/sep/20uri-martyr8.jpg";
                    break;
                case 3: info="http://www.json-generator.com/api/json/get/csthFDfZki?indent=2";
                        img="http://media2.intoday.in/indiatoday/images/stories/naik-family1_660_011013100516.jpg";
                    break;
                case 4: info="http://www.json-generator.com/api/json/get/bHxEZWCWDC?indent=2";
                    img="http://i.dailymail.co.uk/i/pix/2016/02/09/21/3108A95D00000578-3439519-image-a-19_1455055134049.jpg";
                    break;
                case 5: info="http://www.json-generator.com/api/json/get/cqUbMImrqW?indent=2";
                        img="http://www.udupitoday.com/udtoday/images/uploads/March/images/mar1518ravi3.jpg";
                    break;
                case 6: info="http://www.json-generator.com/api/json/get/bOVVEQPlmG?indent=2";
                        img="http://1.bp.blogspot.com/-5GK4bXmWzKU/Ue9l9OHMFoI/AAAAAAAAC5I/kHVB1JKk3As/s1600/Manjula-Vijayakumar-funeral-ceremony-in-pics.JPG";
                    break;
                case 7: info="http://www.json-generator.com/api/json/get/cosYngIdsO?indent=2";
                        img="http://4.bp.blogspot.com/-9TjfqYIP_nw/Ue9mVVLR-PI/AAAAAAAAC9E/kZtWpH2n6cA/s1600/Vijayakanth-Manjula-Vijayakumar-funeral-ceremony.JPG";
                    break;
                case 8: info="http://www.json-generator.com/api/json/get/bNQkIpTIBK?indent=2";
                        img="http://german.fansshare.com/images/manjulavijayakumar/actress-manjula-vijayakumar-death-ceremony-2071015511.jpg";
                    break;
                case 9: info="http://www.json-generator.com/api/json/get/cejGYYmXhe?indent=2";
                        img="http://portugese.fansshare.com/images/manjulavijayakumar/actress-manjula-vijayakumar-death-ceremony-tv-1004419987.jpg";
                    break;
            }
        }

        else if (pname.equals("path"))
        {
            switch (pos){

                case 0: info="http://www.json-generator.com/api/json/get/ciTsQPqXAO?indent=2";
                        img="http://www.fansshare.com/images/manjulavijayakumar/actress-manjula-vijayakumar-death-ceremony-jpg-86100759.jpg";
                    break;
                case 1: info="http://www.json-generator.com/api/json/get/bOBQcosCsy?indent=2";
                        img="http://images.indianexpress.com/2016/09/uri-attack-martyr-7591.jpg";
                    break;
                case 2: info="http://www.json-generator.com/api/json/get/ccOSBlCrma?indent=2";
                        img="http://m.hindustantimes.com/Images/popup/2014/12/08_12_14-metro09b.jpg";
                    break;
                case 3: info="http://www.json-generator.com/api/json/get/coKGKTQcgO?indent=2";
                        img="http://media2.intoday.in/indiatoday/images/stories/uri-attack-story_647_092116124441.jpg";
                    break;
                case 4: info="http://www.json-generator.com/api/json/get/cjZdNqmAlK?indent=2";
                        img="http://m.hindustantimes.com/rf/image_size_640x362/HT/p2/2016/09/19/Pictures/_d8704a10-7e41-11e6-b856-2be417b599e5.jpg";
                    break;
                case 5: info="http://www.json-generator.com/api/json/get/bTIcULBpHC?indent=2";
                        img="http://bsmedia.business-standard.com/_media/bs/img/photo-gallery/general/uri-attack-gun-salute-teary-farewell-to-martyrs/full/family-members-of-sepoy-gangadhar-dolui-who-was-martyred-in-uri-attack-14743651943365.jpg";
                    break;
                case 6: info="http://www.json-generator.com/api/json/get/ccANiwalCG?indent=2";
                        img="http://morungexpress.com/wp-content/uploads/2016/09/2016-09-19T164032Z_1_LYNXNPEC8I138_RTROPTP_3_INDIA-KASHMIR.jpg";
                    break;
                case 7: info="http://www.json-generator.com/api/json/get/cqijVYhhqq?indent=2";
                        img="http://i.dawn.com/large/2016/03/56f9ae25e606b.jpg";
                    break;
                case 8: info="http://www.json-generator.com/api/json/get/bMZcCFBVnS?indent=2";
                        img="http://dc-cdn.s3-ap-southeast-1.amazonaws.com/3444a6d9cab1c5c77563ea2a03856b7bd72aeba9-tc-img-preview.jpg";
                    break;
                case 9: info="http://www.json-generator.com/api/json/get/bSeyLZZkrS?indent=2";
                        img="http://images.indianexpress.com/2016/09/uri-jawan.jpg";
                    break;
            }
        }

        else {
            switch (pos){

                case 0: info="http://www.json-generator.com/api/json/get/coLldkYEGG?indent=2";
                        img="http://www.biharnow.in/wp-content/uploads/2016/09/parents-of-Uri-terror-attcak.jpg";
                    break;
                case 1: info="http://www.json-generator.com/api/json/get/cickLeZkmW?indent=2";
                        img="http://media2.intoday.in/indiatoday/images/Photo_gallery/ravi_091916081932.jpg";
                    break;
                case 2: info="http://www.json-generator.com/api/json/get/clGmKBTAEi?indent=2";
                        img="http://m.hindustantimes.com/rf/image_size_640x362/HT/p2/2016/09/19/Pictures/_45fa14da-7e42-11e6-b856-2be417b599e5.jpg";
                    break;
                case 3: info="http://www.json-generator.com/api/json/get/cgmTPMdBSG?indent=2";
                        img="http://media2.intoday.in/indiatoday/images/stories/amit-shah-farmer-suicide-story_650_042515095735.jpg";
                    break;
                case 4: info="http://www.json-generator.com/api/json/get/bKhARNNHsi?indent=2";
                        img="http://www.outlookindia.com/public/uploads/gallery/20150729/badal_athankot20150729_350_630.jpg";
                    break;
                case 5: info="http://www.json-generator.com/api/json/get/cvMaMrjiqa?indent=2";
                        img="http://www.yespunjab.com/images/punjab/baljeet-singh-cremated-bada.jpg";
                    break;
                case 6: info="http://www.json-generator.com/api/json/get/bGsPBrUvsi?indent=2";
                        img="http://cdn.deccanchronicle.com/sites/default/files/Martyred_Armyman_family_member_PTI_0_0.jpg";
                    break;
                case 7: info="http://www.json-generator.com/api/json/get/bYrOMCFqbm?indent=2";
                        img="http://media2.intoday.in/indiatoday/images/stories/uri-attack-story_647_092116124441.jpg";
                    break;
                case 8: info="http://www.json-generator.com/api/json/get/bGCQdyLXuG?indent=2";
                        img="http://images.indianexpress.com/2016/01/badal-main.jpg";
                    break;
                case 9: info="http://www.json-generator.com/api/json/get/cnqwFynYLC?indent=2";
                        img="http://www.teluguroommate.com/uploads/articles/image_1452056321568c9f0184304.jpg";
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
                    phn=response.getString("phn");
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
