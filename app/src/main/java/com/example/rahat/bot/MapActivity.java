package com.example.rahat.bot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.rahat.bot.R;

public class MapActivity extends AppCompatActivity {

    //Define URL
    private static final String URL = "http://www.educationboardresults.gov.bd/";
    //Define WebView
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);



        webView = (WebView)findViewById(R.id.webview); //get webView
        webView.setWebViewClient(new WebViewClient()); //set webView client
        WebSettings webSettings = webView.getSettings();// initiate webView settings
        webSettings.setJavaScriptEnabled(true); //allow webView perform javascript
        webSettings.setBuiltInZoomControls(true); //show zoom control
        webView.loadUrl(URL); //load URL




    }
}