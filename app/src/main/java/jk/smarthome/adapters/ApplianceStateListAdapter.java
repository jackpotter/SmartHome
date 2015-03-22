package jk.smarthome.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import jk.smarthome.R;
import jk.smarthome.models.ApplienceState;

/**
 * Created by jacek on 02-12-2014.
 */
public class ApplianceStateListAdapter extends BaseAdapter {

    private Context context;
    private List<ApplienceState> stateList;
    LayoutInflater layoutInflater;

    public ApplianceStateListAdapter(Context context, List<ApplienceState> stateList) {

        this.context = context;
        this.stateList = stateList;

        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return stateList.size();
    }

    @Override
    public Object getItem(int position) {
        return stateList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.appliance_state_list_item, parent, false);

        TextView applianceRoomNameTV = (TextView) view.findViewById(R.id.applianceRoomNameTV);
        TextView applianceStateTV = (TextView) view.findViewById(R.id.applianceStateTV);

        ApplienceState state = stateList.get(position);
        applianceStateTV.setText(state.getStateText());
        applianceRoomNameTV.setText(state.getRoomName());

        return view;
    }
}
