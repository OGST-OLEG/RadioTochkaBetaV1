package com.example.admin.radiotochkabetav1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        webView = (WebView)findViewById(R.id.webView);
        webView.loadUrl("https://radiotochka.kz");
        webView.getSettings().setJavaScriptEnabled(true);
        WebViewClientImpl webViewClient = new WebViewClientImpl(this);
        webView.setWebViewClient(webViewClient);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    public class WebViewClientImpl extends WebViewClient {

        private Activity activity = null;

        public WebViewClientImpl(Activity activity) {
            this.activity = activity;
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            if(url.indexOf("radiotochka.kz") > -1 ) return false;

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            activity.startActivity(intent);
            return true;
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            webView.loadUrl("https://radiotochka.kz/");
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            webView.loadUrl("https://radiotochka.kz/");
        }else if (id == R.id.nav_combo) {
            webView.loadUrl("https://radiotochka.kz/news/combo/");
        }else if (id == R.id.nav_povod_est) {
            webView.loadUrl("https://radiotochka.kz/povod-est/");
        } else if (id == R.id.nav_kto_vladeet_kz) {
            webView.loadUrl("https://radiotochka.kz/news/kto-vladeet-kz/");
        } else if (id == R.id.nav_lifehak) {
            webView.loadUrl("https://radiotochka.kz/news/lifehak/");
        } else if (id == R.id.nav_multimedia) {
            webView.loadUrl("https://radiotochka.kz/news/multimedia/");
        }else if (id == R.id.nav_interviu) {
            webView.loadUrl("https://radiotochka.kz/news/interview/");
        }else if (id == R.id.nav_afisha) {
            webView.loadUrl("https://radiotochka.kz/news/afisha/");
        }else if (id == R.id.nav_gde_dengi) {
            webView.loadUrl("https://radiotochka.kz/news/gde-dengi/");
        }else if (id == R.id.nav_sport) {
            webView.loadUrl("https://radiotochka.kz/news/sport");
        }else if (id == R.id.nav_news) {
            webView.loadUrl("https://radiotochka.kz/news/news_feed/");
        }else if (id == R.id.nav_oprogramme) {

        }else if (id == R.id.nav_exit) {
            System.exit(0);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
