package com.example.fragment;

import com.example.adapter.FragmentLocalListAdapter;
import com.example.pppppp.MainActivity;
import com.example.pppppp.R;
import com.example.singleInstance.LocalMusicUtils;
import com.example.singleInstance.Utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Fragment_LocalMusic extends ListFragment {

	private ListView listview;
	private View headerview;
	private LinearLayout lin;
	private BaseAdapter adapter;

	
	
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		adapter = new FragmentLocalListAdapter(getActivity(), LocalMusicUtils.getLocalMusicArr(getActivity()), (MainActivity)getActivity());
		setListAdapter(adapter);
	}

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_localmusic, null);
		/*headerview = inflater.inflate(R.layout.headerview_localmusiclistview,
				null);
		TextView tv = (TextView) headerview
				.findViewById(R.id.headerview_localmusiclistview_playall);
		tv.setText("播放全部" + "（" + LocalMusicUtils.getArrSize(getActivity())
				+ "）");*/
		// 找到对应的view
		
		/*findview(view);
		// 设置adapter和监听器
		setAdapterAndListener();*/
		return view;
	}

	/**
	 * 设置监听器和适配器
	 */
	public void setAdapterAndListener() {
		//listview.addHeaderView(headerview);
		//listview.setEmptyView(emptyView);
		adapter = new FragmentLocalListAdapter(getActivity(), LocalMusicUtils.getLocalMusicArr(getActivity()), (MainActivity)getActivity());
		// 设置列表适配器
		//listview.setAdapter(adapter);
		// 播放全部的监听器
		/*lin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Utils.showToast(getActivity(), "你点击了播放全部");
			}
		});*/
	}

	/**
	 * 找view
	 * 
	 * @param view
	 */
	public void findview(View view) {
		//listview = (ListView) view.findViewById(R.id.fragment_localmusic_listview2);
		/*lin = (LinearLayout) headerview
				.findViewById(R.id.headerview_localmusiclistview_lin);*/
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

}
