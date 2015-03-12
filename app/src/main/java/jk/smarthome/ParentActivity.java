package jk.smarthome;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jk.smarthome.adapters.MyPagerAdapter;


public class ParentActivity extends FragmentActivity {
    FragmentPagerAdapter adapterViewPager;

    private static final String TAG = "BluetoothTAG";

    Button k1On, k1Off, k2On, k2Off;

    private static final int REQUEST_ENABLE_BT = 1;
    private BluetoothAdapter btAdapter = null;
    private BluetoothSocket btSocket = null;
    private OutputStream outStream = null;

    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    private static String mac_address = "30:14:12:26:05:22";

    /*private Spinner lightingSpinner;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_activity);

        ViewPager vPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vPager.setAdapter(adapterViewPager);

        k1On = (Button) findViewById(R.id.k1On);
        k1Off = (Button) findViewById(R.id.k1Off);
        k2On = (Button) findViewById(R.id.k2On);
        k2Off = (Button) findViewById(R.id.k2Off);

        btAdapter = BluetoothAdapter.getDefaultAdapter();

        turnBTOn();

       /* k1On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("1");
                Toast.makeText(getBaseContext(), "k1 on", Toast.LENGTH_SHORT).show();
            }
        });

        k1Off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("2");
                Toast.makeText(getBaseContext(), "k1 off", Toast.LENGTH_SHORT).show();
            }
        });

        k2On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("3");
                Toast.makeText(getBaseContext(), "k2 on", Toast.LENGTH_SHORT).show();
            }
        });

        k2Off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("4");
                Toast.makeText(getBaseContext(), "k2 off", Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    @Override
    protected void onResume() {
        super.onResume();

        BluetoothDevice device = btAdapter.getRemoteDevice(mac_address);

        try {
            btSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
        } catch (IOException e){

        }

        btAdapter.cancelDiscovery();

        try {
            btSocket.connect();
        } catch (IOException e) {
            try {
                btSocket.close();
            } catch (IOException e2){

            }
        }

        try{
            outStream = btSocket.getOutputStream();
        } catch (IOException e) {

        }

    }

    @Override
    protected void onPause() {
        super.onPause();

        if (outStream != null) {
            try {
                outStream.flush();
            } catch (IOException e) {

            }
        }

        try {
            btSocket.close();
        } catch (IOException e){

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.parent_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void turnBTOn() {

        if (btAdapter==null) {
            Intent enableBtIntent = new Intent(btAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
    }

    public void sendData(String message) {
        byte[] msgBuffer = message.getBytes();

        try{
            outStream.write(msgBuffer);
        } catch (IOException e) {

        }

    }
}
