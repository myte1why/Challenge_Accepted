package gaddet_bazaar.challengeaccepted;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.ParseTwitterUtils;
import com.parse.SaveCallback;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        String parseApi = getString(R.string.parse_app_id);
        String parseClient = getString(R.string.parse_client_key);
        String twitter_consumer_key = getString(R.string.twitter_consumer_key);
        String twitter_consumer_secret = getString(R.string.twitter_consumer_secret);

        Parse.initialize(this, parseApi, parseClient);
        ParseInstallation.getCurrentInstallation().saveInBackground();

        ParseTwitterUtils.initialize(twitter_consumer_key, twitter_consumer_secret);

        ParsePush.subscribeInBackground("", new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
                } else {
                    Log.e("com.parse.push", "failed to subscribe for push", e);
                }
            }
        });

        
    }

}
