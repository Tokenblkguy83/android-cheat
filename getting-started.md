# Getting started

- install Android Studio and the SDK
- ensure that `adb shell` works, i.e. you can connect with USB or TCP to a device or emulator instance

Build all examples, install them to the device, and run one of them:

    ./configure
    ./build -i
    ./run TextViewBold/

If one of the builds fail, open the app on Android Studio, hit the build button, then accept whatever crappy automatic fixes it proposes, until you can build and run that example. Then try our build script again, and iterate until they all build. Yes, Android automation sucks and there is nothing you can do about it.

Build one example, install it to the device, and run it:

    ./build -i TextViewBold/
    ./run TextViewBold/

or equivalently:

    ./build -i -r TextViewBold/

You can also run the app from inside the app folder as:

    cd TextViewBold
    ../run

Uninstall all examples from the device:

    ./build -u

Start a new project from the boilerplate of an existing one:

    ./template NewTextViewBold TextViewBold/
    ./build -i -r NewTextViewBold/

I'm a newb and I want to edit the project with Android Studio instead of Vim:

- launch IDE
- "Open an existing Android Studio project"
- select a directory

I once had a dream to have one git tracked file per app, but I got tired of fighting to minimize unminimizable Android Studio bloat of 20 million files to run a hello world program, and now just keep all the generated crap in the repo and be done with it. For most apps, please just ignore all files, and go straight for the `MainActivity.java`. Initial templates were obtained from Android Studio new projects, then similar ones forked with the `./template` script.

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
