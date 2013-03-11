package cn.king.mutualandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class OtherAppActivity extends Activity {
	private static final String TAG = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		boolean fromOther = this.getIntent().getBooleanExtra("other", false);
		Log.i(TAG,"fromOther:" + fromOther);
		if(fromOther){
			String hello = this.getIntent().getStringExtra("hello");
			TextView helloTxt = (TextView)this.findViewById(R.id.hello);
			helloTxt.setText("其它界面，来自应用："+hello);
		}
	}
	
}
