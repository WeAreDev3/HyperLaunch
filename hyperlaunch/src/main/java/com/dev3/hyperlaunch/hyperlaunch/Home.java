package com.dev3.hyperlaunch.hyperlaunch;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initWebView((WebView) findViewById(R.id.webView));
    }

    public void initWebView (WebView webView) {
        webView.setBackgroundColor(0x00000000);
        webView.loadUrl("file:///android_asset/main.html");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.addJavascriptInterface(new WebInterface(this), "Launcher");
    }

}
