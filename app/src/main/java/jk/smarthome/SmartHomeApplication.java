package jk.smarthome;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import jk.smarthome.models.Room;

/**
 * Created by jacek on 02-12-2014.
 */
public class SmartHomeApplication extends Application {

    private List<Room> roomList = new ArrayList<Room>();
   // private List<Room> outsideList = new ArrayList<Room>();

    @Override
    public void onCreate() {
        super.onCreate();

        initializeRooms();
        //initializeOutside();

    }

    private void initializeRooms(){
                      //                  id              name      hum temp light pres cam closet  openW openD br-in   fire      CO      flood  move   tap    tub  wash oven dish ref  oD1 oW1
     roomList.add(new Room(0, "Master Bedroom", 54,   23,    0,     0,    0,  false,   false,   false,   false,   false,   false,   false,   false,  false,   0,     0,     0,    0,    0,     0,   0));
     roomList.add(new Room(1,       "Living Room", 50,   24,    0,     0,    0,  false,   false,   false,   false,   false,   false,   false,   false,  false,   0,     0,     0,    0,    0,     0,   0));
     roomList.add(new Room(2,               "Kitchen", 61,   22,    0,     0,    0,  false,   false,   false,   false,   true,   false,   false,   false,  false,   0,     0,     0,    0,    0,     0,   0));
     roomList.add(new Room(3,            "Bathroom", 65,   25,    0,     0,    0,  false,   false,   false,   false,   false,   true,   false,   false,  true,    0,     0,     0,    0,    0,     0,   0));
     roomList.add(new Room(4,     "Kid's Bedroom", 52,   24,    0,     0,    0,  false,   false,   false,   true,   false,   false,   false,   false,  false,   0,     0,     0,    0,    0,    0,   0));

    }

    public List<Room> getRoomList(){

        return roomList;

    }

    /*private void initializeOutside(){
        //                                      id          name     hum   temp  light  pres  cams  openD   openW   closet   br-in    smoke    CO      flood    move     tap    tub  wash oven dish refr  scullery  outdoor heating
        outsideList.add(new Room(0,         "Garage", 69,   69,    0,     0,    0,  false,  false,  false,   false,   false,   false,   false,   false,  false,   0,   0,   0,   0,   0,   false, false));
        outsideList.add(new Room(1,       "driveway", 69,   69,    0,     0,    0,  false,  false,  false,   false,   false,   false,   false,   false,  false,   0,   0,   0,   0,   0,   false, false));
        outsideList.add(new Room(2,       "backyard", 69,   69,    0,     0,    0,  false,  false,  false,   false,   false,   false,   false,   false,  false,   0,   0,   0,   0,   0,   false, false));
        outsideList.add(new Room(3,            "XYZ", 69,   69,    0,     0,    0,  false,  false,  true,    false,   false,   false,   false,   false,  false,   0,   0,   0,   0,   0,   false, false));
        outsideList.add(new Room(4,            "ABC", 69,   69,    0,     0,    0,  false,  false,  false,   false,   false,   false,   false,   false,  false,   0,   0,   0,   0,   0,   false, false));

    }*/

  /*  public List<Room> getOutsideListList(){

        return outsideList;

    }*/

}
