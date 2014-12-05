package de.haw.chatmobile;

import java.util.ArrayList;

import de.haw.chatmobile.core.MyPrefs;

import test.ChatMessage;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The Main Activity.
 * 
 * This activity starts up the RegisterActivity immediately, which communicates
 * with your App Engine backend using Cloud Endpoints. It also receives push
 * notifications from backend via Google Cloud Messaging (GCM).
 * 
 * Check out RegisterActivity.java for more details.
 */
public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";
	private ArrayList<ChatMessage> chatList = new ArrayList<ChatMessage>();
	private ArrayAdapter<ChatMessage> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(TAG, "onCreate called.");
		
		//init MyPrefs
		MyPrefs.init(getApplicationContext());

		// Testeintraege
		chatList.add(new ChatMessage("A-Maier", "B-Huber", "Nachricht1"));
		chatList.add(new ChatMessage("A-Müller", "B-Huber", "Nachricht2"));
		chatList.add(new ChatMessage("A-Bauer", "B-Huber", "Nachricht3"));

		adapter = new ArrayAdapter<ChatMessage>(this,
				android.R.layout.simple_list_item_2, android.R.id.text1,
				chatList) {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				TextView text1, text2;
				View view = super.getView(position, convertView, parent);
				text1 = (TextView) view.findViewById(android.R.id.text1);
				text2 = (TextView) view.findViewById(android.R.id.text2);

				ChatMessage m = chatList.get(position);
				text1.setText(m.getA());
				text2.setText(m.getMessage());
				return view;

			}

		};

		// Connect adapter to list

		ListView l = (ListView) findViewById(R.id.listMessages);
		l.setAdapter(adapter);
		l.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Replace with send code later
				Intent intent = new Intent(getApplication(), SendActivity.class);
				startActivity(intent);

				Toast.makeText(getApplicationContext(), "Click on" + position,
						Toast.LENGTH_LONG).show();

			}

		});

	}

	@Override
	protected void onStart() {
		super.onStart();
		if(MyPrefs.getRegID().equals("")){
			
			adapter.clear();

		}
		
		else{
			chatList.clear();
			chatList.add(new ChatMessage("A-Maier", "B-Huber", "Nachricht1"));
			chatList.add(new ChatMessage("A-Müller", "B-Huber", "Nachricht2"));
			chatList.add(new ChatMessage("A-Bauer", "B-Huber", "Nachricht3"));
			adapter.addAll(chatList); 
			
			
		}
		invalidateOptionsMenu();
		Log.d(TAG, "onStart called.");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume called.");
	}

	// Menu anzeigen weches wir gerade gemacht haben (analogClock usw) :

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!MyPrefs.getRegID().isEmpty()) {

			getMenuInflater().inflate(R.menu.main, menu);

		} else {
			getMenuInflater().inflate(R.menu.main_not_registered, menu);

		}

		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
		int id = item.getItemId();
		switch (id) {

		case R.id.idSettings:
			intent = new Intent(getApplication(), SettingsActivity.class);
			startActivity(intent);
			break;
			
		case R.id.idRegister:
			intent = new Intent(getApplication(), RegisterActivity.class);
			startActivity(intent);
			break;
			
		}
				

		return super.onOptionsItemSelected(item);
	}

}
