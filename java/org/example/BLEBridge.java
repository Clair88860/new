package org.example;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.content.Context;

public class BLEBridge {
    private BluetoothLeScanner scanner;
    private ScanCallback scanCallback;
    private BluetoothGatt gatt;

    public void startScan(BluetoothAdapter adapter, ScanCallback callback) {
        if (adapter != null && callback != null) {
            scanner = adapter.getBluetoothLeScanner();
            if (scanner != null) {
                scanCallback = callback;
                scanner.startScan(scanCallback);
            }
        }
    }

    public void stopScan() {
        if (scanner != null && scanCallback != null) {
            scanner.stopScan(scanCallback);
        }
    }

    public void connectDevice(BluetoothDevice device, BluetoothGattCallback callback, Context context) {
        if (device != null && callback != null && context != null) {
            gatt = device.connectGatt(context, false, callback);
        }
    }

    public BluetoothGatt getGatt() {
        return gatt;
    }
}
