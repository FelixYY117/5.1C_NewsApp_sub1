package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.ViewHolder> {
    private List<News> topStories;

    public TopStoriesAdapter(List<News> topStories) {
        this.topStories = topStories;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top_story, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News news = topStories.get(position);
        holder.bind(news);
    }

    @Override
    public int getItemCount() {
        return topStories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivTopStoryImage;
        TextView tvTopStoryTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivTopStoryImage = itemView.findViewById(R.id.iv_top_story_image);
            tvTopStoryTitle = itemView.findViewById(R.id.tv_top_story_title);
        }

        public void bind(News news) {
            ivTopStoryImage.setImageResource(news.getImageResId());
            tvTopStoryTitle.setText(news.getTitle());
        }
    }
}