package com.example.musclememory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static java.lang.System.out;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //fade in and fade out text -- leave this part alone it works perfectly
        final TextView mSwitcher = (TextView) findViewById(R.id.textView);
        mSwitcher.setText(getString(R.string.intro));

        final Animation in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(3000);

        final Animation out = new AlphaAnimation(1.0f, 0.0f);
        out.setDuration(3000);

        out.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                //switches the text
                mSwitcher.setText(getString(R.string.after_ddd));
                mSwitcher.startAnimation(in);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                mSwitcher.setText(getString(R.string.sendoff));

            }
        });

       Button adder = (Button) findViewById(R.id.bodyadder);
        final int i = 1;

        adder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int ClickCounter = 0;
                ClickCounter += i ;

                //so that fade in and fade out does not happen every time
                if(ClickCounter == 1) {
                    //text switching animation
                    mSwitcher.startAnimation(out);
                    mSwitcher.setText(getString(R.string.after_ddd));
                    //mSwitcher.startAnimation(in);
                }
                if(ClickCounter > 1) {
                    mSwitcher.startAnimation(out);
                    mSwitcher.setText(getString(R.string.sendoff));
                }

                addButton();
                //this is the function that will add a new button as defined below

            }
        });
    }

    private void addButton() {
        Button button = new Button(HomeActivity.this);


    }
}
