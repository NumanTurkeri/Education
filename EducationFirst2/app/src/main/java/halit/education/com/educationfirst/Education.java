package halit.education.com.educationfirst;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

/**
 * Created by numan_turkeri on 1.11.2017.
 */

public class Education extends Application {
    public static Gson gson;
    public static SharedPreferences shared;
    public static SharedPreferences.Editor editor;

    @Override
    public void onCreate() {
        super.onCreate();
        gson = new Gson();
        shared = PreferenceManager.getDefaultSharedPreferences(this);
        editor = shared.edit();
    }
}
