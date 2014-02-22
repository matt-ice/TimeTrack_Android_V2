package com.example.timetrack_android_v2;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;
*/

public class MainActivity extends Activity {

    public static final String myPrefs = "MyPreferences";

    public String getCurrentTime(){
        Date currentDate = new Date();
        DateFormat simpleDF = new SimpleDateFormat("hh:mm");
        return simpleDF.format(currentDate);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        setTheme(android.R.style.Theme_Holo);
        final Button btnIn;
        final Button btnOut;
        final Button btnTest;
        btnIn = (Button) findViewById(R.id.btnIn);
        btnOut = (Button) findViewById(R.id.btnOut);
        btnTest = (Button) findViewById(R.id.btnTestSave);
        final TextView txtDisplayIn = (TextView) findViewById(R.id.txtIn);
        final TextView txtDisplayOut = (TextView) findViewById(R.id.txtOut);
        final TextView txtDisplayOutDesc = (TextView) findViewById(R.id.txtDisplayOutDescription);

        SharedPreferences shPrefs = getSharedPreferences(myPrefs,0);
        txtDisplayIn.setText(shPrefs.getString("punchIn","Not in yet"));
        txtDisplayOut.setText(shPrefs.getString("punchOut","Not out yet"));

        View.OnClickListener pressHandlerIn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tempDate = getCurrentTime();
                txtDisplayIn.setText(tempDate);
                SharedPreferences shPrefs = getSharedPreferences(myPrefs,0);
                SharedPreferences.Editor editor = shPrefs.edit();
                editor.putString("punchIn",txtDisplayIn.getText().toString());
                txtDisplayOut.setVisibility(View.INVISIBLE);
                txtDisplayOutDesc.setVisibility(View.INVISIBLE);
                editor.commit();
            }
        };

        View.OnClickListener pressHandlerOut = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tempDate = getCurrentTime();
                txtDisplayOut.setText(tempDate);
                SharedPreferences shPrefs = getSharedPreferences(myPrefs,0);
                SharedPreferences.Editor editor = shPrefs.edit();
                editor.putString("punchOut",txtDisplayOut.getText().toString());
                editor.commit();
                txtDisplayOut.setVisibility(View.VISIBLE);
                txtDisplayOutDesc.setVisibility(View.VISIBLE);
            }
        };


        btnIn.setOnClickListener(pressHandlerIn);
        btnOut.setOnClickListener(pressHandlerOut);

        View.OnClickListener pressHandlerTest = new View.OnClickListener(){
          @Override
        public void onClick(View view){
              Intent saveIntent = new Intent(getApplicationContext(),second.class);
              startActivity(saveIntent);
          }
        };
        btnTest.setOnClickListener(pressHandlerTest);
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
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;

        }
    }



}
