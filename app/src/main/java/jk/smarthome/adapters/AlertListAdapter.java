package jk.smarthome.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import jk.smarthome.R;
import jk.smarthome.models.Alert;
import jk.smarthome.models.Room;

/**
 * Created by jacek on 02-12-2014.
 */
public class AlertListAdapter extends BaseAdapter {

    private Context context;
    private List<Alert> alertList;
    LayoutInflater layoutInflater;

    public AlertListAdapter(Context context, List<Alert> alertList) {

        this.context = context;
        this.alertList = alertList;

        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return alertList.size();
    }

    @Override
    public Object getItem(int position) {
        return alertList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.alert_list_item, parent, false);

        TextView alertRoomNameTV = (TextView) view.findViewById(R.id.alertRoomNameTV);
        TextView alertTextTV = (TextView) view.findViewById(R.id.alertTextTV);

        Alert alert = alertList.get(position);
        alertTextTV.setText(alert.getAlertText());
        alertRoomNameTV.setText(alert.getRoomName());



        return view;
    }
}
