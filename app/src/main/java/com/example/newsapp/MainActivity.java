package com.example.newsapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化头条新闻RecyclerView
        RecyclerView topStoriesRecyclerView = findViewById(R.id.rv_top_stories);
        topStoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        topStoriesRecyclerView.setAdapter(new TopStoriesAdapter(getTopStories()));

        // 初始化普通新闻RecyclerView
        RecyclerView newsRecyclerView = findViewById(R.id.rv_news);
        newsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        newsRecyclerView.setAdapter(new NewsAdapter(getNews(), this));
    }

    // 模拟获取头条新闻数据
    private List<News> getTopStories() {
        // ...
        List<News> topStoriesList = new ArrayList<>();
        topStoriesList.add(new News("Sydney man wrongly named as Bondi Junction stabbings murderer settles defamation claim with Seven", "Sydney man Benjamin Cohen, who was wrongly named on air by Seven News as the Bondi Junction killer, has reached a confidential settlement with the network.", R.drawable.top_story_image_1));
        topStoriesList.add(new News("Eighth man charged over riot following Wakeley church stabbing", "Acme Inc. has unveiled a game-changing new product that is set to disrupt the tech industry.", R.drawable.top_story_image_2));
        topStoriesList.add(new News("Tesla's futuristic-looking 'Cybertruck' spotted on Australian streets", "Hollywood power couple John and Jane Doe have shocked fans by announcing their decision to divorce after 15 years of marriage.", R.drawable.top_story_image_3));

        return topStoriesList;
    }

    // 模拟获取普通新闻数据
    private List<News> getNews() {
        // ...
        List<News> newsList = new ArrayList<>();
        newsList.add(new News("Bruce Lehrmann agrees to pay more than $4,000 to Lisa Wilkinson's husband Peter FitzSimons for costs incurred in failed defamation trial", "The local basketball team has won the national championship in an exciting overtime game.", R.drawable.news_image_1));
        newsList.add(new News("Shots fired into home in Melbourne's south-east", "Researchers have made a breakthrough in renewable energy technology, potentially paving the way for more sustainable energy sources.", R.drawable.news_image_2));
        newsList.add(new News("Jessica got in a car with a stranger. Police are now scouring a NSW forest to find her", "A major political scandal has erupted, with allegations of corruption and abuse of power rocking the government.", R.drawable.news_image_3));
        newsList.add(new News("Boy charged over alleged stabbing at Highpoint Shopping Centre", "A series of severe thunderstorms and tornadoes has caused widespread damage across several states.", R.drawable.news_image_4));
        newsList.add(new News("‘Enough’: thousands to join protests across Australia opposing violence against women", "Hollywood stars John and Jane Doe have announced that they are expecting their first child.", R.drawable.news_image_5));

        return newsList;
    }
}