package com.example.helloworld;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.os.Build;
import android.widget.Button;
import android.widget.ImageView;
import android.util.Log;
//import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
	private static String logtag = "ButtonApp";
	private static Boolean b_flag = true; 
	TextView text;
	ImageView image;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
        Button start = (Button)findViewById(R.id.button1);    
        //TextView
        text = (TextView)findViewById(R.id.textView1);
        image = (ImageView)findViewById(R.id.imageView1);        
        
        //text.setText("Hello Sushma");
        start.setOnClickListener(startListener);
        return true;
    }
    
    private OnClickListener startListener = new OnClickListener() {
        public void onClick(View v) {
          Log.d(logtag,"onClick() called - start button");              
          //Toast.makeText(	MainActivity.this, "The Start button was clicked.", Toast.LENGTH_LONG).show();
          if(b_flag)
          {
        	  text.setText("Hi Sushma :)");
        	  image.setImageResource(R.drawable.tulips);
        	  b_flag = false;
          }
          else
    	  {
        	  text.setText("Bye Sushma :(");
        	  image.setImageResource(R.drawable.ic_launcher);
        	  b_flag = true;
    	  }
          
          Log.d(logtag,"onClick() ended - start button");
        }
    };

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
