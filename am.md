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

## Using am with Android 10 and later

With the release of Android 10, there have been some changes and new features added to the `am` tool. Here are some key points to keep in mind when using `am` with Android 10 and later:

### Scoped Storage

Android 10 introduced Scoped Storage, which changes the way apps access files on the device. This affects how `am` interacts with the file system. To work with files in the app-specific directories, you can use the `adb shell` command to navigate to the app's private storage.

### Wireless Debugging

Android 11 introduced wireless debugging, which allows you to connect to a device over Wi-Fi without needing a USB cable. To enable wireless debugging, follow these steps:

1. Enable Developer Options on your device.
2. Go to Developer Options and enable "Wireless debugging."
3. Pair your device with your computer using a QR code or pairing code.
4. Use the `adb connect` command to connect to the device over Wi-Fi.

### Incremental APK Installation

Android 11 also introduced incremental APK installation, which speeds up the installation process for large APKs. To use this feature, you need to enable it in the Developer Options and use the `adb install` command with the `--incremental` flag.

For more information on using `am` with Android 10 and later, refer to the official Android documentation.
