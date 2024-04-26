package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NewsDetailFragment extends Fragment {

    private static final String ARG_POSITION = "position";

    private News news;

    public NewsDetailFragment() {

    }

    public static NewsDetailFragment newInstance(int position) {
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            int position = getArguments().getInt(ARG_POSITION);
            news = getNews().get(position);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView ivNewsDetailImage = view.findViewById(R.id.iv_news_detail_image);
        TextView tvNewsDetailTitle = view.findViewById(R.id.tv_news_detail_title);
        TextView tvNewsDetailDescription = view.findViewById(R.id.tv_news_detail_description);
        RecyclerView rvRelatedNews = view.findViewById(R.id.rv_related_news);

        ivNewsDetailImage.setImageResource(news.getImageResId());
        tvNewsDetailTitle.setText(news.getTitle());
        tvNewsDetailDescription.setText(news.getDescription());

        rvRelatedNews.setLayoutManager(new LinearLayoutManager(requireContext()));
        rvRelatedNews.setAdapter(new RelatedNewsAdapter(getRelatedNews(news)));
    }

    private List<News> getNews() {

        List<News> newsList = new ArrayList<>();
        newsList.add(new News("Bruce Lehrmann agrees to pay more than $4,000 to Lisa Wilkinson's husband Peter FitzSimons for costs incurred in failed defamation trial", "The local basketball team has won the national championship in an exciting overtime game.", R.drawable.news_image_1));
        newsList.add(new News("Shots fired into home in Melbourne's south-east", "Researchers have made a breakthrough in renewable energy technology, potentially paving the way for more sustainable energy sources.", R.drawable.news_image_2));
        newsList.add(new News("Jessica got in a car with a stranger. Police are now scouring a NSW forest to find her", "A major political scandal has erupted, with allegations of corruption and abuse of power rocking the government.", R.drawable.news_image_3));
        newsList.add(new News("Boy charged over alleged stabbing at Highpoint Shopping Centre", "A series of severe thunderstorms and tornadoes has caused widespread damage across several states.", R.drawable.news_image_4));
        newsList.add(new News("‘Enough’: thousands to join protests across Australia opposing violence against women", "Hollywood stars John and Jane Doe have announced that they are expecting their first child.", R.drawable.news_image_5));

        return newsList;
    }

//    private List<News> getRelatedNews(News news) {
//
//        List<News> relatedNewsList = new ArrayList<>();
//        String currentNewsTitle = news.getTitle();
//
//        for (News n : getNews()) {
//            if (n.getTitle().contains(currentNewsTitle.split(" ")[0])) {
//                relatedNewsList.add(n);
//            }
//        }
//
//        return relatedNewsList;
//    }
private List<News> getRelatedNews(News news) {
    List<News> relatedNews = new ArrayList<>();
    List<News> allNews = getNews(); // 获取所有新闻数据

    // 根据当前新闻的标题进行模糊匹配
    String currentNewsTitle = news.getTitle();
    for (News n : allNews) {
        if (n.getTitle().contains(currentNewsTitle.split(" ")[0])) {
            relatedNews.add(n);
        }
    }

    // 如果匹配的相关新闻少于3条,则补充其他新闻
    if (relatedNews.size() < 3) {
        for (News n : allNews) {
            if (!relatedNews.contains(n) && relatedNews.size() < 3) {
                relatedNews.add(n);
            }
        }
    }

    return relatedNews;
}
}
