package com.basuhampali.housiegame;

import java.util.Random;

import java.util.Arrays;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;



import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {

	int id=0;
	String str[]= {"15","2","8","7","6","5","67","82","99","88","51","42","36","21","77"};
	String[] randomNumberstr = new String[100];
	Timer t = new Timer() ;
	int firstRow=0;
	int secondRow = 0;
	int thirdRow = 0;
	Boolean isJaldiFive=false;
	Boolean isFirstRow=false;
	Boolean isSecondRow=false;
	Boolean isThirdRow = false;
	Boolean isFullHouse = false;
	int ticketNos;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    ticketNos = extras.getInt("ticket");
		}
		if(ticketNos==0){
		setContentView(R.layout.activity_home);
		}
		else if(ticketNos==1){
		setContentView(R.layout.ticket1);
		}
		else if(ticketNos==2){
			setContentView(R.layout.ticket2);
			}
		else if(ticketNos==3){
			setContentView(R.layout.ticket3);
			}
		else if(ticketNos==4){
			setContentView(R.layout.ticket4);
			}
		else if(ticketNos==5){
			setContentView(R.layout.ticket5);
			}
		
		/*for(int i=0;i<99;i++){
			randomNumberstr[i] = String.valueOf(i+1);
		}*/
		
		Integer[] arr = new Integer[100]; 

		for (int i = 0; i < arr.length; i++) { 
		    arr[i] = i; 
		} 

		Collections.shuffle(Arrays.asList(arr)); 

		for (int i = 0; i < arr.length; i++) { 
			randomNumberstr[i]= String.valueOf(arr[i]);
			Log.i("msge", String.valueOf(arr[i]));
		    //System.out.print(arr[i] + " "); 
		} 
		/*int i=0;
		Random randomGenerator = new Random();
	    for (int idx = 1; idx <= 99; ++idx){
	      int randomInt = randomGenerator.nextInt(100);
	    randomNumberstr[i]= String.valueOf(randomInt);
	      i= i+ 1;
	    }*/
		
		//Declare the timer
		//t = new Timer();
		//Set the schedule function and rate
		if(ticketNos==0){
			t.scheduleAtFixedRate(new TimerTask() {

			    @Override
			    public void run() {
			        //Called each time when 1000 milliseconds (1 second) (the period parameter)
			    	//We must use this function in order to change the text view text
			    	runOnUiThread(new Runnable() {

			    	    @Override
			    	    public void run() {
			    	        TextView tv = (TextView) findViewById(R.id.housie_nos);
			    	       /* tv.setText(String.valueOf(randomNumberstr[id].toString()));
			    	        if(id<99){*/
			    	        tv.setText(String.valueOf(str[id].toString()));
			    	        if(id<14){
			    	        id = id + 1;
			    	        }
			    	        else{
			    	        	t.cancel();
			    	        }
			    	    }
			    	     
			    	});
			    }
			         
			},
			//Set how long before to start calling the TimerTask (in milliseconds)
			0,
			//Set the amount of time between each execution (in milliseconds)
			3000);
		}
		else
		{
			t.scheduleAtFixedRate(new TimerTask() {

			    @Override
			    public void run() {
			        //Called each time when 1000 milliseconds (1 second) (the period parameter)
			    	//We must use this function in order to change the text view text
			    	runOnUiThread(new Runnable() {

			    	    @Override
			    	    public void run() {
			    	        TextView tv = (TextView) findViewById(R.id.housie_nos);
			    	        tv.setText(String.valueOf(randomNumberstr[id].toString()));
			    	        if(id<99){
			    	        id = id + 1;
			    	        }
			    	        else{
			    	        	t.cancel();
			    	        }
			    	    }
			    	     
			    	});
			    }
			         
			},
			//Set how long before to start calling the TimerTask (in milliseconds)
			0,
			//Set the amount of time between each execution (in milliseconds)
			3000);
		}
		
		/*Random randomGenerator = new Random();
	    for (int idx = 1; idx <= 15; ++idx){
	      int randomInt = randomGenerator.nextInt(100);
	      (TextView) findViewById(R.id.TextView001).settex
	    }*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_home, menu);
		return true;
	}

	public void housieNumberOnClick(View V){
		
		TextView tv = (TextView) findViewById(V.getId());
		tv.getText();
		if(ticketNos==0){
		for(int i=0;i<=id;i++){
			if(tv.getText().equals(str[i])){
				incrementVewClicked(tv);
				V.setBackgroundColor(Color.GREEN);
				return;
			}
			else
			{
				V.setBackgroundColor(Color.RED);
			}
		}
		}
		else
		{
			for(int i=0;i<=id;i++){
				if(tv.getText().equals(randomNumberstr[i])){
					incrementVewClicked(tv);
					V.setBackgroundColor(Color.GREEN);
					return;
				}
				else
				{
					V.setBackgroundColor(Color.RED);
				}
			}
		}
		//Toast.makeText(this, tv.getText().toString(), 10).show();
		
	}
	
	
	public void selectTicketOnClick(View V){
		final Intent intent = new Intent(getApplicationContext(), SelectTicketActivity.class);
		startActivity(intent);
		
		/*intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		ActivitySwitcher.animationOut(findViewById(R.id.homelinear), getWindowManager(), new ActivitySwitcher.AnimationFinishedListener() {
			@Override
			public void onAnimationFinished() {
				startActivity(intent);
			}
		});*/
	}
	
	
	public void incrementVewClicked(TextView tv){
		if(tv.getId()==R.id.TextView001 || tv.getId()== R.id.TextView003 || tv.getId()== R.id.TextView005 || tv.getId()== R.id.TextView007 || tv.getId()== R.id.TextView009){
			firstRow = firstRow +1;
		}
		else if (tv.getId()==R.id.TextView0011 || tv.getId()== R.id.TextView0013 || tv.getId()== R.id.TextView0015 || tv.getId()== R.id.TextView0017 || tv.getId()== R.id.TextView0018) {
			secondRow = secondRow + 1;
		}
		else if (tv.getId()==R.id.TextView0019 || tv.getId()== R.id.TextView0021 || tv.getId()== R.id.TextView0023 || tv.getId()== R.id.TextView0025 || tv.getId()== R.id.TextView0027) {
			thirdRow = thirdRow + 1;
		}
		if(!isJaldiFive){
			if((firstRow+secondRow+thirdRow) >= 5){
				isJaldiFive=true;
				ShowAlertDialog("Congrats", "You are Jaldi Five winner. You won a Fastrack watch");
			}
		}
		if(!isFirstRow){
			if(firstRow >= 5){
				isFirstRow = true;
				ShowAlertDialog("Congrats", "You are First row winner. You won a brand new Godrej Fredge");
			}
		}
		if(!isSecondRow){
			if(secondRow >= 5){
				isSecondRow = true;
				ShowAlertDialog("Congrats", "You are Second row winner. You won a brand new Godrej TV");
			}
		}
		if(!isThirdRow){
			if(thirdRow >= 5){
				isThirdRow = true;
				ShowAlertDialog("Congrats", "You are third row winner. You won a brand new Godrej Double Bed");
			}
		}
		
		if(!isFullHouse){
			if((firstRow+secondRow+thirdRow) == 15){
				isFullHouse = true;
				t.cancel();
				ShowAlertDialog("Congrats", "You are Full House winner. You won a brand new iPhone 5");
			}
		}
	}
	
	public void ShowAlertDialog(String tittle, String message){
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				this);
 
			// set title
			alertDialogBuilder.setTitle(tittle);
 
			// set dialog message
			alertDialogBuilder
				.setMessage(message)
				.setCancelable(false)
				.setPositiveButton("Thanks",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, close
						// current activity
						dialog.cancel();
					}
				  });
				
 
				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();
 
				// show it
				alertDialog.show();
	}
	@Override
	protected void onResume() {
		// animateIn this activity
		
		//ActivitySwitcher.animationIn(findViewById(R.id.homelinear), getWindowManager());
		super.onResume();
	}
}
