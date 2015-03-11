package jk.smarthome.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

import jk.smarthome.SmartHomeApplication;
import jk.smarthome.R;
import jk.smarthome.adapters.AlertListAdapter;
import jk.smarthome.adapters.MyPagerAdapter;
import jk.smarthome.adapters.RoomsListAdapter;
import jk.smarthome.models.Alert;
import jk.smarthome.models.Room;

/**
 * Created by jacek on 30-11-2014.
 */
public class NotificationsFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;
    TextView brokenIntoNotificationTV;

    // newInstance constructor for creating fragment with arguments
    public static NotificationsFragment newInstance(int page, String title) {
        NotificationsFragment fragmentFirst = new NotificationsFragment();
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
        View view = inflater.inflate(R.layout.notifications_fragment, container, false);

       List<Room> roomList = ((SmartHomeApplication)getActivity().getApplication()).getRoomList();

       List<Alert> alertList = new ArrayList<>();

        for (Room room : roomList){

            String roomName = room.getName();

            if (room.isOpenTap() == true){

                String alertText = getString(R.string.tap_open_alert);
                Alert openTapAlert = new Alert(alertText, roomName);

                alertList.add(openTapAlert);
            }

            if(room.isFloodDetected() == true){

                String alertText = getString(R.string.flood_alert);
                Alert floodAlert = new Alert(alertText, roomName);

                alertList.add(floodAlert);
            }

            if(room.isCarbonMonoxideDetected() == true){

                String alertText = getString(R.string.carbon_monoxide_alert);
                Alert carbonMonoxideAlert = new Alert(alertText, roomName);

                alertList.add(carbonMonoxideAlert);
            }

            if(room.isMovementDetected() == true){

                String alertText = getString(R.string.unexpected_movement_alert);
                Alert unexpectedMovementAlert = new Alert(alertText, roomName);

                alertList.add(unexpectedMovementAlert);
            }

            if(room.isBrokenInto() == true) {

                String alertText = getString(R.string.break_in_alert);
                Alert breakInAlert = new Alert(alertText, roomName);

                alertList.add(breakInAlert);
            }

            if(room.isFireDetected() == true){

                String alertText = getString(R.string.fire_alert);
                Alert fireAlert = new Alert(alertText, roomName);

                alertList.add(fireAlert);
            }

        }

        setListView(view, alertList);


        return view;
    }

    public void setListView (View view, List<Alert> alertList) {

        ListView alertListView = (ListView) view.findViewById(R.id.alertListView);

        AlertListAdapter alertListAdapter = new AlertListAdapter(getActivity(), alertList);

        alertListView.setAdapter(alertListAdapter);



    }
}

