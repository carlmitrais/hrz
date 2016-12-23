package com.cssolution.horizon.horizon_v01.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Path;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.TextView;

import com.cssolution.horizon.horizon_v01.R;
import com.cssolution.horizon.horizon_v01.helpers.DrawImageView;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class PhotoDetailActivity extends AppCompatActivity {

    private DrawImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View customActionBar = getLayoutInflater().inflate(R.layout.custom_action_bar, null);
        ((TextView) customActionBar.findViewById(R.id.customActionBarTitle)).setText("");
        android.support.v7.app.ActionBar.LayoutParams param = new android.support.v7.app.ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(customActionBar, param);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_photo_detail);

        final ImageView iconDrawLine = (ImageView) findViewById(R.id.drawLine);
        iconDrawLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBorderSelectedIcon(view);
            }
        });

        final ImageView iconWriteText = (ImageView) findViewById(R.id.addText);
        iconWriteText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBorderSelectedIcon(view);
            }
        });

        final ImageView iconRotate = (ImageView) findViewById(R.id.rotate);
        iconRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotateIconClickListener();
            }
        });

        final ImageView iconUndo = (ImageView) findViewById(R.id.undo);
        iconUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                undoIconClickListener();
            }
        });

        picture = ((DrawImageView) findViewById(R.id.photoDetailImageView));
        picture.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String type;
                if (iconDrawLine.isSelected()){
                    type = "Draw line";
                }
                else if (iconWriteText.isSelected()){
                    type = "Write text";
                }
                else {
                    type = null;
                }

                ((DrawImageView) view).setType(type);
                view.invalidate();
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.photo_detail_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    
    private void addBorderSelectedIcon(View view){
        if (!view.isSelected()) {
            view.setSelected(true);
            view.setBackground(ContextCompat.getDrawable(view.getContext(), R.drawable.selected_icon_menu));
        } else {
            view.setSelected(false);
            view.setBackground(ContextCompat.getDrawable(view.getContext(), R.drawable.unselected_icon_menu));
        }
    }

    private void undoIconClickListener(){
//        ArrayList<Path> paths = picture.getPaths();//.remove()
        picture.undo();
        picture.invalidate();
    }

    private void rotateIconClickListener(){
//        picture.setRotation(90);
        picture.rotate();
    }
}
