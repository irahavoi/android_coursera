package course.labs.activitylab;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	// Use these as keys when you're saving state between reconfigurations
	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters
	private int mCreate;
	private int mStart;
	private int mResume;
	private int mRestart;
	
	private TextView mTvCreate;
	private TextView mTvStart;
	private TextView mTvResume;
	private TextView mTvRestart;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_two);

		mTvCreate = (TextView) findViewById(R.id.create);
		mTvStart = (TextView) findViewById(R.id.start);;
		mTvResume = (TextView) findViewById(R.id.resume);;
		mTvRestart = (TextView) findViewById(R.id.restart);;

		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				((Activity)v.getContext()).finish();
			}
		});

		// Has previous state been saved?
		if (savedInstanceState != null) {
			mCreate = savedInstanceState.getInt(getString(R.string.onCreateCounter));
			mStart = savedInstanceState.getInt(getString(R.string.onStartCounter));
			mResume = savedInstanceState.getInt(getString(R.string.onResumeCounter));
			mRestart = savedInstanceState.getInt(getString(R.string.onRestartCounter));
		}

		// Emit LogCat message
		Log.i(TAG, "Entered the onCreate() method");

		mCreate++;
		displayCounts();
	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();
		// Emit LogCat message
		Log.i(TAG, "Entered the onStart() method");

		mStart++;
		displayCounts();
	}

	@Override
	public void onResume() {
		super.onResume();
		// Emit LogCat message
		Log.i(TAG, "Entered the onResume() method");

		mResume++;
		displayCounts();
	}

	@Override
	public void onPause() {
		super.onPause();

		// Emit LogCat message
		Log.i(TAG, "Entered the onPause() method");
	}

	@Override
	public void onStop() {
		super.onStop();

		// Emit LogCat message
		Log.i(TAG, "Entered the onStop() method");
	}

	@Override
	public void onRestart() {
		super.onRestart();
		// Emit LogCat message
		Log.i(TAG, "Entered the onRestart() method");

		mRestart++;
		displayCounts();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// Emit LogCat message
		Log.i(TAG, "Entered the onDestroy() method");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState){
		savedInstanceState.putInt(getString(R.string.onCreateCounter), mCreate);
		savedInstanceState.putInt(getString(R.string.onStartCounter), mStart);
		savedInstanceState.putInt(getString(R.string.onResumeCounter), mResume);
		savedInstanceState.putInt(getString(R.string.onRestartCounter), mRestart);
	}

	// Updates the displayed counters
	// This method expects that the counters and TextView variables use the
	// names
	// specified above
	public void displayCounts() {
		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	
	}
}
