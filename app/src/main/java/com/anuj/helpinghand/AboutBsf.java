package com.anuj.helpinghand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutBsf extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_bsf);
        overridePendingTransition(R.animator.left_in, R.animator.left_out);

        WebView myWebView = (WebView) findViewById(R.id.web);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("http://joinindianarmy.nic.in/");


    }
}
