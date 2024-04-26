package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class NewsDetailActivity extends AppCompatActivity {

    private static final String EXTRA_NEWS_POSITION = "news_position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        int newsPosition = getIntent().getIntExtra(EXTRA_NEWS_POSITION, -1);
        if (newsPosition != -1) {
            NewsDetailFragment newsDetailFragment = NewsDetailFragment.newInstance(newsPosition);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, newsDetailFragment)
                    .commit();
        }
    }

    public static void startActivity(Context context, int newsPosition) {
        Intent intent = new Intent(context, NewsDetailActivity.class);
        intent.putExtra(EXTRA_NEWS_POSITION, newsPosition);
        context.startActivity(intent);
    }
}
