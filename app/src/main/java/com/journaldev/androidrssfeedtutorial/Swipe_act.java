package com.journaldev.androidrssfeedtutorial;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Swipe_act extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    ArrayList<String> world_link = new ArrayList<>();
    ArrayList<String> top_stories_link = new ArrayList<>();
    ArrayList<String> national_link = new ArrayList<>();
    ArrayList<String> technology_link = new ArrayList<>();
    ArrayList<String> sports_link = new ArrayList<>();

    //

    String x;
    static String category_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_act);

        category_title = getIntent().getStringExtra("category");


        world_link.add("http://feeds.feedburner.com/ndtvnews-world-news");
        world_link.add("https://www.indiatoday.in/rss/1206577");
        world_link.add("https://zeenews.india.com/rss/world-news.xml");
        world_link.add("https://www.news18.com/rss/world.xml");
        world_link.add("http://indianexpress.com/section/world/feed/");

        top_stories_link.add("http://feeds.feedburner.com/ndtvnews-top-stories");
        top_stories_link.add("https://www.indiatoday.in/rss/home");
        top_stories_link.add("https://zeenews.india.com/rss/india-national-news.xml");
        top_stories_link.add("https://www.news18.com/rss/buzz.xml");
        top_stories_link.add("http://indianexpress.com/print/front-page/feed/");

        national_link.add("http://feeds.feedburner.com/ndtvnews-india-news");
        national_link.add("https://www.indiatoday.in/rss/1206514");
        national_link.add("https://zeenews.india.com/rss/india-news.xml");
        national_link.add("https://www.news18.com/rss/india.xml");
        national_link.add("http://indianexpress.com/section/india/feed/");

        sports_link.add("http://feeds.feedburner.com/ndtvsports-latest");
        sports_link.add("https://www.indiatoday.in/rss/1206550");
        sports_link.add("https://zeenews.india.com/rss/sports-news.xml");
        sports_link.add("https://www.news18.com/rss/sports.xml");
        sports_link.add("http://indianexpress.com/section/sports/feed/");

        models = new ArrayList<>();
        models.add(new Model(R.drawable.ic_android_black_24dp, "NDTV", "Brochure is an informative paper document (often also used for advertising) that can be folded into a template"));
        models.add(new Model(R.drawable.ic_android_black_24dp, "India Today", "Sticker is a type of label: a piece of printed paper, plastic, vinyl, or other material with pressure sensitive adhesive on one side"));
        models.add(new Model(R.drawable.ic_android_black_24dp, "Zee News", "Poster is any piece of printed paper designed to be attached to a wall or vertical surface."));
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
        if(category_title.equals("world")) {

            if(x.equals("NDTV")) {
                world_ndtv();
            }
            else if(x.equals("India Today")) {
                world_india_today();
            }
            else if(x.equals("Zee News")) {
                world_zee_news();
            }
            else if(x.equals("News 18")) {
                world_news_18();
            }
            else if(x.equals("Indian Express")) {
                world_indian_express();
            }
        }

        else if(category_title.equals("top stories")) {
            Toast.makeText(this,"top",Toast.LENGTH_LONG).show();
            if(x.equals("NDTV")) {
                top_ndtv();
            }
            else if(x.equals("India Today")) {
                top_india_today();
            }
            else if(x.equals("Zee News")) {
                top_zee_news();
            }
            else if(x.equals("News 18")) {
                top_news_18();
            }
            else if(x.equals("Indian Express")) {
                top_indian_express();
            }
        }

        else if(category_title.equals("national")) {

            if(x.equals("NDTV")) {
                national_ndtv();
            }
            else if(x.equals("India Today")) {
                national_india_today();
            }
            else if(x.equals("Zee News")) {
                national_zee_news();
            }
            else if(x.equals("News 18")) {
                national_news_18();
            }
            else if(x.equals("Indian Express")) {
                national_indian_express();
            }
        }


        else if(category_title.equals("sports")) {

            if(x.equals("NDTV")) {
                sports_ndtv();
            }
            else if(x.equals("India Today")) {
                sports_india_today();
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

    public void world_ndtv() {
        startActivity(new Intent(Swipe_act.this, RSSFeedActivity.class).putExtra("rssLink", world_link.get(0)));
    }
    public void world_india_today() {
        startActivity(new Intent(Swipe_act.this, RSSFeedActivity.class).putExtra("rssLink", world_link.get(1)));
    }
    public void world_zee_news() {
        startActivity(new Intent(Swipe_act.this, RSSFeedActivity.class).putExtra("rssLink", world_link.get(2)));
    }
    public void world_news_18() {
        startActivity(new Intent(Swipe_act.this, RSSFeedActivity.class).putExtra("rssLink", world_link.get(3)));
    }
    public void world_indian_express() {
        startActivity(new Intent(Swipe_act.this, RSSFeedActivity.class).putExtra("rssLink", world_link.get(4)));
    }

    public void top_ndtv() {
        startActivity(new Intent(Swipe_act.this, RSSFeedActivity.class).putExtra("rssLink", top_stories_link.get(0)));
    }
    public void top_india_today() {
        startActivity(new Intent(Swipe_act.this, RSSFeedActivity.class).putExtra("rssLink", top_stories_link.get(1)));
    }
    public void top_zee_news() {
        startActivity(new Intent(Swipe_act.this, RSSFeedActivity.class).putExtra("rssLink", top_stories_link.get(2)));
    }
    public void top_news_18() {
        startActivity(new Intent(Swipe_act.this, RSSFeedActivity.class).putExtra("rssLink", top_stories_link.get(3)));
    }
    public void top_indian_express() {
        startActivity(new Intent(Swipe_act.this, RSSFeedActivity.class).putExtra("rssLink", top_stories_link.get(4)));
    }

    public void national_ndtv() {
        startActivity(new Intent(Swipe_act.this, RSSFeedActivity.class).putExtra("rssLink", national_link.get(0)));
    }
    public void national_india_today() {
        startActivity(new Intent(Swipe_act.this, RSSFeedActivity.class).putExtra("rssLink", national_link.get(1)));
    }
    public void national_zee_news() {
        startActivity(new Intent(Swipe_act.this, RSSFeedActivity.class).putExtra("rssLink", national_link.get(2)));
    }
    public void national_news_18() {
        startActivity(new Intent(Swipe_act.this, RSSFeedActivity.class).putExtra("rssLink", national_link.get(3)));
    }
    public void national_indian_express() {
        startActivity(new Intent(Swipe_act.this, RSSFeedActivity.class).putExtra("rssLink", national_link.get(4)));
    }



    public void sports_ndtv() {
        startActivity(new Intent(Swipe_act.this, RSSFeedActivity.class).putExtra("rssLink", sports_link.get(0)));
    }
    public void sports_india_today() {
        startActivity(new Intent(Swipe_act.this, RSSFeedActivity.class).putExtra("rssLink", sports_link.get(1)));
    }
    public void sports_zee_news() {
        startActivity(new Intent(Swipe_act.this, RSSFeedActivity.class).putExtra("rssLink", sports_link.get(2)));
    }
    public void sports_news_18() {
        startActivity(new Intent(Swipe_act.this, RSSFeedActivity.class).putExtra("rssLink", sports_link.get(3)));
    }
    public void sports_indian_express() {
        startActivity(new Intent(Swipe_act.this, RSSFeedActivity.class).putExtra("rssLink", sports_link.get(4)));
    }
}
