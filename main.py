from kivy.app import App
from kivy.uix.label import Label
from kivy.clock import Clock
from kivy.utils import platform

if platform == "android":
    from jnius import autoclass
    from android.permissions import request_permissions, Permission

    PythonActivity = autoclass("org.kivy.android.PythonActivity")
    BluetoothAdapter = autoclass("android.bluetooth.BluetoothAdapter")
    BLEBridge = autoclass("org.example.BLEBridge")
    BLEScanCallback = autoclass("org.example.BLEScanCallback")

class BLEApp(App):
    def build(self):
        self.label = Label(text="Scan läuft..")
        if platform == "android":
            # Runtime Permissions für Android 12+
            request_permissions([
                Permission.BLUETOOTH_SCAN,
                Permission.BLUETOOTH_CONNECT,
                Permission.ACCESS_FINE_LOCATION
            ])
            self.adapter = BluetoothAdapter.getDefaultAdapter()
            self.bridge = BLEBridge()
            self.scan_cb = BLEScanCallback(self)
            self.bridge.startScan(self.adapter, self.scan_cb)
        return self.label

    def onDeviceFound(self, name):
        # UI Update im Hauptthread
        Clock.schedule_once(lambda dt: self.label.setter('text')(self.label, f"Gefunden: {name}"))

    def on_stop(self):
        if platform == "android":
            self.bridge.stopScan()

if __name__ == "__main__":
    BLEApp().run()
