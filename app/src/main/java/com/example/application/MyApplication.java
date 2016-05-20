package com.example.application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.Application;

public class MyApplication extends Application {

	//初始化volley
	private RequestQueue mRequestQueue;
	@Override
	public void onCreate() {
		super.onCreate();
		mRequestQueue = Volley.newRequestQueue(this);
	}
	
	/*
	 * 返回全局的RequestQueue对象
	 * 主要是进行网络操作
	 */
	public RequestQueue getRequestQueue(){
		if(mRequestQueue!=null)
			return mRequestQueue;
		else
			return null;
	}

}
