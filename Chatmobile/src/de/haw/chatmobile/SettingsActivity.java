package de.haw.chatmobile;

import de.haw.chatmobile.core.MyPrefs;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SettingsActivity extends Activity implements
		SettingsFragment.OnFragmentInteractionListener {

	private static final String TAG = "Settingsactivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getFragmentManager().beginTransaction()
				.replace(android.R.id.content, new SettingsFragment()).commit();

	}

	@Override
	public void onFragmentInteraction(String s) {
		Log.d(TAG, "FragmentInteraction called");
		if (s.equals("UNREGISTER")) {
			doUnregister();
			this.finish();

		}

	}

	private void doUnregister() {
		// Später stehen hier die ServerCalls zum Löschen der Nachrichten
		// und zum Löschen des Users.

		// Die RegID wird aus den Preferences gelöscht

		MyPrefs.setRegID("");

	}

}
