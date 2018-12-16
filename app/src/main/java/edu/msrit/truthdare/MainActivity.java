package edu.msrit.truthdare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView bottle;
    Button button;
    Random random=new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottle=(ImageView) findViewById(R.id.bottle);
        button=(Button) findViewById(R.id.button);
    }
    public void pushbutton(View view)
    {
        int startdirection=0,enddirection;
        int rotate_x=bottle.getWidth()/2;
        int rotate_y=bottle.getHeight()/2;
        enddirection=random.nextInt(3600);
        Animation rotate=new RotateAnimation(startdirection,enddirection,rotate_x,rotate_y);
        rotate.setDuration(2500);
        rotate.setFillAfter(true);
        startdirection=enddirection;
        bottle.startAnimation(rotate);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


}
