package com.poojasingh.tutorialkotlin.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.poojasingh.tutorialkotlin.R;
import com.poojasingh.tutorialkotlin.data.remote.model.News;
import com.poojasingh.tutorialkotlin.databinding.FragmentNewsListBinding;
import com.poojasingh.tutorialkotlin.ui.adapter.NewsAdapter;
import com.poojasingh.tutorialkotlin.viewmodel.NewsViewModel;

public class ArticleListFragment extends Fragment {
    public static final String TAG = "ArticleListFragment";
    private NewsAdapter newsAdapter;
    private FragmentNewsListBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_list, container, false);

        newsAdapter = new NewsAdapter();
        binding.projectList.setAdapter(newsAdapter);
        binding.setIsLoading(true);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        NewsViewModel.Factory factory = new NewsViewModel.Factory(
                getActivity().getApplication());

        final NewsViewModel viewModel = ViewModelProviders.of(this, factory)
                .get(NewsViewModel.class);

        binding.setIsLoading(true);

        observeViewModel(viewModel);
    }

    private void observeViewModel(NewsViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getObservableProject().observe(getViewLifecycleOwner(), new Observer<News>() {
            @Override
            public void onChanged(@Nullable News news) {
                if (news != null) {
                    binding.setIsLoading(false);
                    newsAdapter.setProjectList(news.getArticles());
                }
            }
        });
    }
}
