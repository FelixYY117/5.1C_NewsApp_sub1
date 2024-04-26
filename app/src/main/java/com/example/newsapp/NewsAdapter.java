package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> news;
    private Context context;

    public NewsAdapter(List<News> news, Context context) {
        this.news = news;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News item = news.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivNewsImage;
        TextView tvNewsTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivNewsImage = itemView.findViewById(R.id.iv_news_image);
            tvNewsTitle = itemView.findViewById(R.id.tv_news_title);
            itemView.setOnClickListener(this);
        }

        public void bind(News news) {
            ivNewsImage.setImageResource(news.getImageResId());
            tvNewsTitle.setText(news.getTitle());
        }

        @Override
        public void onClick(View v) {
//            int position = getAdapterPosition();
//            NewsDetailFragment newsDetail = NewsDetailFragment.newInstance(position);
//            ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction()
//                    .add(R.id.fragment_container, newsDetail)
//                    .addToBackStack(null)
//                    .commit();
            int position = getAdapterPosition();
            NewsDetailActivity.startActivity(context, position);

        }

    }
}