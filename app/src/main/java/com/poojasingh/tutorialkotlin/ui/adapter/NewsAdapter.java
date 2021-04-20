package com.poojasingh.tutorialkotlin.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.poojasingh.tutorialkotlin.R;
import com.poojasingh.tutorialkotlin.data.remote.model.Article;
import com.poojasingh.tutorialkotlin.databinding.NewsListItemBinding;
import com.poojasingh.tutorialkotlin.ui.callback.OnClickCallback;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ArticleViewHolder> {

	List<? extends Article> articleList;

	public void setProjectList(final List<? extends Article> articleList) {
		if (this.articleList == null) {
			this.articleList = articleList;
			notifyItemRangeInserted(0, articleList.size());
		} else {
			DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
				@Override
				public int getOldListSize() {
					return NewsAdapter.this.articleList.size();
				}

				@Override
				public int getNewListSize() {
					return articleList.size();
				}

				@Override
				public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
					return NewsAdapter.this.articleList.get(oldItemPosition).getUrl() ==
							NewsAdapter.this.articleList.get(newItemPosition).getUrl();
				}

				@Override
				public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
					Article newArticle = articleList.get(newItemPosition);
					Article oldArticle = articleList.get(oldItemPosition);
					return newArticle.getUrl().equals(oldArticle.getUrl())
							&& oldArticle.getAuthor().equals(newArticle.getAuthor());
				}
			});
			this.articleList = articleList;
			result.dispatchUpdatesTo(this);
		}
	}

	@Override
	public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		NewsListItemBinding binding = DataBindingUtil
				.inflate(LayoutInflater.from(parent.getContext()), R.layout.news_list_item,
						 parent, false);

		binding.setCallback(new OnClickCallback());

		return new ArticleViewHolder(binding);
	}

	@Override
	public void onBindViewHolder(ArticleViewHolder holder, int position) {
		holder.binding.setArticle(articleList.get(position));
		holder.binding.executePendingBindings();
	}

	@Override
	public int getItemCount() {
		return articleList == null ? 0 : articleList.size();
	}

	static class ArticleViewHolder extends RecyclerView.ViewHolder {

		final NewsListItemBinding binding;

		public ArticleViewHolder(NewsListItemBinding binding) {
			super(binding.getRoot());
			this.binding = binding;
		}
	}
}
