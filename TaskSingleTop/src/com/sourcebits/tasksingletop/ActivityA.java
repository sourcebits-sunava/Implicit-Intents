package com.sourcebits.tasksingletop;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class ActivityA extends Activity implements OnClickListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_a);
		Toast.makeText(this,"On creating ActivityA",Toast.LENGTH_LONG).show();
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
	public void onClick(View v) 
	{
		Intent intent = new Intent(this, ActivityB.class); 
		startActivity(intent);
	}
	
	@Override
	protected void onNewIntent(Intent intent) 
	{
		super.onNewIntent(intent);
		Toast.makeText(this,"ActivityA new Intent",Toast.LENGTH_LONG).show();
	}
	@Override
	protected void onResume() {
		super.onResume();
		Toast.makeText(this,"ActivityA resumed",Toast.LENGTH_LONG).show();
	}
}
