package de.haw.chatmobile;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SendActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.send, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.itemSend) {
			doSend();
			this.finish();
		}
		return super.onOptionsItemSelected(item);
	}

	public void doSend() {
		EditText m;
		m = (EditText) findViewById(R.id.editTextMessage);
		// TODO implement sending here

		Toast.makeText(getApplicationContext(),
				"Message:" + m.getText().toString(), Toast.LENGTH_LONG).show();

	}
	
	public void doCancel(View view){
		this.finish();
		
		
		
	}
}
