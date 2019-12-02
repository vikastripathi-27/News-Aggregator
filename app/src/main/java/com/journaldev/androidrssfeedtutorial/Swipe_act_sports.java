package com.journaldev.androidrssfeedtutorial;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Swipe_act_sports extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    ArrayList<String> sports_link = new ArrayList<>();

    String x;
    static String category_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_act_sports);

        category_title = getIntent().getStringExtra("category");

        sports_link.add("http://feeds.feedburner.com/ndtvsports-latest");
        sports_link.add("http://www.rediff.com/rss/sportsrss.xml");
        sports_link.add("https://zeenews.india.com/rss/sports-news.xml");
        sports_link.add("https://www.news18.com/rss/sports.xml");
        sports_link.add("http://indianexpress.com/section/sports/feed/");

        models = new ArrayList<>();
        models.add(new Model(R.drawable.ndtv, "NDTV","New Delhi Television Limited (NDTV) is an Indian television media company founded in 1988 by Radhika Roy, a journalist"));
        models.add(new Model(R.drawable.rediff, "Rediff", "Rediff.com is an Indian news, information, entertainment and shopping web portal, founded in 1996"));
        models.add(new Model(R.drawable.zee_news, "Zee News", "Zee News is an Indian pay television channel and also the flagship property of Zee Media"));
        models.add(new Model(R.drawable.news18, "News 18", "Network18 Media informally is referred to as the Network18 Group which is an Indian media and entertainment group"));
        models.add(new Model(R.drawable.indian_express, "Indian Express", "The Indian Express is an English-language Indian daily newspaper which is published in Mumbai by Indian Express Group"));

        adapter = new Adapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5)
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapter.getCount() -1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {
                x = models.get(position).getTitle();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public void clicked(View view) {

        //default
        if(x==null) {
            x = "NDTV";
        }
        if(category_title.equals("sports")) {

            if(x.equals("NDTV")) {
                sports_ndtv();
            }
            else if(x.equals("Rediff")) {
                sports_rediff();
            }
            else if(x.equals("Zee News")) {
                sports_zee_news();
            }
            else if(x.equals("News 18")) {
                sports_news_18();
            }
            else if(x.equals("Indian Express")) {
                sports_indian_express();
            }
        }

    }

    public void sports_ndtv() {
        startActivity(new Intent(Swipe_act_sports.this, RSSFeedActivity.class).putExtra("rssLink", sports_link.get(0)));
    }
    public void sports_rediff() {
        startActivity(new Intent(Swipe_act_sports.this, RSSFeedActivity.class).putExtra("rssLink", sports_link.get(1)));
    }
    public void sports_zee_news() {
        startActivity(new Intent(Swipe_act_sports.this, RSSFeedActivity.class).putExtra("rssLink", sports_link.get(2)));
    }
    public void sports_news_18() {
        startActivity(new Intent(Swipe_act_sports.this, RSSFeedActivity.class).putExtra("rssLink", sports_link.get(3)));
    }
    public void sports_indian_express() {
        startActivity(new Intent(Swipe_act_sports.this, RSSFeedActivity.class).putExtra("rssLink", sports_link.get(4)));
    }
}
