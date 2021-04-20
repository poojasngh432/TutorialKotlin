package com.poojasingh.tutorialkotlin.ui.callback;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.poojasingh.tutorialkotlin.data.remote.model.Article;
import com.poojasingh.tutorialkotlin.ui.NewsDetailActivity;

public class OnClickCallback {
	public void onClick(View view, Article article) {
		Context context = view.getContext();
		Intent i = new Intent(context, NewsDetailActivity.class);
		i.putExtra("url", article.getUrl());
		 context.startActivity(i);
	}
}
