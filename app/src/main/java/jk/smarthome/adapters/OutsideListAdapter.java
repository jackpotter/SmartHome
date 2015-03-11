package jk.smarthome.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import jk.smarthome.R;
import jk.smarthome.models.Room;

/**
 * Created by jacek on 02-12-2014.
 */
public class OutsideListAdapter extends BaseAdapter {

    private Context context;
    private List<Room> outsideList;
    LayoutInflater layoutInflater;

    public OutsideListAdapter(Context context, List<Room> outsideList) {

        this.context = context;
        this.outsideList = outsideList;

        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return outsideList.size();
    }

    @Override
    public Object getItem(int position) {
        return outsideList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = layoutInflater.inflate(R.layout.room_list_item, parent, false);


        return view;
    }
}
