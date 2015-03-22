package jk.smarthome.models;

/**
 * Created by jacek on 25/01/15.
 */
public class ApplienceState {
    private String applienceText;
    private String roomName;

    public ApplienceState(String applienceText, String roomName) {
        this.applienceText = applienceText;
        this.roomName = roomName;
    }

    public String getStateText() {
        return applienceText;
    }

    public void setStateText(String alertText) {
        this.applienceText = alertText;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

}
