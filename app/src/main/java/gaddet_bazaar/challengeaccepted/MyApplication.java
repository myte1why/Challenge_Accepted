package gaddet_bazaar.challengeaccepted;

import android.app.Application;

import com.parse.Parse;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "wjJOQEbz9NoeeF92YncLPcOCfLwlWFq8sipVnv4m", "adi8YGFIWSMKhJ3KpOOoA2dt4qpBPLMdNjfN1m0f");

    }

}
