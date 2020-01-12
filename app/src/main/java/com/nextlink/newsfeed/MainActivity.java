package com.nextlink.newsfeed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    String category1 = "top stories";
    String category2 = "national";
    String category3 = "world";
    String category4 = "technology";
    String category5 = "sports";
    String category6 = "entertainement";
    String category7 = "business";
    String category8 = "health";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

    }

    public void world_act(View view) {
        startActivity(new Intent(MainActivity.this, Swipe_act.class).putExtra("category", category3));
      //  Toast.makeText(this,"CATE = "+category3,Toast.LENGTH_LONG).show();
    }

    public void business_act(View view) {
        startActivity(new Intent(MainActivity.this, Swipe_act_business.class).putExtra("category", category7));
    }

    public void technology_act(View view) {
        startActivity(new Intent(MainActivity.this, Swipe_act_tech.class).putExtra("category", category4));
    }


    public void sports_act(View view) {
        startActivity(new Intent(MainActivity.this, Swipe_act_sports.class).putExtra("category", category5));
       // Toast.makeText(this,"CATE = "+category5,Toast.LENGTH_LONG).show();
    }

    public void national_act(View view) {
        startActivity(new Intent(MainActivity.this, Swipe_act.class).putExtra("category", category2));
    }

    public void top_stories_activity (View view) {
        startActivity(new Intent(MainActivity.this, Swipe_act.class).putExtra("category", category1));
      //  Toast.makeText(this,"CATEFUUU = "+category1,Toast.LENGTH_LONG).show();
    }

    public void health_act(View view) {
        startActivity(new Intent(MainActivity.this, Swipe_act_health.class).putExtra("category", category8));
    }

    public void movies_act(View view) {
        startActivity(new Intent(MainActivity.this, Swipe_act_entertainement.class).putExtra("category", category6));
    }
}
