# am

Executable inside the Android device.

Can be used through the `adb shell`, e.g.:

    adb shell am start -n com.cirosantilli.android_cheat.xml_layout/com.cirosantilli.android_cheat.xml_layout.Main

## start

Start a given activity:

    adb shell am start -n com.cirosantilli.android_cheat.xml_layout/com.cirosantilli.android_cheat.xml_layout.Main

Takes a package / class pair.

## Activity Manager (AM)

The Activity Manager (AM) is an executable inside the Android device that can be used through the ADB shell. It allows starting activities, services, and sending broadcasts.

### Starting Activities

To start a specific activity, use the `am start` command with the package and class name. For example:

    adb shell am start -n com.cirosantilli.android_cheat.xml_layout/com.cirosantilli.android_cheat.xml_layout.Main

### Starting Services

To start a service, use the `am startservice` command with the package and service name. For example:

    adb shell am startservice -n com.example.myapp/.MyService

### Sending Broadcasts

To send a broadcast, use the `am broadcast` command with the action name. For example:

    adb shell am broadcast -a android.intent.action.BOOT_COMPLETED
