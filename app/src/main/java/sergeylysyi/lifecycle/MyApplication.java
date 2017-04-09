package sergeylysyi.lifecycle;

import android.app.Application;
import android.content.res.Configuration;

public class MyApplication extends Application {

    public static final String TAG = "MyApplication";
    public Logger logger;

    public Logger logger() {
        return logger;
    }

    @Override
    public void onCreate() {
        logger = new Logger();
        logger.i(TAG, "onCreate called");
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        logger.i(TAG, "onTerminate called");
        super.onTerminate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        logger.i(TAG, "onConfigurationChanged called");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        logger.i(TAG, "onLowMemory called");
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        logger.i(TAG, "onTrimMemory called");
        super.onTrimMemory(level);
    }
}
