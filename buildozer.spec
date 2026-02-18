[app]

title = ArchäologieDocumentation
package.name = archaeologie
package.domain = org.example

source.dir = .
source.include_exts = py,java
android.add_src = java/org/example

version = 1.0
entrypoint = main.py
orientation = portrait

requirements = python3,kivy,pyjnius,android,pillow

android.permissions = BLUETOOTH,BLUETOOTH_ADMIN,BLUETOOTH_SCAN,BLUETOOTH_CONNECT,ACCESS_FINE_LOCATION

fullscreen = 0


android.api = 33
android.minapi = 21
android.ndk = 25
android.archs = arm64-v8a
android.enable_androidx = 1
android.build_tools_version = 37.0.0


android.logcat_filters = *:S python:D
warn_on_root = 1
