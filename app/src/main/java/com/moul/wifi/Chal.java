package com.moul.wifi;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.widget.Toast;

public class Chal extends Service {
    public Chal() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        WifiManager wifi =(WifiManager)getSystemService(Context.WIFI_SERVICE);
        if (wifi.isWifiEnabled()) {
            Toast.makeText(this, "WiFi is ON", Toast.LENGTH_LONG).show();

            disableWifi(wifi);
        }


        return super.onStartCommand(intent, flags, startId);
    }
    private void disableWifi(WifiManager wifi) {
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (!mWifi.isConnected()) {
            wifi.setWifiEnabled(false);
            Toast.makeText(this, "Disable WiFi called", Toast.LENGTH_LONG).show();

        }
        }
    }

//  private boolean isWifiEnabled(WifiManager wifi) {
  //      return wifi.isWifiEnabled();
   // }



