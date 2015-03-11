package jk.smarthome.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jk.smarthome.R;
import jk.smarthome.adapters.MyPagerAdapter;

/**
 * Created by jacek on 30-11-2014.
 */
public class SecurityAndSettingsFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static SecurityAndSettingsFragment newInstance(int page, String title) {
        SecurityAndSettingsFragment fragmentFirst = new SecurityAndSettingsFragment();
        Bundle args = new Bundle();
        args.putInt(MyPagerAdapter.KEY_NUM_OF_PAGE, page);
        args.putString(MyPagerAdapter.KEY_TITLE, title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt(MyPagerAdapter.KEY_NUM_OF_PAGE, 0);
        title = getArguments().getString(MyPagerAdapter.KEY_TITLE);
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.security_and_settings_fragment, container, false);

        return view;
    }
}
