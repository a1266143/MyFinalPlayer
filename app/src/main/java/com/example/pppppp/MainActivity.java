package com.example.pppppp;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.example.adapter.FragmentLocalListAdapter.MenuClick;
import com.example.adapter.MyFragmentPagerAdapter;
import com.example.bean.LocalMusic;
import com.example.fragment.DialogFragment_Menu;
import com.example.fragment.Fragment_Local;
import com.example.fragment.Fragment_Online;
import com.example.fragment.Fragment_Search;
import com.example.listener.MyPageChangeListener;
import com.example.singleInstance.LocalMusicUtils;
import com.example.singleInstance.Utils;

public class MainActivity extends BaseActivity implements OnClickListener,MenuClick {

	private ImageButton searchBtn,listBtn,playBtn,nextSongBtn,localmusicBtn,onlineMusicBtn;
	private ViewPager mViewPager;
	private MyFragmentPagerAdapter adapter;
	
	public static final String BACKSTACK = "MyBackStack";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void init() {
		Fragment mFragment_Local = new Fragment_Local();
		Fragment mFragment_Online = new Fragment_Online();
		ArrayList<Fragment> arr = new ArrayList<Fragment>();
		arr.add(mFragment_Local);
		arr.add(mFragment_Online);
		adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), arr);
	}



	@Override
	public void findview() {
		searchBtn = (ImageButton) findViewById(R.id.activity_main_searchbtn);
		listBtn = (ImageButton) findViewById(R.id.activity_main_listbtn);
		playBtn = (ImageButton) findViewById(R.id.activity_main_playbtn);
		nextSongBtn = (ImageButton) findViewById(R.id.activity_main_nextsong);
		mViewPager = (ViewPager) findViewById(R.id.activity_main_viewpager);
		localmusicBtn = (ImageButton) findViewById(R.id.activity_main_localmusicbtn);
		onlineMusicBtn = (ImageButton) findViewById(R.id.activity_main_onlinemusicbtn);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setListener() {
		searchBtn.setOnClickListener(this);
		listBtn.setOnClickListener(this);
		playBtn.setOnClickListener(this);
		nextSongBtn.setOnClickListener(this);
		localmusicBtn.setOnClickListener(this);
		onlineMusicBtn.setOnClickListener(this);
		//设置viewpager的适配器
		mViewPager.setAdapter(adapter);
		mViewPager.setOnPageChangeListener(new MyPageChangeListener(this,localmusicBtn,onlineMusicBtn));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		//本地音乐按钮
		case R.id.activity_main_localmusicbtn:
			//设置状态以及viewpager
			setViewPager(R.id.activity_main_localmusicbtn);
			break;
			//在线音乐按钮
		case R.id.activity_main_onlinemusicbtn:
			//设置状态以及viewpager
			setViewPager(R.id.activity_main_onlinemusicbtn);
			break;
		//搜索按钮
		case R.id.activity_main_searchbtn:
			goToSearch();
			break;
			//列表按钮
		case R.id.activity_main_listbtn:
			Utils.showToast(this, "你点击了列表按钮");
			break;
			//播放按钮
		case R.id.activity_main_playbtn:
			Utils.showToast(this, "你点击了播放按钮");
			break;
			//下一首按钮
		case R.id.activity_main_nextsong:
			Utils.showToast(this, "你点击了下一首按钮");
			break;
		}
	}
	
	/**
	 * 通过按钮标识设置viewpager以及button的状态
	 * @param id
	 */
	public void setViewPager(int id){
		switch (id) {
		case R.id.activity_main_localmusicbtn:
			localmusicBtn.setImageResource(R.drawable.localmusic_selected);
			onlineMusicBtn.setImageResource(R.drawable.onlinemusic);
			mViewPager.setCurrentItem(0);
			break;
		case R.id.activity_main_onlinemusicbtn:
			localmusicBtn.setImageResource(R.drawable.localmusic);
			onlineMusicBtn.setImageResource(R.drawable.onlinemusic_selected);
			mViewPager.setCurrentItem(1);
			break;
		}
	}

	@Override
	public void setContentView() {
		setContentView(R.layout.activity_main);
	}

	@Override
	public int getColor() {
		return android.R.color.white;
	}
	
	/**
	 * 搜索界面
	 */ 
	public void goToSearch(){
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.activity_main_frameLayout, new Fragment_Search());
		transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		transaction.addToBackStack(BACKSTACK);
		transaction.commit();
	}

	/**
	 * 本地音乐列表菜单按钮被按
	 */
	@Override
	public void onclick(int pos,List<LocalMusic> list) {
		DialogFragment_Menu menu = DialogFragment_Menu.newInstance(list.get(pos).getSongName());
		menu.show(getSupportFragmentManager(), "本地音乐菜单");
	}

}
