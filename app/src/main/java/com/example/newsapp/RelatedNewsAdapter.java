package com.example.newsapp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RelatedNewsAdapter extends RecyclerView.Adapter<RelatedNewsAdapter.ViewHolder> {

    private List<News> relatedNews;

    public RelatedNewsAdapter(List<News> relatedNews) {
        this.relatedNews = relatedNews;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_related_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News item = relatedNews.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return relatedNews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivRelatedNewsImage;
        TextView tvRelatedNewsTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivRelatedNewsImage = itemView.findViewById(R.id.iv_related_news_image);
            tvRelatedNewsTitle = itemView.findViewById(R.id.tv_related_news_title);
        }

        public void bind(News news) {
            ivRelatedNewsImage.setImageResource(news.getImageResId());
            tvRelatedNewsTitle.setText(news.getTitle());
        }
    }
}
