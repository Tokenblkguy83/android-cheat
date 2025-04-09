# adb

Android Debug Bridge.

## Architecture

Three parts:

- client that runs on computer
- server that also runs on computer
- daemon that runs on cell phone

## Wireless

The most common way of using ADB on a device is to plug it in with an USB cable, but that is annoying, so:

- <http://stackoverflow.com/questions/2604727/how-can-i-connect-to-android-with-adb-over-tcp>
- <http://stackoverflow.com/questions/14358882/connecting-adb-using-wifi-for-non-rooted-device>

## devices

List connected devices:

    adb devices -l

Sample output with an enabled physical Android device and an emulator running:

    List of devices attached
    BY900FBH2G             device usb:1-6 product:D6643 model:D6643 device:D6643
    emulator-5554          device product:sdk_google_phone_x86 model:Android_SDK_built_for_x86 device:generic_x86

The first column can be used as an identifier to the `adb` command, e.g. `adb -s emulator-5554 install my.apk`.

TODO: I think this also lists emulators. TODO check.

## install

TODO: mention udev, device will ask for permission on screen. Then do:

    sudo "$(which adb)" kill-server
    sudo "$(which adb)" start-server

Install given apk to a device:

    adb install my.apk

Only works if there is a single device / emulator available.

Otherwise you have to specify a device with:

    adb -s emulator-5554 installd my.apk

The default generated `ant` file does this with `ant debug install`.

Install to all devices: <http://stackoverflow.com/questions/8610733/how-can-i-adb-install-an-apk-to-multiple-connected-devices>

## shell

TODO: is this the same as SSH? If not, how?

## push

Push file from local filesystem into device:

    adb push local_file /path/on/device/local_file

## pull

Contrary of `push`.

## reboot

    adb reboot bootloader
    adb reboot recovery

## sideload

TODO

## logcat

`tail -f` a huge log of all applications:

    adb logcat -g
    adb logcat

`cat` it instead of `tail -f`:

    adb logcat -d

TODO: what exactly goes to that log. That I know of:

- exception stack traces
- `Log()` calls

stdout is not logged: it requires a root-only hack it seems.

Output lines are of type:

    E/AndroidRuntime(15141)

Where:

- `E` is the log severity: here Error.
- `AndroidRuntime`: TODO: class name? Why does it show `AndroidRuntime` instead of my app?
- `15141`: TODO: PID?

### Severity

Show only errors:

    adb logcat '*:E'

Show only warnings and errors:

    adb logcat '*:W'

### v

<http://developer.android.com/tools/debugging/debugging-log.html#outputFormat>

Show everything:

    adb logcat -v long

Time:

    adb logcat -v time

### logcat size

It is a circular buffer:

- <http://stackoverflow.com/questions/6321555/what-is-the-size-limit-for-logcat>
- <http://stackoverflow.com/questions/8888654/android-set-max-length-of-logcat-messages>

Data is stored compressed in logcat, so you may get much more raw characters than that.

Can be obtained with:

    adb logcat -g

### r

### n

### How much data to print

TODO: what do those options mean?

    -r [<kbytes>]   Rotate log every kbytes. (16 if unspecified). Requires -f
    -n <count>      Sets max number of rotated logs to <count>, default 4

How to limit how many bytes?

This answer claims they require `-f`: <http://stackoverflow.com/questions/23425066/adb-logcat-f-log-txt-error-couldnt-open-output-file-read-only-file-system>

### f

Output to file instead of stdout.

But it seems that the file is inside the device, so you will likely get permission denied a lot: <http://stackoverflow.com/questions/23425066/adb-logcat-f-log-txt-error-couldnt-open-output-file-read-only-file-system>

### Filter logs for a single application

TODO: filter by a single application: <http://stackoverflow.com/questions/6854127/filter-logcat-to-get-only-the-messages-from-my-application-in-android>

The PID selection solution from <http://stackoverflow.com/a/9869609/895245> should work.

The easier way is to sort by tag of the `Log` class: <http://developer.android.com/reference/android/util/Log.html#d%28java.lang.String,%20java.lang.String%29>

### /system/bin/logcat

If you run that from `adb shell`, the output seems to be exactly the same.

## am

The `am` command is used to start activities, services, and send broadcasts on an Android device. It can be used through the ADB shell.

### Starting Activities

To start a specific activity, use the `am start` command with the package and class name. For example:

    adb shell am start -n com.cirosantilli.android_cheat.xml_layout/com.cirosantilli.android_cheat.xml_layout.Main

### Starting Services

To start a service, use the `am startservice` command with the package and service name. For example:

    adb shell am startservice -n com.example.myapp/.MyService

### Sending Broadcasts

To send a broadcast, use the `am broadcast` command with the action name. For example:

    adb shell am broadcast -a android.intent.action.BOOT_COMPLETED

## Using adb with Android 10 and later

With the release of Android 10, there have been some changes and new features added to adb. Here are some key points to keep in mind when using adb with Android 10 and later:

### Scoped Storage

Android 10 introduced Scoped Storage, which changes the way apps access files on the device. This affects how adb interacts with the file system. To work with files in the app-specific directories, you can use the `adb shell` command to navigate to the app's private storage.

### Wireless Debugging

Android 11 introduced wireless debugging, which allows you to connect to a device over Wi-Fi without needing a USB cable. To enable wireless debugging, follow these steps:

1. Enable Developer Options on your device.
2. Go to Developer Options and enable "Wireless debugging."
3. Pair your device with your computer using a QR code or pairing code.
4. Use the `adb connect` command to connect to the device over Wi-Fi.

### Incremental APK Installation

Android 11 also introduced incremental APK installation, which speeds up the installation process for large APKs. To use this feature, you need to enable it in the Developer Options and use the `adb install` command with the `--incremental` flag.

For more information on using adb with Android 10 and later, refer to the official Android documentation.

## Using ADB Wirelessly for Content Gathering without Android Studio

ADB can be used wirelessly for content gathering without the need for Android Studio. This can be particularly useful for developers who prefer a lightweight setup or need to gather content on the go. Here's how to set it up:

### Enabling Wireless Debugging

1. Ensure your device is running Android 11 or later.
2. Enable Developer Options on your device by going to Settings > About phone and tapping "Build number" seven times.
3. Go to Developer Options and enable "Wireless debugging."
4. Pair your device with your computer using a QR code or pairing code.
5. Use the `adb connect` command to connect to the device over Wi-Fi. For example:

    ```
    adb connect <device_ip_address>:<port>
    ```

### Gathering Content

Once connected, you can use various ADB commands to gather content from your device. Some useful commands include:

- `adb pull <remote> <local>`: Pulls a file from the device to your computer.
- `adb shell <command>`: Executes a shell command on the device.
- `adb logcat`: Retrieves the device's logcat output.

By using ADB wirelessly, you can efficiently gather content from your device without the need for a USB connection or Android Studio.
