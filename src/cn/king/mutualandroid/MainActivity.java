package cn.king.mutualandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		boolean fromOther = this.getIntent().getBooleanExtra("other", false);
		Log.i(TAG,"fromOther:" + fromOther);
		if(fromOther){
			String hello = this.getIntent().getStringExtra("hello");
			TextView helloTxt = (TextView)this.findViewById(R.id.hello);
			helloTxt.setText("主界面，来自应用："+hello);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
