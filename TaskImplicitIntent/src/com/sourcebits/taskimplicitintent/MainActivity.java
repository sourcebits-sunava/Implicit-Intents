package com.sourcebits.taskimplicitintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener
{
	EditText text;
	String dataToShare;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		text= (EditText)findViewById(R.id.Edit);
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
		 dataToShare = text.getText().toString(); 
		 Intent sendIntent = new Intent();
		 
		 if(view.getId()==R.id.shareText) 
		 {
			 sendIntent.setAction(Intent.ACTION_SEND); 
             sendIntent.putExtra(Intent.EXTRA_TEXT, dataToShare); 
             sendIntent.setType("text/plain"); 
             startActivity(sendIntent);
		 }
		 if(view.getId()==R.id.shareVideo) 
		 {
			 sendIntent.setAction(Intent.ACTION_SEND); 
             sendIntent.putExtra(Intent.EXTRA_STREAM, dataToShare); 
             sendIntent.setType("Video/*"); 
             startActivity(sendIntent);
			 
		 }
		 if(view.getId()==R.id.shareURL) 
		 {
			 sendIntent.setAction(Intent.ACTION_VIEW); 
			 String Url = dataToShare;
			 sendIntent.setData(Uri.parse(Url));
			 startActivity(sendIntent);
			
		 }
		 if(view.getId()==R.id.shareApp) 
		 {
			 Intent intent = new Intent("com.sourcebits.activityatobtoa.MainActivity");
			 startActivity(intent);
			
		 }
		 
		
	}
}
