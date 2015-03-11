package jk.smarthome.models;

/**
 * Created by jacek on 25/01/15.
 */
public class Alert {
    private String alertText;
    private String roomName;

    public Alert(String alertText, String roomName) {
        this.alertText = alertText;
        this.roomName = roomName;
    }

    public String getAlertText() {
        return alertText;
    }

    public void setAlertText(String alertText) {
        this.alertText = alertText;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

}
