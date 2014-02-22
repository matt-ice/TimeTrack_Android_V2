package com.example.timetrack_android_v2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class second extends Activity {
    public static final String myPrefs = "MyPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView txtIn = (TextView)findViewById(R.id.txtInSave);
        TextView txtOut = (TextView)findViewById(R.id.txtOutSave);

        SharedPreferences shPrefs =  getSharedPreferences(myPrefs,0);

        txtIn.setText(shPrefs.getString("punchIn","wrong"));
        txtOut.setText(shPrefs.getString("punchOut","not out yet"));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second, menu);
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
