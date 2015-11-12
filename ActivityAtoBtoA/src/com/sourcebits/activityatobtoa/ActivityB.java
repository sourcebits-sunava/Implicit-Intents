package com.sourcebits.activityatobtoa;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ActivityB extends Activity 
{
	Intent returnIntent;
	Bundle resultBundle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
	    alertDialogBuilder.setMessage("Are you sure,You wanted to go to MainActivity");
	      
	    alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() 
	    {
	    	@Override
	    	public void onClick(DialogInterface arg0, int arg1)
	    	{
	    		returnIntent = new Intent();
	    		resultBundle = new Bundle();
	    		resultBundle.putString("message", "Yes");
	    		returnIntent.putExtras(resultBundle);
	    		setResult(RESULT_OK, returnIntent);
	    		finish();
	    		
	        }
	    });
	      
	      alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener()
	      {
	         @Override
	         public void onClick(DialogInterface dialog, int which) 
	         {
	        	 Toast.makeText(ActivityB.this,"You clicked no button",Toast.LENGTH_LONG).show();
	         }
	      });
	      alertDialogBuilder.show();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_b, menu);
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
}
