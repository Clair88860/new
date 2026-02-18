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
    private BluetoothGatt gatt;

    public void startScan(BluetoothAdapter adapter, ScanCallback callback) {
        if (adapter != null) {
            scanner = adapter.getBluetoothLeScanner();
            if (scanner != null) {
                scanner.startScan(callback);
            }
        }
    }

    public void stopScan() {
        if (scanner != null) {
            scanner.stopScan(new ScanCallback(){}); // Dummy, nur um compiler happy zu machen
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
