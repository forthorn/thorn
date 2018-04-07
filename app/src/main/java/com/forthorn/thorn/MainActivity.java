package com.forthorn.thorn;

import android.graphics.Color;
import android.os.Bundle;

import com.forthorn.thorn_ui.ahbottomnavigation.AHBottomNavigation;
import com.forthorn.thorn_ui.ahbottomnavigation.AHBottomNavigationItem;

import me.yokeyword.fragmentation.SupportActivity;

public class MainActivity extends SupportActivity implements AHBottomNavigation.OnTabSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

        // Create items
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.item_main,
                R.drawable.app, R.color.color_white);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.item_app,
                R.drawable.atm, R.color.color_white);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.item_main,
                R.drawable.courier, R.color.color_white);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.item_app,
                R.drawable.favorites, R.color.color_white);
        AHBottomNavigationItem item5 = new AHBottomNavigationItem(R.string.item_main,
                R.drawable.app, R.color.color_white);

        // Add items
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item4);
        bottomNavigation.addItem(item5);

        bottomNavigation.setBehaviorTranslationEnabled(false);
        bottomNavigation.setColoredModeColors(Color.RED, Color.GRAY);
        bottomNavigation.setColored(true);
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        bottomNavigation.setCurrentItem(0);
        bottomNavigation.setTitleTextSizeInSp(11, 10);
        bottomNavigation.setUseElevation(true, 2);
        bottomNavigation.setOnTabSelectedListener(this);
    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {

        return true;
    }
}
