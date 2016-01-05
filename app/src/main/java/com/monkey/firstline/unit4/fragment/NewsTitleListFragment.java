package com.monkey.firstline.unit4.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.monkey.firstline.R;
import com.monkey.firstline.unit4.activity.NewsContentActivity;
import com.monkey.firstline.unit4.adapter.NewsAdapter;
import com.monkey.firstline.unit4.entity.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MonkeyKiky on 2016/1/5.
 */
public class NewsTitleListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView mLvNewsTitle;

    private NewsAdapter adapter;
    private List<News> newsList;
    private boolean isLarge;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        newsList = getNews();
        adapter = new NewsAdapter(activity, R.layout.item_news, newsList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);
        mLvNewsTitle = (ListView) view.findViewById(R.id.lv_news_title);
        mLvNewsTitle.setAdapter(adapter);
        mLvNewsTitle.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isLarge = getActivity().findViewById(R.id.fl_news_content) != null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        News news = newsList.get(position);
        String title = news.getTitle();
        String content = news.getContent();
        if (isLarge) {
            NewsContentFragment contentFragment = (NewsContentFragment) getFragmentManager()
                    .findFragmentById(R.id.frg_news_content);
            contentFragment.refresh(title, content);
        } else {
            NewsContentActivity.actionStart(getActivity(), title, content);
        }
    }

    private List<News> getNews() {
        List<News> list = new ArrayList<>();
        News news1 = new News();
        news1.setTitle("Succeeed in College as a Learning Disabled Student");
        news1.setContent("College  freshmen will soon learn to live with a roommate," +
                " adjust to a new social scene and survive less-than-stellar dining hall food." +
                " Students with learning disablilities will face these transitions while also" +
                " grappling with a few more hurdles.");
        list.add(news1);
        News news2 = new News();
        news2.setTitle("Google Android exec poached by China's Xioami");
        news2.setContent("China's Xiaomi has poached a key Google executive involved in the" +
                " tech giant's Android phones, in a move seen as a coup for the rapidly" +
                " growing Chinese smartphone maker.");
        list.add(news2);
        return list;
    }
}