package cn.king.test;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.test.AndroidTestCase;
import android.util.Log;

public class ContentProvideTest extends AndroidTestCase {
	private static String TAG = "ContentProvideTest";
	public void test(){
		ContentResolver resolver = this.getContext().getContentResolver();
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
		cursor.close();
		
		values.put("age", 20);
		resolver.update(Uri.parse("content://cn.king.provider.person/person/"+id), values, null, null);
		cursor = resolver.query(uri, null, selection, selectionArgs, null);
		while(cursor.moveToNext()){
			Log.i(TAG, String.format("id:%s; name:%s; age:%s", cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
		}
		cursor.close();

		values.put("age", 30);
		resolver.update(uri, values, selection, selectionArgs);
		cursor = resolver.query(uri, null, selection, selectionArgs, null);
		while(cursor.moveToNext()){
			Log.i(TAG, String.format("id:%s; name:%s; age:%s", cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
		}
		cursor.close();

		id = resolver.delete(Uri.parse("content://cn.king.provider.person/person/"+id), null, null);
		Log.i(TAG, "delete:" + id);
//		resolver.delete(uri, selection, selectionArgs);
		
	}
}
