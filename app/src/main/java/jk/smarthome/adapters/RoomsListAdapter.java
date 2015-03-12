package jk.smarthome.adapters;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import jk.smarthome.ParentActivity;
import jk.smarthome.R;
import jk.smarthome.fragments.appliances.OvenDialogFragment;
import jk.smarthome.models.Room;

/**
 * Created by jacek on 02-12-2014.
 */
public class RoomsListAdapter extends BaseAdapter {

    private Context context;
    private List<Room> roomList;
    LayoutInflater layoutInflater;

    public RoomsListAdapter(Context context, List<Room> roomList) {

        this.context = context;
        this.roomList = roomList;

        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return roomList.size();
    }

    @Override
    public Object getItem(int position) {
        return roomList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return roomList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.room_list_item, parent, false);

        TextView roomTitleTv = (TextView) view.findViewById(R.id.roomNameTV);

        LinearLayout humidityLayout = (LinearLayout) view.findViewById(R.id.humidityLayout);
        LinearLayout brokenInIntoLayout = (LinearLayout) view.findViewById(R.id.brokenIntoLayout);
        LinearLayout fireDetectedLayout = (LinearLayout) view.findViewById(R.id.fireDetectedLayout);
        LinearLayout carbonMonoxideDetectedLayout = (LinearLayout) view.findViewById(R.id.carbonMonoxideDetectedLayout);
        LinearLayout floodDetectedLayout = (LinearLayout) view.findViewById(R.id.floodDetectedLayout);
        LinearLayout movementDetectedLayout = (LinearLayout) view.findViewById(R.id.movementDetectedLayout);
        LinearLayout openTapLayout = (LinearLayout) view.findViewById(R.id.openTapLayout);
        LinearLayout bathtubLayout = (LinearLayout) view.findViewById(R.id.bathtubLayout);
        LinearLayout washingMachineLayout = (LinearLayout) view.findViewById(R.id.washingMachineLayout);
        LinearLayout ovenLayout = (LinearLayout) view.findViewById(R.id.ovenLayout);
        LinearLayout dishwasherLayout = (LinearLayout) view.findViewById(R.id.dishwasherLayout);
        LinearLayout refrigeratorLayout = (LinearLayout) view.findViewById(R.id.refrigeratorLayout);
        LinearLayout bedsideLeftLighLayout = (LinearLayout) view.findViewById(R.id.bedsideLeftLightLayout);
        LinearLayout bedsideRightLightLayout = (LinearLayout) view.findViewById(R.id.bedsideRightLightLayout);
        LinearLayout ceilingLightLayout = (LinearLayout) view.findViewById(R.id.ceilingLightLayout);
        LinearLayout wallLightLayout = (LinearLayout) view.findViewById(R.id.wallLightLayout);

        TextView temperatureTV = (TextView) view.findViewById(R.id.temperatureTV);
        TextView humidityTV = (TextView) view.findViewById(R.id.humidityTV);
        TextView presenceTV = (TextView) view.findViewById(R.id.presenceTV);
        TextView openDoorTV = (TextView) view.findViewById(R.id.openDoorTV);
        TextView openWindowTV = (TextView) view.findViewById(R.id.openWindowTV);
        TextView bedsideLeftLightTV = (TextView) view.findViewById(R.id.bedsideLeftLightTV);
        TextView bedsideRightLightTV = (TextView) view.findViewById(R.id.bedsideRightLightTV);

        Button cameraPreviewButton = (Button) view.findViewById(R.id.cameraPreviewButton);
        Button bathtubMenuButton = (Button) view.findViewById(R.id.bathtubMenuButton);
        Button washingMachineMenuButton  = (Button) view.findViewById(R.id.washingMachineMenuButton);
        Button ovenMenuButton  = (Button) view.findViewById(R.id.ovenMenuButton);
        Button refrigeratorMenuButton  = (Button) view.findViewById(R.id.refrigeratorMenuButton);
        Button dishwasherMenuButton  = (Button) view.findViewById(R.id.dishwasherMenuButton);


        final Switch cameraSwitch = (Switch) view.findViewById(R.id.cameraSwitch);
        final Switch ceilingLightSwitch = (Switch) view.findViewById(R.id.ceilingLightSwitch);
        final Switch wallLightSwitch = (Switch) view.findViewById(R.id.wallLightSwitch);
        final Switch bedsideLeftLightSwitch = (Switch) view.findViewById(R.id.bedsideLeftLightSwitch);
        final Switch bedsideRightLightSwitch = (Switch) view.findViewById(R.id.bedsideRightLightSwitch);


        Room room = roomList.get(position);
        roomTitleTv.setText(roomList.get(position).getName());



        cameraSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    cameraSwitch.setText("Camera is recording");
                } else {
                    cameraSwitch.setText("Camera on standby");
                }
            }
        });

        if(room.isBrokenInto() == true){
            brokenInIntoLayout.setVisibility(View.VISIBLE);
        } else {
            brokenInIntoLayout.setVisibility(View.GONE);
        }

        if(room.isFireDetected() == true){
            fireDetectedLayout.setVisibility(View.VISIBLE);
        } else {
            fireDetectedLayout.setVisibility(View.GONE);
        }

        if (room.isCarbonMonoxideDetected() == true){
            carbonMonoxideDetectedLayout.setVisibility(View.VISIBLE);
        } else {
            carbonMonoxideDetectedLayout.setVisibility(View.GONE);
        }

        if(room.isFloodDetected() == true){
            floodDetectedLayout.setVisibility(View.VISIBLE);
        } else {
            floodDetectedLayout.setVisibility(View.GONE);
        }

        if (room.isOpenTap() == true){
            openTapLayout.setVisibility(View.VISIBLE);
        } else {
            openTapLayout.setVisibility(View.GONE);
        }

        if (room.isMovementDetected() == true){
            movementDetectedLayout.setVisibility(View.VISIBLE);
        } else {
            movementDetectedLayout.setVisibility(View.GONE);
        }

        if (room.getName() ==  "Kitchen"){
            dishwasherLayout.setVisibility(View.VISIBLE);
        } else {
            dishwasherLayout.setVisibility(View.GONE);
        }

        if(room.getName() == "Kitchen"){
            ovenLayout.setVisibility(View.VISIBLE);
        } else {
            ovenLayout.setVisibility(View.GONE);
        }

        if(room.getName() == "Kitchen"){
            refrigeratorLayout.setVisibility(View.VISIBLE);
        } else {
            refrigeratorLayout.setVisibility(View.GONE);
        }

        if (room.getName() == "Bathroom"){
            bathtubLayout.setVisibility(View.VISIBLE);
        } else {
            bathtubLayout.setVisibility(View.GONE);
        }

        if(room.getName() == "Bathroom"){
            washingMachineLayout.setVisibility(View.VISIBLE);
        } else {
            washingMachineLayout.setVisibility(View.GONE);
        }

        temperatureTV.setText(""+room.getTemperature()+"°C");
        humidityTV.setText(""+room.getHumidity()+"%");

        if(room.getName() == "Master Bedroom"){
            bedsideLeftLighLayout.setVisibility(View.VISIBLE);
            bedsideRightLightLayout.setVisibility(View.VISIBLE);
            bedsideLeftLightTV.setVisibility(View.VISIBLE);
            bedsideRightLightTV.setVisibility(View.VISIBLE);
        } else {
            bedsideLeftLighLayout.setVisibility(View.GONE);
            bedsideRightLightLayout.setVisibility(View.GONE);
            bedsideLeftLightTV.setVisibility(View.GONE);
            bedsideRightLightTV.setVisibility(View.GONE);
        }

        setBedsideLightSwitches(bedsideLeftLightSwitch, bedsideRightLightSwitch);

        setKitchenOvenButton(ovenMenuButton);
        setKitchenRefrigeratorButton(refrigeratorMenuButton);
        setKitchenDishwasherButton(dishwasherMenuButton);

        return view;
    }

    private void setKitchenOvenButton(Button ovenButton){
        ovenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm =  ((ParentActivity)context).getSupportFragmentManager();
                fm.beginTransaction().add(OvenDialogFragment.newInstance(), "OvenDialogFragment").commit();
            }
        });
    }

    private void setKitchenRefrigeratorButton(Button refrigeratorButton){
        refrigeratorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm =  ((ParentActivity)context).getSupportFragmentManager();
                fm.beginTransaction().add(OvenDialogFragment.newInstance(), "RefrigeratorDialogFragment").commit();
            }
        });
    }

    private void setKitchenDishwasherButton(Button dishwasherButton){
        dishwasherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm =  ((ParentActivity)context).getSupportFragmentManager();
                fm.beginTransaction().add(OvenDialogFragment.newInstance(), "DishwasherDialogFragment").commit();
            }
        });
    }

    private void setBedsideLightSwitches(Switch leftSwitch, Switch rightSwitch){

        leftSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    ((ParentActivity) context).sendData("1");
                    Toast.makeText(context, "Left bedside lamp on", Toast.LENGTH_SHORT).show();
                } else {
                    ((ParentActivity) context).sendData("2");
                    Toast.makeText(context, "Left bedside lamp off", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rightSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ((ParentActivity) context).sendData("3");
                    Toast.makeText(context, "Right bedside lamp on", Toast.LENGTH_SHORT).show();
                } else {
                    ((ParentActivity) context).sendData("4");
                    Toast.makeText(context, "Right bedside lamp off", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
