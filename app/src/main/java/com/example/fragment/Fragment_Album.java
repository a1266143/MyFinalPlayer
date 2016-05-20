package com.example.fragment;

import java.util.List;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.adapter.FragmentAlbumAdapter;
import com.example.bean.Album;
import com.example.pppppp.R;
import com.example.singleInstance.LocalMusicUtils;

public class Fragment_Album extends ListFragment {
	
	private List<Album> list;
	private BaseAdapter adapter;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		list = LocalMusicUtils.getLocalMusicAlbum(getActivity());
		adapter = new FragmentAlbumAdapter(getActivity(), list);
		setListAdapter(adapter);
	}

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_album, null);
	}


	
}
