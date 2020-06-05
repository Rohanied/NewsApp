package com.example.newsapp.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.OnRecyclerViewItemClickListener;
import com.example.newsapp.R;
import com.example.newsapp.model.Article;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

public class articleAdapter extends RecyclerView.Adapter<articleAdapter.customViewHolder> {

    Context context;
    List<Article> articleList;
     private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;
    //OnArticleListener onArticleListener;

    public articleAdapter(List<Article> articles) {
        this.articleList = articles;
    }

    @NonNull
    @Override
    public customViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row, parent, false);
        return new articleAdapter.customViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull customViewHolder holder, int position) {
        final Article articleModel = articleList.get(position);
        if (!TextUtils.isEmpty(articleModel.getTitle()))
            holder.titleText.setText(articleModel.getTitle());
        holder.descriptionText.setText(articleModel.getDescription());
        holder.mainAdapterParentLinear.setTag(articleModel);
        String urltoimage = articleModel.getUrlToImage();
        Picasso.get().load(urltoimage).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public class customViewHolder extends RecyclerView.ViewHolder {
        private TextView titleText;
        private TextView descriptionText;
        private ImageView imageView;
        private LinearLayout mainAdapterParentLinear;


        public customViewHolder(final View view) {
            super(view);
            titleText = (TextView) view.findViewById(R.id.title_text);
            descriptionText = (TextView) view.findViewById(R.id.description_text);
            mainAdapterParentLinear = (LinearLayout) view.findViewById(R.id.parent_view);
            imageView = (ImageView) view.findViewById(R.id.image);
            mainAdapterParentLinear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onRecyclerViewItemClickListener != null)  {
                        onRecyclerViewItemClickListener.OnItemClick(getAdapterPosition(), view);
                    }
                }
            });

        }
    }
    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }
}