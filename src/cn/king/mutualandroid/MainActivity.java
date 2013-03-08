package cn.king.mutualandroid;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ContentResolver resolver = this.getContentResolver();
		Uri uri = Uri.parse("content://cn.king.provider.person/person");
		ContentValues values = new ContentValues();
		values.put("name", "天收仔");
		values.put("age", 15);
		resolver.insert(uri, values);
		
		String selection = "name=?";
		String[] selectionArgs = new String[]{"天收仔"};
		Cursor cursor = resolver.query(uri, null, selection, selectionArgs, null);
		long id = 0;
		while(cursor.moveToNext()){
			Log.i(TAG, String.format("id:%s; name:%s; age:%s", cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
			id = cursor.getLong(0);
		}
		
		values.put("age", 20);
		resolver.update(Uri.parse("content://cn.king.provider.person/person/"+id), values, null, null);
		cursor = resolver.query(uri, null, selection, selectionArgs, null);
		while(cursor.moveToNext()){
			Log.i(TAG, String.format("id:%s; name:%s; age:%s", cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
		}

		values.put("age", 30);
		resolver.update(uri, values, selection, selectionArgs);
		cursor = resolver.query(uri, null, selection, selectionArgs, null);
		while(cursor.moveToNext()){
			Log.i(TAG, String.format("id:%s; name:%s; age:%s", cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
		}
		
		
		values.put("age", 20);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
