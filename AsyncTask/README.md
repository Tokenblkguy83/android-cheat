# AsyncTask

This project demonstrates the usage of `AsyncTask` in an Android application. An `AsyncTask` is started when the app launches, and three seconds later, it leads to a change in the main activity.

## Features

- Demonstrates the usage of `AsyncTask` for background processing.
- Shows how to update the UI from a background thread.
- Includes a timeout mechanism to cancel the `AsyncTask` if it takes too long to complete.

## Usage

1. Clone the repository:
   ```sh
   git clone https://github.com/cirosantilli/android-cheat.git
   cd android-cheat/AsyncTask
   ```

2. Open the project in Android Studio.

3. Build and run the app on an emulator or a physical device.

## Example

The `MainActivity` class starts an `AsyncTask` when the app launches. The `AsyncTask` performs a background operation (e.g., a network request or a long-running computation) and updates the UI after three seconds.

```java
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new MyAsyncTask().execute();
    }

    private static class MyAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(3000); // Simulate a long-running operation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            // Update the UI after the background operation is complete
            TextView textView = findViewById(R.id.textView);
            textView.setText("AsyncTask completed!");
        }
    }
}
```

## Troubleshooting

### Common Issues

1. **App crashes on launch**: Make sure you have the necessary permissions and dependencies in your `AndroidManifest.xml` and `build.gradle` files.

2. **UI not updating**: Ensure that you are updating the UI on the main thread (e.g., in the `onPostExecute` method of the `AsyncTask`).

### FAQs

1. **Why use `AsyncTask`?**
   `AsyncTask` is a convenient way to perform background operations and update the UI without blocking the main thread.

2. **Can I use other threading mechanisms?**
   Yes, you can use other threading mechanisms like `HandlerThread`, `ExecutorService`, or `RxJava` for more complex use cases.
