# aapt

The Android Asset Packaging Tool (aapt) is a command-line tool that is used to create, inspect, and update Android application packages (APKs). It is an essential tool for Android developers as it handles the packaging of resources, assets, and compiled code into an APK file.

## Usage

Here are some common uses of the `aapt` tool:

### Create an APK

To create an APK from compiled resources and assets, use the following command:

    aapt package -f -m -J gen -M AndroidManifest.xml -S res -I <path_to_android_jar> -F bin/app.ap_

### List contents of an APK

To list the contents of an APK file, use the following command:

    aapt list <path_to_apk>

### Dump badging information

To dump badging information from an APK file, use the following command:

    aapt dump badging <path_to_apk>

### Add or update resources in an APK

To add or update resources in an existing APK file, use the following command:

    aapt add <path_to_apk> <path_to_resource>

## aapt2

`aapt2` is the newer version of `aapt` and provides improved performance and additional features. It is recommended to use `aapt2` for building modern Android applications.

### Usage

Here are some common uses of the `aapt2` tool:

### Compile resources

To compile resources using `aapt2`, use the following command:

    aapt2 compile -o compiled_res.zip <path_to_res_directory>

### Link resources

To link compiled resources and create an APK, use the following command:

    aapt2 link -o output.apk -I <path_to_android_jar> --manifest AndroidManifest.xml compiled_res.zip
