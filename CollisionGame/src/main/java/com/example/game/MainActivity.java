package com.example.game;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class MainActivity extends Activity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mContext = this;
        findViewById(R.id.start_button).setOnTouchListener(mStartGameTouchListener);
        findViewById(R.id.about_button).setOnTouchListener(mShowDialogTouchListener);
    }

    View.OnTouchListener mStartGameTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Intent intent = new Intent(mContext, AndEngineSimpleGame.class);
            startActivity(intent);
            return true;
        }
    };

    View.OnTouchListener mShowDialogTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            builder.setTitle("About");
            builder.setMessage("To win the Game, you need to kill 10 enemies.\n Touch on the screen to shoot.");
            AlertDialog alert = builder.create();
            alert.show();
            return true;
        }
    };

}
