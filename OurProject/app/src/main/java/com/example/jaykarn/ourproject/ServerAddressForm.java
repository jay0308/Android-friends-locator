package com.example.jaykarn.ourproject;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by JayKarn on 3/7/2016.
 */
public class ServerAddressForm extends Activity{
    EditText portNo,IpAdd;
    Button next,connect;
    String getPortNo,getIp,userName;
    double lat,lon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serveraddress);
        next=(Button)findViewById(R.id.nxtBtn);
        connect=(Button)findViewById(R.id.connect);
        portNo=(EditText)findViewById(R.id.portEt);
        IpAdd=(EditText)findViewById(R.id.ipEt);
        SharedPreferences pref=getApplication().getSharedPreferences("Options", MODE_PRIVATE);
        userName = pref.getString("username","");
        Toast.makeText(ServerAddressForm.this, userName, Toast.LENGTH_SHORT).show();
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener ll = new MyLocationListener();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
//            tvLong.setText("permission ni mila");
            return;
        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPortNo = portNo.getText().toString();
                getIp = IpAdd.getText().toString();
                String tMsg = userName + " is connected"+" My Location: "+lat+" "+lon;
                if (getPortNo == null || getPortNo.equals("") || getIp == null || getIp.equals("")) {
                    portNo.setError("enter valid port no.");
                    IpAdd.setError("enter valid ip address");

                } else {
                    MyClientTask myClientTask = new MyClientTask(getIp, Integer.parseInt(getPortNo),
                            tMsg);
                    myClientTask.execute();
                    next.setVisibility(View.VISIBLE);
                    connect.setVisibility(View.INVISIBLE);
//                    Intent openTest = new Intent("com.example.jaykarn.MAINACTIVITY");
//                    startActivity(openTest);
//                    finish();
                }

            }
        });
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent openTest = new Intent("com.example.jaykarn.MAINACTIVITY");
                    startActivity(openTest);
                    finish();
            }
        });
    }


    private class MyLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            lat=location.getLatitude();
            lon=location.getLongitude();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }
}
