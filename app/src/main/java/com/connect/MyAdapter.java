package com.connect;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentManager;

import org.jetbrains.annotations.NotNull;

class MyAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    public MyAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }
    @NotNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Chats();
            case 1:
                return new Status();
            case 2:
                return new Profile();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}