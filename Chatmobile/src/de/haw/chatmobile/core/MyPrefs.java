package de.haw.chatmobile.core;

import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class MyPrefs {

	private final static String PROPERTY_REGID = "REGID";

	private static final String TAG = "MyPrefs";

	private static SharedPreferences sharedPref;
	private static SharedPreferences.Editor editor;

	public static void init(Context context) {
		sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
		editor = sharedPref.edit();
	}

	public static void setRegID(String s) {
		editor.putString("PROPERTY_REGID", s);
		Log.d(TAG,"Saving : " + s);
		editor.commit();

	}

	public static String getRegID() {
		String s = sharedPref.getString(PROPERTY_REGID, "");
		Log.d(TAG,"RegID = "+ s);

		return s;

	}
	
	

}
