package jk.smarthome.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import jk.smarthome.R;
import jk.smarthome.adapters.MyPagerAdapter;

/**
 * Created by jacek on 30-11-2014.
 */
public class OutdoorFragment extends Fragment  {
    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static OutdoorFragment newInstance(int page, String title) {
        OutdoorFragment fragmentFirst = new OutdoorFragment();
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
        View view = inflater.inflate(R.layout.outdoor_fragment, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
        tvLabel.setText(page + " -- " + title);

        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        return view;


    }
}
