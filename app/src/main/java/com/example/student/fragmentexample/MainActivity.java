package com.example.student.fragmentexample;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
    boolean val=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        FragmentOne fragOne = new FragmentOne();
        FragmentTwo fragTwo = new FragmentTwo();
        transaction.add(R.id.fragView, fragOne, "Fragment1");
        transaction.add(R.id.fragView, fragTwo, "Fragment2");
        transaction.commit();

        SwitchFrag();
    }

    public void SwitchFrag(){

        Button button = (Button) findViewById(R.id.buttonswitch);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ImageView firstimg= (ImageView) findViewById(R.id.imageView);
                ImageView secondimg= (ImageView) findViewById(R.id.imageView2);


                if(val){
                    firstimg.setImageResource(R.drawable.applelinux);
                    secondimg.setImageResource(R.drawable.androidlinux);
                    val=false;
                }
                else{
                    firstimg.setImageResource(R.drawable.androidlinux);
                    secondimg.setImageResource(R.drawable.applelinux);
                    val=true;
                }

            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
