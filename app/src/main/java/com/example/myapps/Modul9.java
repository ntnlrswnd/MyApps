package com.example.myapps;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import androidx.core.content.ContextCompat;

@SuppressWarnings("deprecation") // TabActivity deprecated
public class Modul9 extends TabActivity {
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul9);

        tabHost = getTabHost();

        addNewTab(this, tabHost, "tab1", "Tab 1", R.drawable.ic_launcher_background, new Intent(this, Tab1.class));
        addNewTab(this, tabHost, "tab2", "Tab 2", R.drawable.ic_launcher_background, new Intent(this, Tab2.class));
        addNewTab(this, tabHost, "tab3", "Tab 3", R.drawable.ic_launcher_background, new Intent(this, Tab3.class));

        tabHost.setCurrentTab(0);
    }

    private void addNewTab(Context context, TabHost tabHost, String tag, String title, int icon, Intent intent) {
        TabHost.TabSpec tabSpec = tabHost.newTabSpec(tag);
        tabSpec.setIndicator(title, ContextCompat.getDrawable(context, icon));
        tabSpec.setContent(intent);
        tabHost.addTab(tabSpec);
    }
}
