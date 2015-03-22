package jk.smarthome.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jk.smarthome.SmartHomeApplication;
import jk.smarthome.R;
import jk.smarthome.adapters.AlertListAdapter;
import jk.smarthome.adapters.ApplianceStateListAdapter;
import jk.smarthome.adapters.MyPagerAdapter;
import jk.smarthome.models.Alert;
import jk.smarthome.models.ApplienceState;
import jk.smarthome.models.Room;

/**
 * Created by jacek on 30-11-2014.
 */
public class NotificationsFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;
    TextView brokenIntoNotificationTV;

    ListView alertListView;
    ListView stateListView;

    View rootView;


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
        rootView = inflater.inflate(R.layout.notifications_fragment, container, false);

        List<Room> roomList = ((SmartHomeApplication)getActivity().getApplication()).getRoomList();

        setAlertListView(rootView, getAlertList(roomList));

        setStateListView(rootView, getApplienceStates(roomList));

        rootView.findViewById(R.id.refresh_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshStateList();
            }
        });


        return rootView;
    }

    private List<ApplienceState> getApplienceStates(List<Room> roomList){

        List<ApplienceState> applienceStates = new ArrayList<>();

        for(Room room : roomList){
            if(room.getAppliances() != null){
                for(Map.Entry<String, String> entry : room.getAppliances().entrySet()){
                    if(entry.getValue() != null){
                        //Toast.makeText(getActivity(), entry.getValue(), Toast.LENGTH_SHORT).show();
                        String applianceText = entry.getKey() + ": " + entry.getValue();
                        ApplienceState state = new ApplienceState(applianceText, room.getName());
                        applienceStates.add(state);
                    }
                }
            }
        }

        return applienceStates;
    }

    public void setStateListView (View view, List<ApplienceState> stateList) {

        stateListView = (ListView) view.findViewById(R.id.applianceListView);

        ApplianceStateListAdapter stateListAdapter = new ApplianceStateListAdapter(getActivity(), stateList);

        stateListView.setAdapter(stateListAdapter);

    }

    private List<Alert> getAlertList(List<Room> roomList){
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
        return alertList;
    }

    public void setAlertListView(View view, List<Alert> alertList) {

        alertListView = (ListView) view.findViewById(R.id.alertListView);

        AlertListAdapter alertListAdapter = new AlertListAdapter(getActivity(), alertList);

        alertListView.setAdapter(alertListAdapter);

    }

    public void refreshStateList(){
        if(stateListView != null){
            ((ApplianceStateListAdapter) stateListView.getAdapter()).notifyDataSetChanged();
            ((ApplianceStateListAdapter) stateListView.getAdapter()).notifyDataSetInvalidated();
        }

        List<Room> roomList = ((SmartHomeApplication)getActivity().getApplication()).getRoomList();

        setAlertListView(rootView, getAlertList(roomList));

        setStateListView(rootView, getApplienceStates(roomList));
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}

