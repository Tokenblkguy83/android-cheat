# Android manifest

Set name and icon that show on home screen icon:

    <application android:label="@string/app_name" android:icon="@drawable/ic_launcher">

Main class that will be run:

    <activity android:name="AndroidCheatDefault"

Dot in the name:

    <activity android:name=".HelloJni">

<http://stackoverflow.com/questions/4834122/whats-the-dot-for-when-registering-an-activity>

Should be inside the `package` specified at:

    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="com.cirosantilli.android_cheat.default_template"
        android:versionCode="1"
        android:versionName="1.0">

## New attributes and elements in recent Android versions

### Android 10 and later

#### Scoped Storage

Android 10 introduced Scoped Storage, which changes the way apps access files on the device. To work with files in the app-specific directories, you can use the `android:requestLegacyExternalStorage` attribute in the manifest to request the legacy storage model.

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
