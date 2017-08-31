package com.example.mecha.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView webView = (WebView) findViewById(R.id.webview);
        //Para que el JS de la web funcione bien
        webView.getSettings().setJavaScriptEnabled(true);
        //habilito zoom
        webView.getSettings().setBuiltInZoomControls(true);

        webView.loadUrl("http://www.codigofacilito.com");
    }
}
