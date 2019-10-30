package com.journaldev.androidrssfeedtutorial;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Swipe_act_tech extends AppCompatActivity {

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
        setContentView(R.layout.activity_swipe_act_tech);


        category_title = getIntent().getStringExtra("category");

        technology_link.add("http://feeds.feedburner.com/gadgets360-latest");
        technology_link.add("https://zeenews.india.com/rss/technology-news.xml");
        technology_link.add("https://www.techrepublic.com/rssfeeds/articles/");
        technology_link.add("https://www.news18.com/rss/tech.xml");
        technology_link.add("http://indianexpress.com/section/technology/feed/");

        models = new ArrayList<>();
        models.add(new Model(R.drawable.ic_android_black_24dp, "NDTV", "Brochure is an informative paper document (often also used for advertising) that can be folded into a template"));
        models.add(new Model(R.drawable.ic_android_black_24dp, "Zee News", "Sticker is a type of label: a piece of printed paper, plastic, vinyl, or other material with pressure sensitive adhesive on one side"));
        models.add(new Model(R.drawable.ic_android_black_24dp, "Tech Republic", "Poster is any piece of printed paper designed to be attached to a wall or vertical surface."));
        models.add(new Model(R.drawable.ic_android_black_24dp, "News 18", "Business cards are cards bearing business information about a company or individual."));
        models.add(new Model(R.drawable.ic_android_black_24dp, "Indian Express", "Business cards are cards bearing business information about a company or individual."));


        adapter = new Adapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
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
        if(category_title.equals("technology")) {

            if(x.equals("NDTV")) {
                tech_ndtv();
            }
            else if(x.equals("Tech Republic")) {
                tech_republic();
            }
            else if(x.equals("Zee News")) {
                tech_zee_news();
            }
            else if(x.equals("News 18")) {
                tech_news_18();
            }
            else if(x.equals("Indian Express")) {
                tech_indian_express();
            }
        }


    }

    public void tech_ndtv() {
        startActivity(new Intent(Swipe_act_tech.this, RSSFeedActivity.class).putExtra("rssLink", technology_link.get(0)));
    }
    public void tech_republic() {
        startActivity(new Intent(Swipe_act_tech.this, RSSFeedActivity.class).putExtra("rssLink", technology_link.get(2)));
    }
    public void tech_zee_news() {
        startActivity(new Intent(Swipe_act_tech.this, RSSFeedActivity.class).putExtra("rssLink", technology_link.get(1)));
    }
    public void tech_news_18() {
        startActivity(new Intent(Swipe_act_tech.this, RSSFeedActivity.class).putExtra("rssLink", technology_link.get(3)));
    }
    public void tech_indian_express() {
        startActivity(new Intent(Swipe_act_tech.this, RSSFeedActivity.class).putExtra("rssLink", technology_link.get(4)));
    }
}
