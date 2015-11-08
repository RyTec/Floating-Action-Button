package com.osho.ernesto.fab;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity { /* When using Appcombat support library
                                                         you need to extend Main Activity to
                                                         ActionBarActivity.
                                                      */


    FloatingActionButton fab;
    private Toolbar mToolbar;                              // Declaring the Toolbar Object

    private boolean
            doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(mToolbar);                   // Setting toolbar as the ActionBar with setSupportActionBar() call


        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
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

        switch (item.getItemId()) {
            case R.id.about: {
                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                final TextView message = new TextView(this);
                message.setMovementMethod(LinkMovementMethod.getInstance());
                message.setText(R.string.about);
                message.setGravity(Gravity.CENTER);

                dlgAlert.setView(message);
                dlgAlert.setTitle("About Me");
                dlgAlert.setIcon(R.drawable.ic_help); // default for now
                dlgAlert.setPositiveButton("EXIT",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                //dismiss the dialog
                            }
                        });
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();

                return true;
            }

        }
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