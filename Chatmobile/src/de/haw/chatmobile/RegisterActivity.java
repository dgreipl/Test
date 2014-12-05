package de.haw.chatmobile;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import de.haw.chatmobile.core.MyPrefs;

public class RegisterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void doRegister(View view){
		
		// A. get Data from GUI field
		String nickname;
		nickname = ((EditText)  findViewById(R.id.editNickName)).getText().toString();
		// ... homework
		// B. Validate Data (homework!) 
		
		// C. Send Registration request to serv4er
		//...später, wenn Server fertig 
		
		// D. Receive and Store registration data 
		//...Simulation des Erhaltes von Server Daten. 
		
		String regId = String.valueOf( Math.abs (new Random().nextLong() ) );
		MyPrefs.setRegID( regId );
		this.finish();
		
		
	}
}
