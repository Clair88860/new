package org.example;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.util.Log;

import org.jnius.NativeInvocation;

public class BLEScanCallback extends ScanCallback {
    private final Object pyCallback;
    private final String TAG = "BLEScanCallback";

    public BLEScanCallback(Object pyCallback) {
        this.pyCallback = pyCallback;
    }

    @Override
    public void onScanResult(int callbackType, ScanResult result) {
        BluetoothDevice device = result.getDevice();
        String name = device.getName();
        Log.d(TAG, "Gefunden: " + name);
        if (pyCallback != null) {
            try {
                NativeInvocation.invoke(pyCallback, "onDeviceFound", new Object[]{name}, new Class[]{String.class});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
