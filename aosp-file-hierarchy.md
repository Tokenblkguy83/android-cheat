# AOSP file hierarchy

-   `frameworks/base/core/java`: the source for the Java files which we can import from Android projects, e.g. `frameworks/base/core/java/android/widget/EditText.java`.
-   `cts`: <http://source.android.com/compatibility/cts/>

## New directories and files in recent AOSP versions

### Android 10 and later

#### Scoped Storage

Android 10 introduced Scoped Storage, which changes the way apps access files on the device. This affects how apps interact with the file system. To work with files in the app-specific directories, you can use the `android:requestLegacyExternalStorage` attribute in the manifest to request the legacy storage model.

Example:

    <application
        android:requestLegacyExternalStorage="true"
        ... >
        ...
    </application>

#### Bubbles

Android 10 introduced Bubbles, a new way to display notifications. To use Bubbles, you need to add the `android:enableBubbles` attribute to your notification channel.

Example:

    <channel
        android:id="@string/channel_id"
        android:name="@string/channel_name"
        android:enableBubbles="true"
        ... >
        ...
    </channel>

### Android 11 and later

#### One-time Permissions

Android 11 introduced one-time permissions, which allow users to grant temporary access to sensitive data. To use one-time permissions, you need to add the `android:foregroundServiceType` attribute to your service declaration.

Example:

    <service
        android:name=".MyForegroundService"
        android:foregroundServiceType="location"
        ... >
        ...
    </service>

#### Wireless Debugging

Android 11 introduced wireless debugging, which allows you to connect to a device over Wi-Fi without needing a USB cable. To enable wireless debugging, you need to add the `android:usesCleartextTraffic` attribute to your application declaration.

Example:

    <application
        android:usesCleartextTraffic="true"
        ... >
        ...
    </application>
