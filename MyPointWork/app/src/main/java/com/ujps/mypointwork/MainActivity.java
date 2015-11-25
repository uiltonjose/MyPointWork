package com.ujps.mypointwork;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.ujps.mypointwork.util.PreferenceUtil;

public class MainActivity extends AppCompatActivity {

    private TextView counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        counterTextView = (TextView) findViewById(R.id.counterView);
        counterTextView.setText(String.valueOf(PreferenceUtil.getSavedCounter(MainActivity.this)));

        FloatingActionButton addMeal = (FloatingActionButton) findViewById(R.id.addMeal);
        addMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value = PreferenceUtil.getSavedCounter(MainActivity.this) + 1;
                PreferenceUtil.setCounterSharedPreference(MainActivity.this, value);
                counterTextView.setText(String.valueOf(value));
                Snackbar.make(view, "Refeição adicionada.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        addMeal.setColorNormal(Color.parseColor("#4DA956"));

        FloatingActionButton removeMeal = (FloatingActionButton) findViewById(R.id.removeMeal);
        removeMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int savedCounter = PreferenceUtil.getSavedCounter(MainActivity.this);
                if (savedCounter == 0) {
                    Snackbar.make(view, "Não é possível remover, você não possui nenhuma refeição.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    int newValue = --savedCounter;
                    PreferenceUtil.setCounterSharedPreference(MainActivity.this, newValue);
                    counterTextView.setText(String.valueOf(newValue));
                    Snackbar.make(view, "Refeição removida.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        removeMeal.setColorNormal(Color.RED);
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
