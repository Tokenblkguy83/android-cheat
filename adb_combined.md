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

### Wireless adb

Wireless adb is a feature that allows you to connect to a device over Wi-Fi without needing a USB cable. It provides several benefits for debugging and content gathering.

#### Benefits of Wireless asb

- No need for a USB cable, making it more convenient for developers.
- Allows for remote debugging and content gathering.
- Useful for content gathering without Android Studio.

#### Enabling and Using Wireless asb

1. Ensure your device is running Android 11 or later.
2. Enable Developer Options on your device by going to Settings > About phone and tapping "Build number" seven times.
3. Go to Developer Options and enable "Wireless debugging."
4. Pair your device with your computer using a QR code or pairing code. On your Android device, open the Wireless debugging settings and tap either "Pair device with QR code" or "Pair device with pairing code" to display the code. Then, on your computer, follow the on-screen instructions or use an ADB tool that supports wireless debugging to enter the pairing code or scan the QR code.
5. Use the `adb connect` command to connect to the device over Wi-Fi. For example:

    ```
    adb connect <device_ip_address>:<port>
    ```

### NSFW search

NSFW search is a feature that allows you to filter content for not safe for work (NSFW) material. It can be useful for content filtering and ensuring that inappropriate content is not displayed.

#### Benefits of NSFW search

- Helps in filtering out inappropriate content.
- Useful for applications that need to ensure a safe browsing experience.

#### Enabling and Using NSFW search

1. Implement NSFW search functionality in your application.
2. Use appropriate algorithms and libraries to detect and filter NSFW content.
3. Test the feature thoroughly to ensure accurate filtering.

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

### Incremental APK Installation

Android 11 introduced incremental APK installation, which speeds up the installation process for large APKs. To use this feature, you need to enable it in the Developer Options and use the `adb install` command with the `--incremental` flag. For example:

    adb install --incremental my_large_apk.apk

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

### Real-time Logcat Filtering

Real-time Logcat filtering is a feature that allows you to stream and filter the device's system logs in real-time based on your criteria. This can be useful for debugging and monitoring specific events.

#### Benefits of Real-time Logcat Filtering

- Helps in monitoring specific events and logs in real-time.
- Useful for debugging and identifying issues quickly.

#### Enabling and Using Real-time Logcat Filtering

1. Connect your device to your computer using a USB cable or wirelessly.
2. Use the `adb logcat` command with the desired filter criteria. For example, to filter logs by a specific tag:

    ```
    adb logcat -s NetworkTag
    ```

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

### Browsing Basic Media Content

Browsing basic media content is a feature that allows you to list media files in common directories on the device. This can be useful for quickly accessing and managing media files.

#### Benefits of Browsing Basic Media Content

- Helps in quickly accessing and managing media files.
- Useful for applications that need to browse media content.

#### Enabling and Using Browsing Basic Media Content

1. Connect your device to your computer using a USB cable or wirelessly.
2. Use the `adb shell` command to navigate to the desired media directory. For example, to list media files in the DCIM directory:

    ```
    adb shell ls /sdcard/DCIM/
    ```

### Inspecting Application Data Directories

Inspecting application data directories is a feature that allows you to browse the internal data directories of applications. This requires root access or the application to be debuggable.

#### Benefits of Inspecting Application Data Directories

- Helps in accessing and managing application data.
- Useful for debugging and analyzing application data.

#### Enabling and Using Inspecting Application Data Directories

1. Connect your device to your computer using a USB cable or wirelessly.
2. Use the `adb shell` command to navigate to the application's data directory. For example, to list the contents of an application's data directory:

    ```
    adb shell ls /data/data/com.example.messenger/
    ```

### IP Trace through Messenger

IP trace through messenger is a feature that allows you to trace an IP address through a messenger application. This can be useful for monitoring network traffic and analyzing network-related information.

#### Benefits of IP Trace through Messenger

- Helps in monitoring network traffic and analyzing network-related information.
- Useful for applications that need to trace IP addresses.

#### Enabling and Using IP Trace through Messenger

1. Enable Wireless ADB on your device.
2. Monitor network traffic using tools like `tcpdump`.
3. Analyze Logcat output for network-related information.
4. Inspect application data directories for network-related information.
5. Implement a function to automatically save captured IP addresses and corresponding names based on phone information.

### Example Code for IP Trace through Messenger

```kotlin
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

data class FunctionItem(val name: String, val description: String, val onClick: () -> Unit)

@Composable
fun AdbToolScreen(functionItems: List<FunctionItem>) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Advanced ADB Tool") })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(functionItems) { item ->
                var showDescription by remember { mutableStateOf(false) }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(
                            onClick = item.onClick,
                            onLongClick = {
                                showDescription = !showDescription
                                Toast.makeText(context, item.description, Toast.LENGTH_LONG).show()
                            }
                        )
                        .padding(8.dp)
                ) {
                    Text(text = item.name, style = MaterialTheme.typography.h6)
                    if (showDescription) {
                        Text(text = item.description, style = MaterialTheme.typography.body2)
                    }
                    Divider()
                }
            }
        }
    }
}

@Composable
fun AdbToolApp() {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    var deviceList by remember { mutableStateOf("") }
    var isListingDevices by remember { mutableStateOf(false) }

    val functionList = remember {
        mutableStateListOf(
            FunctionItem(
                name = "List connected devices",
                description = "Shows a list of devices connected via USB or Wi-Fi to your computer.",
                onClick = {
                    isListingDevices = true
                    coroutineScope.launch {
                        // Placeholder for your actual ADB command execution
                        // For example:
                        // val result = runAdbCommand("adb devices")
                        // deviceList = result
                        Toast.makeText(context, "Listing devices...", Toast.LENGTH_SHORT).show()
                        isListingDevices = false
                        // You might want to update some UI state here to display the deviceList
                    }
                }
            ),
            FunctionItem(
                name = "Install an APK",
                description = "Allows you to install an APK file from your computer onto the connected device. Be cautious with APK sources!",
                onClick = { /* Implement logic for adb install */ Toast.makeText(context, "Installing APK...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Uninstall an app",
                description = "Removes an application from the connected device using its package name.",
                onClick = { /* Implement logic for adb uninstall */ Toast.makeText(context, "Uninstalling app...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Get device properties",
                description = "Retrieves and displays various system properties of the connected Android device.",
                onClick = { /* Implement logic for adb shell getprop */ Toast.makeText(context, "Getting properties...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Pull a file from device",
                description = "Copies a file or directory from the connected device to your computer. Ensure the local path is safe.",
                onClick = { /* Implement logic for adb pull */ Toast.makeText(context, "Pulling file...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Push a file to device",
                description = "Copies a file or directory from your computer to the connected device. Ensure the remote path is correct.",
                onClick = { /* Implement logic for adb push */ Toast.makeText(context, "Pushing file...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Take a screenshot",
                description = "Captures a screenshot of the connected device's display and saves it on the device.",
                onClick = { /* Implement logic for adb shell screencap */ Toast.makeText(context, "Taking screenshot...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Record screen",
                description = "Starts recording the screen of the connected device and saves the recording on the device. Press Ctrl+C in the terminal to stop.",
                onClick = { /* Implement logic for adb shell screenrecord */ Toast.makeText(context, "Recording screen...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Reboot device",
                description = "Initiates a reboot of the connected Android device.",
                onClick = { /* Implement logic for adb reboot */ Toast.makeText(context, "Rebooting...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Enter ADB shell",
                description = "Opens an interactive shell on the connected device, allowing you to execute various commands directly. Use with caution!",
                onClick = { /* Implement logic for adb shell */ Toast.makeText(context, "Entering ADB shell...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "List packages",
                description = "Displays a list of all installed application package names on the device.",
                onClick = { /* Implement logic for adb shell pm list packages */ Toast.makeText(context, "Listing packages...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Force stop an app",
                description = "Forces a specified application to stop running.",
                onClick = { /* Implement logic for adb shell am force-stop */ Toast.makeText(context, "Force stopping app...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Clear app data",
                description = "Deletes all data associated with a specified application.",
                onClick = { /* Implement logic for adb shell pm clear */ Toast.makeText(context, "Clearing app data...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Grant runtime permission",
                description = "Grants a specific runtime permission to an application. Understand the permissions you are granting!",
                onClick = { /* Implement logic for adb shell pm grant */ Toast.makeText(context, "Granting permission...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Revoke runtime permission",
                description = "Revokes a specific runtime permission from an application.",
                onClick = { /* Implement logic for adb shell pm revoke */ Toast.makeText(context, "Revoking permission...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Enable ADB over Wi-Fi",
                description = "Configures the device to accept ADB connections over Wi-Fi. Requires initial USB connection. Limits network exposure.",
                onClick = { /* Implement logic for adb tcpip */ Toast.makeText(context, "Enabling ADB over Wi-Fi...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Connect to device via Wi-Fi",
                description = "Establishes an ADB connection to a device using its IP address and port. Ensure you are on a secure network.",
                onClick = { /* Implement logic for adb connect */ Toast.makeText(context, "Connecting via Wi-Fi...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Disconnect from Wi-Fi device",
                description = "Closes the ADB connection to a device connected over Wi-Fi.",
                onClick = { /* Implement logic for adb disconnect */ Toast.makeText(context, "Disconnecting...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Execute content provider query",
                description = "Runs a query against a specified content provider on the device. Understand the data you are accessing.",
                onClick = { /* Implement logic for adb shell content query */ Toast.makeText(context, "Querying content provider...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Revoke USB debugging authorizations",
                description = "Removes all previously granted USB debugging authorizations. A security measure.",
                onClick = { /* Implement logic for adb revokeusbkeys */ Toast.makeText(context, "Revoking USB keys...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Get local network information",
                description = "Displays information about your computer's network interfaces, which can help with Wi-Fi ADB connections.",
                onClick = { /* Implement logic for getLocalNetworkInfo */ Toast.makeText(context, "Getting network info...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "List files and directories",
                description = "Shows a list of files and subdirectories within a specified path on the device.",
                onClick = { /* Implement logic for adb shell ls */ Toast.makeText(context, "Listing files...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Search for files by name",
                description = "Searches for files on the device with a name matching your query within a specified directory.",
                onClick = { /* Implement logic for adb shell find -name */ Toast.makeText(context, "Searching files...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Get file details",
                description = "Displays detailed information about a specific file on the device (size, permissions, etc.).",
                onClick = { /* Implement logic for adb shell stat or ls -l */ Toast.makeText(context, "Getting file details...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "List installed applications",
                description = "Displays the package names of all applications installed on the device.",
                onClick = { /* Implement logic for adb shell pm list packages */ Toast.makeText(context, "Listing apps...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Search for applications by package name",
                description = "Searches for installed applications based on their package name.",
                onClick = { /* Implement logic for adb shell pm list packages | grep */ Toast.makeText(context, "Searching apps...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Browse basic media content",
                description = "Provides a basic listing of media files in common directories (e.g., /sdcard/DCIM/).",
                onClick = { /* Implement logic for adb shell ls (with filtering in app) */ Toast.makeText(context, "Browsing media...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Real-time Logcat filtering",
                description = "Streams and filters the device's system logs in real-time based on your criteria.",
                onClick = { /* Implement logic for adb logcat */ Toast.makeText(context, "Starting logcat...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Inspect application data directories (requires root/debuggable)",
                description = "Allows browsing of internal data directories of applications (requires root access or the app to be debuggable).",
                onClick = { /* Implement logic for adb shell run-as or su -c ls */ Toast.makeText(context, "Inspecting app data...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Search SQLite databases within apps (requires root/debuggable)",
                description = "Enables querying SQLite databases used by applications (requires root access or the app to be debuggable). Requires knowledge of SQL.",
                onClick = { /* Implement logic for adb shell run-as or su -c sqlite3 */ Toast.makeText(context, "Querying database...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Dump application information (dumpsys)",
                description = "Retrieves detailed information about the device's system services and applications.",
                onClick = { /* Implement logic for adb shell dumpsys */ Toast.makeText(context, "Dumping system info...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Access screenshot and screen recording paths",
                description = "Provides quick access to the default directories where screenshots and screen recordings are saved.",
                onClick = { /* Implement logic to show predefined paths */ Toast.makeText(context, "Showing media paths...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Fast file search in specified directories",
                description = "Quickly searches for files matching your query within the directories you specify.",
                onClick = { /* Implement logic for fastFileSearch */ Toast.makeText(context, "Starting fast search...", Toast.LENGTH_SHORT).show() }
            ),
            FunctionItem(
                name = "Exit",
                description = "Closes the ADB Tool application.",
                onClick = { /* Implement logic to exit the app */ Toast.makeText(context, "Exiting...", Toast.LENGTH_SHORT).show() }
            )
        )
    }

    AdbToolScreen(functionList = functionList)

    if (isListingDevices) {
        AlertDialog(
            onDismissRequest = { isListingDevices = false },
            title = { Text("Connected Devices") },
            text = { Text(deviceList) },
            confirmButton = {
                Button(onClick = { isListingDevices = false }) {
                    Text("OK")
                }
            }
        )
    }
}
