# Android Cheat

Dozens of minimal Android demo apps, each a example of one single Android API concept. Tested on Ubuntu 17.10 host, Android Studio 3, Android SDK 26, and an Android 6.0.1 device.

1.  [**Getting started**](getting-started.md)
1.  [Examples](examples.md)
    1.  UI
        1.  [XMLLayout](XmlLayout/)
        1.  View
            1.  TextView
                1.  [TextViewNewlinew](TextViewNewlinew/)
                1.  [TextViewBold](TextViewBold/)
                1.  [TextViewHyperlink](TextViewHyperlink/)
                1.  [ScrollView](ScrollView/)
                1.  [ScrollingMovementMethod](ScrollingMovementMethod/)
                1.  [EditText](EditText/)
                    1.  [EditText.getText](EditTextGetText/)
                1.  [Button](Button/)
                    1.  [Checkbox](Checkbox/)
                    1.  [RadioButton](RadioButton/)
                1.  [setTextColor](SetTextColor/)
            1.  [setBackgroundColor](SetBackgroundColor/)
            1.  [setLayoutParams](SetLayoutParams/)
                1.  [setLayoutParamsLinearLayout](SetLayoutParamsLinearLayout/)
            1.  ViewGroup
                1.  [RelativeLayout](RelativeLayout/)
                1.  [LinearLayout](LinearLayout/)
            1.  Media
                1.  [ImageView](ImageView/)
                    1.  [Bitmap](Bitmap/)
                1.  [VideoView](VideoView/)
            1.  Screen
                1.  [Fullscreen](Fullscreen/)
                1.  [Portrait](Portrait/)
        1.  Activities
            1.  [TwoActivities](TwoActivities/)
            1.  [ActivityLifecycle](ActivityLifecycle/)
            1.  [ChangeView](ChangeView/)
        1.  Notifications
            1.  [Notification](Notification/)
            1.  [Toast](Toast/)
            1.  [AlertDialog](AlertDialog/)
        1.  [Fragment](Fragment/)
    1.  [BackgroundJobsTheory](background-jobs.md)
        1.  [Handler](Handler/)
        1.  [IntentService](IntentService/)
            1.  [IntentServiceTextView](IntentServiceTextView/)
            1.  [IntentServiceStartStop](IntentServiceStartStop/)
        1.  [AsyncTask](AsyncTask/)
    1.  [ServerSocket](ServerSocket/)
        1.  [Socket](Socket/)
            1.  [SocketAsyncTask](SocketAsyncTask/)
    1.  Hardware
        1.  [Camera](camera/)
            1.  [CameraOneShot](CameraOneShot/)
            1.  [CameraPreviewVideo](CameraPreviewVideo/)
    1.  [Location theory](location.md)
        1.[Location](Location/)
    1.  [Env](Env/)
    1.  [Ndk](Ndk/)
        1.  [NdkSyslog](NdkSyslog/)
        1.  [NDKLog](NdkLog/)
        1.  [NDKLibc](NdkLibc/)
        1.  [NDKTwoFiles](NdkTwoFiles/)
1.  Theory
    1.  [Root](root.md)
    1.  Development
        1.  [Build AOSP](build-aosp.md)
            1.  [build-aosp](build-aosp)
            1.  [build-aosp-hikey960](build-aosp-hikey960)
        1.  [Contribute to AOSP](contribute-to-aosp.md)
        1.  [Internals](internals.md)
            1.  [Device file hierarchy](device-file-hierarchy.md)
            1.  [Networking](networking.md)
        1.  [android command](android-command.md)
        1.  [adb](adb.md)
            1.  [Project file hierarchy](project-file-hierarchy.md)
                1. [AndroidManifest.xml](android-manifest.md)
            1.  [ant](ant.md)
        1.  [Debugging](debugging.md)
        1.  [Gradle](gradle.md)
        1.  [Apps](apps.md)
            1.  [GAPPS](gapps.md)
                1. [gmail](gmail.md)
            1.  [WhatsApp](whatsapp.md)
        1.  [SDK](sdk.md)
        1.  [aapt](aapt.md)
        1.  [Studio](studio.md)
        1.  [Emulator](emulator.md)
    1.  [AOSP](aosp.md)
        1. [repo](repo.md)
    1.  [Desktop](desktop.md)
        1. [POSIX](posix.md)
    1.  [Monitor app power consumption](monitor-app-power-consumption.md)
    1.  Mods
        1. [CyanogenMod](cyanogenmod.md)
        1. [AOKP](aokp.md)
    1.  [Google play](google-play.md)
    1.  [Open source](open-source.md)
    1.  [Trivia](trivia.md)
    1.  [GPU](gpu.md)
    1.  [Security](security.md)
    1.  [Close app](close-app.md)
    1.  [Fingerprint sensor](fingerprint-sensor.md)

## Chats

Mark all as read:

<https://productforums.google.com/forum/#!topic/gmail/h-7PALCVZH0>

## Uninstallable apps

Some bloatware cannot be removed at all:

- <http://www.phonearena.com/news/Cant-uninstall-an-Android-app-This-could-be-your-problem_id61301>
- <http://forum.xda-developers.com/xperia-j-e/help/st26a-uninstall-uninstallable-apps-t2622293>
- <http://stackoverflow.com/questions/6415304/uninstallable-app-for-android>

## Bibliography

-   Android Authority
    - https://www.youtube.com/channel/UCgyqtNWZmIxTx3b6OxTSALw
-   https://en.wikipedia.org/wiki/XDA_Developers
    - http://www.xda-developers.com/

## Small apps

Stay on top of other apps.

Sample application: take screenshot!

- <https://developer.sony.com/develop/smartphones-and-tablets/camera-add-on-small-apps-or-ir-remote-apis/about/small-app-api/>
- <http://developer.sonymobile.com/2012/09/26/let-your-app-stay-on-top-with-small-apps-for-xperia-tablet-s/>

## Screenshot

On Xperia Z3, Power key + volume down.

## Icons

-   <http://android.stackexchange.com/questions/98975/complete-list-of-lollipop-system-icons-shown-in-notification-bar>
    - only network symbols: <http://android.stackexchange.com/questions/56269/what-are-the-different-signal-indicators-avalable-on-the-notification-bar>
-   4G vs H+ vs H
    - completely different WWAN standards: http://android.stackexchange.com/questions/56269/what-are-the-different-signal-indicators-avalable-on-the-notification-bar

## UI

### Status bar

Topmost bar on the screen, contains several icons like signal .

### Lock screen

What you see when you hit the power button.

### Lock screen widgets

Removed apparently in Android 5.

<http://www.androidauthority.com/lock-screen-widgets-android-lollipop-611516/>

### Toast

<http://www.mkyong.com/android/android-toast-example/>

## Notification history

- <http://android.stackexchange.com/questions/50177/android-4-3-how-to-get-the-notification-history>

## Notifications

### Transfer data to SD card notification

Disable:

- https://www.reddit.com/r/SonyXperia/comments/3101yj/how_do_i_disable_the_notification_transfer_data/
- https://talk.sonymobile.com/t5/Xperia-Z-ZL-ZR/Transfer-data-to-SD-card-notification/td-p/318761

### Application updated notification

Disable: <http://android.stackexchange.com/questions/58021/how-to-get-rid-of-update-notifications-for-a-given-app-in-google-play-store>

### New voicemail notification

Disable:

- <http://android.stackexchange.com/questions/60103/how-can-i-disable-voicemail-notifications>
- <http://forums.androidcentral.com/samsung-galaxy-s4/276901-there-way-turn-off-voicemail-notifications.html>

## Bloatware

Shitty software pre-installed by OEMs or carriers to get money from your personal information.

E.g., my Vivo (Brazilian carrier) + Sony Xperia Z3 has bloatware from both Vivo and Sony.

Apple forbids carriers from doing it it seems.

<http://www.greenbot.com/article/2920125/dear-carriers-please-stop-putting-bloatware-on-my-android-phone.html>

And on top of that, most bloatware cannot be uninstalled without rooting!!

### Skins

GUI changes made by OEMs or carriers to steal your data.

- Samsung: <https://en.wikipedia.org/wiki/TouchWiz>
- LG G UI
- HTC Sense UI
- Sony Xperia UI

### Stock device

No bloatware.

Near stock devices: <http://www.phonearena.com/news/Best-2015-smartphones-that-run-stock-or-near-stock-Android_id75780>

#### Google play edition

Certified near stock devices.

<https://en.wikipedia.org/wiki/List_of_Google_Play_edition_devices>

<http://arstechnica.com/gadgets/2015/01/dont-cry-for-the-google-play-edition-program-it-was-already-dead/>

Died.

#### Google Nexus

<https://en.wikipedia.org/wiki/Google_Nexus>

No bloatware phones.

Strategy:

- <https://www.quora.com/Why-doesnt-Google-start-manufacturing-phones>

### QR code scan

No built-in apparently:

- <http://www.pcadvisor.co.uk/how-to/google-android/how-scan-codes-with-your-smartphone-3513431/>
- <https://www.quora.com/Why-havent-Google-or-Apple-embedded-a-QR-reader-in-their-Camera-apps>
- <http://www.androidcentral.com/using-android-and-qr-codes>

### Panoramic photo

Was installed by default on 5.1.1 Xperia Z3 as a "camera app".

Open the camera, and search for it.

### App version

Find:

- any way <http://android.stackexchange.com/questions/2016/how-can-you-tell-which-version-of-an-app-is-on-your-android-phone/130407#130407>
- adb <http://stackoverflow.com/questions/11942762/get-application-version-name-using-adb>

## Linux file transfer

## Media transfer mode

## Mass storage mode

- <http://askubuntu.com/questions/189591/connecting-android-4ice-cream-sandwich-jelly-bean-kitkat-phone>
- <http://askubuntu.com/questions/199280/how-to-install-pc-companion-software-of-sony-xperia>
- <http://android.stackexchange.com/questions/66385/how-to-transfer-files-from-an-android-phone-to-a-ubuntu-pc-by-using-a-usb-cable>
- <http://android.stackexchange.com/questions/91900/is-there-a-viable-alternative-to-mtp-for-file-transfer?lq=1>

SSH method working: http://askubuntu.com/questions/189591/connecting-android-4ice-cream-sandwich-jelly-bean-kitkat-phone#comment1035980_222851

## App isolation

Each App runs under a different UID: <http://security.stackexchange.com/questions/67188/android-app-isolation-risks-implementation> So it just reuses Linux's security.

## HTML GUI

<http://stackoverflow.com/questions/9045355/how-to-create-an-android-app-using-html-5>
<http://developer.android.com/guide/webapps/index.html>

Android uses it's custom GUI API. Some day, maybe.

### APK

Packaging format for android apps.

#### Aligned vs unaligned

<http://stackoverflow.com/questions/22058210/why-unaligned-apk-is-needed>

### AOKP

https://en.wikipedia.org/wiki/AOKP

http://android.stackexchange.com/questions/50491/what-is-the-difference-between-aosp-and-aokp

### ODEX

### Optimizing apps

### Dalvik cache

- <https://www.quora.com/What-is-Android-doing-when-after-an-upgrade-it-tells-you-its-optimizing-the-apps>
- <http://stackoverflow.com/questions/7541281/what-is-dalvik-and-dalvik-cache>
- <https://en.wikipedia.org/wiki/Dalvik_%28software%29>

Replaced by ART in Android 5.

### ART

Successor of Dalvik.

No JIT, full AOT is done.

### x86

-   <http://stackoverflow.com/questions/17770907/is-android-os-only-used-for-arm-cpus>

-   <http://www.android-x86.org/>

    TODO: linked to the Intel partnership? Or that one is yet to be released?

### Java 8

Nope: <http://stackoverflow.com/questions/23318109/is-it-possible-to-use-java-8-for-android-development>

### libc

Bionic, Google-made.

### ROM

Read only memory.

Stores the OS.

Mounted under `/system`

If you root the device, you can change it, and make a custom Android however you like.

<https://www.youtube.com/watch?v=RIi4KXgZYsI&feature=iv&src_vid=AWNykj-lb-I&annotation_id=annotation_162326159>

### USB debugging mode

TODO? What is that?

Enabled from Developer options

Disable the eternal notification: <http://android.stackexchange.com/questions/5075/how-do-i-disable-the-usb-connected-notification>

### Tether

<https://en.wikipedia.org/wiki/Tethering>

Requires root, but available on Google Store.

Carriers may require you to pay for that if you tether from their network instead of LAN, which is why Android disables it by default.

Root allows you to re-enable that.

### HBOOT

The Android bootloader?

- <http://android.stackexchange.com/questions/27920/what-does-hboot-mean>

## Smart lock

Unlock in some cases without a password.

On-body detection: <http://www.androidcentral.com/body-detection-explained> Uses accelerometer.

Known WIFI not available it seems:

- <https://www.reddit.com/r/Android/comments/2pyyk5/smartlock_request_wifi_please_googs/>

## Piracy

- <http://www.businessinsider.com/android-piracy-problem-2015-1>

## Soft reset vs reboot

TODO?

- <https://www.reddit.com/r/xposed/comments/215ord/what_is_the_difference_between_reboot_and_soft/>
- <http://android.stackexchange.com/questions/123905/what-is-the-difference-between-temp-root-pemanent-root-what-is-a-soft-reboot>

Apparently soft rest is more superficial, and thus faster, but solves less problems.

## Sony Xperia

### Xperia Home

Reset home screen to device default:

    Settings -> Apps -> All -> Xperia Home -> Clear data -> OK.

## Do not disturb

## Silent mode

## Blocking mode

TODO where is it?? How to turn it on?

## Linux run Android app natively

- <http://thenextweb.com/google/2015/04/02/google-releases-a-tool-for-developers-to-launch-android-apps-on-windows-mac-linux-and-chrome-os/>
- <https://www.linux.com/learn/tutorials/842630-installing-android-apps-on-linux-with-archon>
- <https://www.maketecheasier.com/running-android-apps-on-linux/>

## Peripherals

- joystick root calibration method <https://www.youtube.com/watch?v=GwrGpVquGyo>

## aar

## Android library project

<http://stackoverflow.com/questions/23915619/android-archive-library-aar-vs-standard-jar>

## fugu

<http://www.androidpolice.com/2014/11/05/the-nexus-player-fugu-initial-android-5-0-factory-image-and-binaries-are-ready-to-download-now/>

## Screen pinning

<http://www.cnet.com/how-to/ho-to-pin-apps-in-android-5-lollipop/>

## Phone without battery

If you link USB power cables directly to the battery energy entry points, it works: <https://www.youtube.com/watch?v=f0IuBld2lzA>

## Secret codes

<http://android.stackexchange.com/questions/35758/how-to-view-the-android-service-menu-secret-menu>

Vary with Model, OEM and Carrier. TODO: are any built into the core?

## Hardware

<http://developer.android.com/guide/topics/sensors/sensors_environment.html>

## Enterprises

### Open Handset Alliance

<https://en.wikipedia.org/wiki/Open_Handset_Alliance>

## Hardware requirements

Memory:

- <http://android.stackexchange.com/questions/34958/what-are-the-minimum-hardware-specifications-for-android>
- <https://www.quora.com/What-is-the-minimum-RAM-size-needed-to-run-Android-5-1-or-6>

## Native libraries available

TODO Which native libraries must be available on all Android systems?

OpenCL: mostly not:

- <http://arrayfire.com/opencl-on-mobile-devices/>
- <http://stackoverflow.com/questions/9005352/how-to-use-opencl-on-android>
- <http://stackoverflow.com/questions/26795921/does-android-support-opencl>

## UART

## Serial

- via headphone jack! <https://www.pentestpartners.com/blog/how-to-hardware-hack-android-over-uart/>

## New and Optimized Features

The following new and optimized features have been added to the repository:

- **Real-time Logcat Filtering**: Stream and filter the device's system logs in real-time based on your criteria. This can be useful for debugging and monitoring specific events.
- **Browsing Basic Media Content**: List media files in common directories on the device. This can be useful for quickly accessing and managing media files.
- **Inspecting Application Data Directories**: Browse the internal data directories of applications. This requires root access or the application to be debuggable.
- **Incremental APK Installation**: Speed up the installation process for large APKs on Android 11 and later by using the `--incremental` flag with the `adb install` command.

## NSFW Search Functionality

The NSFW search functionality allows you to filter content for not safe for work (NSFW) material. It can be useful for content filtering and ensuring that inappropriate content is not displayed.

### Benefits of NSFW Search

- Helps in filtering out inappropriate content.
- Useful for applications that need to ensure a safe browsing experience.

### Enabling and Using NSFW Search

1. Implement NSFW search functionality in your application.
2. Use appropriate algorithms and libraries to detect and filter NSFW content.
3. Test the feature thoroughly to ensure accurate filtering.

## IP Trace through Messenger

The IP trace through messenger functionality allows you to trace an IP address through a messenger application. This can be useful for monitoring network traffic and analyzing network-related information.

### Benefits of IP Trace through Messenger

- Helps in monitoring network traffic and analyzing network-related information.
- Useful for applications that need to trace IP addresses.

### Enabling and Using IP Trace through Messenger

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
```
