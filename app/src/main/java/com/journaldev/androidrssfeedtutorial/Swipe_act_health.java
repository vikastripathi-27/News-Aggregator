package com.journaldev.androidrssfeedtutorial;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Swipe_act_health extends AppCompatActivity {
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    ArrayList<String> technology_link = new ArrayList<>();

    //

    String x;
    static String category_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_act_business);


        category_title = getIntent().getStringExtra("category");

        technology_link.add("http://feeds.feedburner.com/ndtvcooks-latest");
        technology_link.add("https://zeenews.india.com/rss/health-news.xml");
        //technology_link.add("https://www.techrepublic.com/rssfeeds/articles/");
        technology_link.add("https://medlineplus.gov/groupfeeds/new.xml");
        technology_link.add("http://www.indianexpress.com/section/lifestyle/health/feed/");

        models = new ArrayList<>();
        models.add(new Model(R.drawable.ndtv, "NDTV", "New Delhi Television Limited (NDTV) is an Indian television media company founded in 1988 by Radhika Roy, a journalist"));
        models.add(new Model(R.drawable.zee_news, "Zee News", "Zee News is an Indian pay television channel and also the flagship property of Zee Media"));
        models.add(new Model(R.drawable.medline, "Mediline Plus", "Medline Plus is an online information service produced by the United States National Library of Medicine"));
//        models.add(new Model(R.drawable.ic_android_black_24dp, "News 18", "Business cards are cards bearing business information about a company or individual."));
        models.add(new Model(R.drawable.indian_express, "Indian Express", "The Indian Express is an English-language Indian daily newspaper which is published in Mumbai by Indian Express Group"));


        adapter = new Adapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
//                getResources().getColor(R.color.color1),
//                getResources().getColor(R.color.color2),
//                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
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
        if(category_title.equals("health")) {

            if(x.equals("NDTV")) {
                tech_ndtv();
            }
            else if(x.equals("Mediline Plus")) {
                tech_republic();
            }
            else if(x.equals("Zee News")) {
                tech_zee_news();
            }
//            else if(x.equals("News 18")) {
//                tech_news_18();
//            }
            else if(x.equals("Indian Express")) {
                tech_indian_express();
            }
        }


    }

    public void tech_ndtv() {
        startActivity(new Intent(Swipe_act_health.this, RSSFeedActivity.class).putExtra("rssLink", technology_link.get(0)));
    }
    public void tech_republic() {
        startActivity(new Intent(Swipe_act_health.this, RSSFeedActivity.class).putExtra("rssLink", technology_link.get(2)));
    }
    public void tech_zee_news() {
        startActivity(new Intent(Swipe_act_health.this, RSSFeedActivity.class).putExtra("rssLink", technology_link.get(1)));
    }
//    public void tech_news_18() {
//        startActivity(new Intent(Swipe_act_health.this, RSSFeedActivity.class).putExtra("rssLink", technology_link.get(3)));
//    }
    public void tech_indian_express() {
        startActivity(new Intent(Swipe_act_health.this, RSSFeedActivity.class).putExtra("rssLink", technology_link.get(3)));
    }
}
