package com.laioffer.tinnews.ui.save;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.databinding.SavedNewsItemBinding;
import com.laioffer.tinnews.model.Article;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SavedNewsAdapter extends RecyclerView.Adapter<SavedNewsAdapter.SavedNewsViewHolder>{
    // support data
    private List<Article> articles = new ArrayList<>();
    private ItemCallBack callBack;

    public void setArticles(List<Article> articles){
        this.articles.clear();
        articles.addAll(articles);
        notifyDataSetChanged();
    }
    // Adapter overrides

    @NonNull
    @Override
    public SavedNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_news_item, parent, false);
        return new SavedNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SavedNewsViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.authorTextView.setText(article.author);
        holder.descriptionTextView.setText(article.description);
        holder.favoriteIcon.setOnClickListener(v -> callBack.onRemoveFavorite(article));
        holder.itemView.setOnClickListener(v -> callBack.onOpenDetails(article));
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    // Saved news view holder
    public static class SavedNewsViewHolder extends RecyclerView.ViewHolder{
        TextView authorTextView;
        TextView descriptionTextView;
        ImageView favoriteIcon;


        public SavedNewsViewHolder(@NonNull View itemView) {
            super(itemView);
            SavedNewsItemBinding binding = SavedNewsItemBinding.bind(itemView);
            authorTextView = binding.savedItemAuthorContent;
            descriptionTextView = binding.savedItemDescriptionContent;
            favoriteIcon = binding.savedItemFavoriteImageView;
        }
    }

    //

    interface ItemCallBack{
        void onOpenDetails(Article article);
        void onRemoveFavorite(Article article);
    }

    public void setCallBack(ItemCallBack itemCallBack){
        callBack = itemCallBack;
    }


}
