package jk.smarthome.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import jk.smarthome.fragments.NotificationsFragment;
import jk.smarthome.fragments.OutdoorFragment;
import jk.smarthome.fragments.RoomControlFragment;
import jk.smarthome.fragments.SecurityAndSettingsFragment;

/**
 * Created by jacek on 30-11-2014.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    public static final String KEY_NUM_OF_PAGE = "key_num_of_page";
    public static final String KEY_TITLE = "key_title";

    private static int NUM_ITEMS = 4;

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return NotificationsFragment.newInstance(0, "Notification Panel");
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return RoomControlFragment.newInstance(1, "Room Control");
            case 2: // Fragment # 1 - This will show SecondFragment
                return RoomControlFragment.newInstance(2, "Outside Control");
            case 3:
                return RoomControlFragment.newInstance(3, "Security and Settings");
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        //return "strona" + position;
        return getItem(position).getArguments().getString(KEY_TITLE, "NO TITLE");
    }

}




