package com.forthorn.thorn;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

        // Create items
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.item_main,
                R.drawable.qmui_icon_notify_done, R.color.qmui_config_color_red);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.item_app,
                R.drawable.qmui_icon_notify_info, R.color.qmui_config_color_red);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.item_find,
                R.drawable.qmui_icon_notify_error, R.color.qmui_config_color_red);

        // Add items
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);

        // Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

        // Disable the translation inside the CoordinatorLayout
        bottomNavigation.setBehaviorTranslationEnabled(false);

        // Change colors
        bottomNavigation.setAccentColor(Color.TRANSPARENT);
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));

        // Use colored navigation with circle reveal effect
        bottomNavigation.setColored(true);

        // Set current item programmatically
        bottomNavigation.setCurrentItem(1);
        bottomNavigation.setTitleTextSizeInSp(13, 12);
        bottomNavigation.setUseElevation(true, 2);
        // Set listener
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                // Do something cool here...
                return wasSelected;
            }

        });
    }
}
