package com.basuhampali.housiegame;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SelectTicketActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_ticket);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_select_ticket, menu);
		return true;
	}
	
	@Override
	protected void onResume() {
		// animateIn this activity
		//ActivitySwitcher.animationIn(findViewById(R.id.selectlinear), getWindowManager());
		super.onResume();
	}

	public void ticketOnClick(View V){
		LinearLayout ll = (LinearLayout) findViewById(V.getId());
		final Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
		
		//startActivity(intent);
		
		
	
		if(ll.getId()==R.id.linearticket1){
			intent.putExtra("ticket", 1);
		}
		else if(ll.getId()==R.id.linearticket2){
			intent.putExtra("ticket", 2);
		}
		else if(ll.getId()==R.id.linearticket3){
			intent.putExtra("ticket", 3);
		}
		else if(ll.getId()==R.id.linearticket4){
			intent.putExtra("ticket", 4);
		}
		else if(ll.getId()==R.id.linearticket5){
			intent.putExtra("ticket", 5);
		}
		startActivity(intent);
		
		/*intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		ActivitySwitcher.animationOut(findViewById(R.id.selectlinear), getWindowManager(), new ActivitySwitcher.AnimationFinishedListener() {
			@Override
			public void onAnimationFinished() {
				startActivity(intent);
			}
		});*/
	}
	
	@Override
	public void onBackPressed() {
		final Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
		intent.putExtra("ticket", 0);
		startActivity(intent);
		
		/*intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		ActivitySwitcher.animationOut(findViewById(R.id.selectlinear), getWindowManager(), new ActivitySwitcher.AnimationFinishedListener() {
			@Override
			public void onAnimationFinished() {
				startActivity(intent);
			}
		});*/
	}
}
