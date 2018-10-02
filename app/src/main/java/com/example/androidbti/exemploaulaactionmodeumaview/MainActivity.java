package com.example.androidbti.exemploaulaactionmodeumaview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, ActionMode.Callback {

    private TextView txtIncrementar;
    private int count;
    private boolean actionModeActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtIncrementar = findViewById(R.id.txt_number);
        txtIncrementar.setText("0");
        txtIncrementar.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View view) {
        if(!actionModeActive){
            startActionMode(this);
            actionModeActive = true;
        }

        return true;
    }

    @Override
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        getMenuInflater().inflate(R.menu.action, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        if(menuItem.getItemId() == R.id.act_add){
            count++;
            txtIncrementar.setText(String.valueOf(count));
            actionMode.finish();
        }
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode actionMode) {
        actionModeActive = false;
    }
}
