package com.sourcebits.activityatobtoa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener
{
	Button startActivityB;
	Bundle bundle;
	String name;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startActivityB=(Button)findViewById(R.id.changeActivity);
	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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



	@Override
	public void onClick(View view)
	{
		Intent intent = new Intent(this, ActivityB.class); 
		startActivityForResult(intent, 0);
		
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent sendData) 
	{
		
		super.onActivityResult(requestCode, resultCode, sendData);
		if(resultCode==RESULT_OK)
		{
			bundle = sendData.getExtras();
			name  = bundle.getString("message");
			Toast.makeText(MainActivity.this,name,Toast.LENGTH_LONG).show();
		}
		
	}
}
