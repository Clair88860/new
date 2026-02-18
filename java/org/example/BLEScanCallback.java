package org.example;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.util.Log;

public class BLEScanCallback extends ScanCallback {

    private final String TAG = "BLEScanCallback";

    @Override
    public void onScanResult(int callbackType, ScanResult result) {
        BluetoothDevice device = result.getDevice();
        String name = device.getName();
        Log.d(TAG, "Gefunden: " + name);
        // TODO: Hier kannst du das Gerät an Python weitergeben (z.B. via Broadcast oder Pyjnius)
    }
}
