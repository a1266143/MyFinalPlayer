package com.example.singleInstance;

import com.example.pppppp.R;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 工具类
 * 
 * @author 李晓军
 * 
 */
public class Utils {

	/**
	 * 显示Toast
	 * 
	 * @param context
	 * @param s
	 */
	public static void showToast(Context context, String s) {
		Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 关闭输入法
	 */
	public static void closeInputMethod(Context context,EditText edt) {
		InputMethodManager imm = (InputMethodManager) context.getApplicationContext()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(edt.getWindowToken(), 0);
		//imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS); 
	}
	
	/**
	 * 打开新的fragment
	 */
	public static void openNewFragment(FragmentTransaction tran,int res, Fragment fragment){
		tran.replace(res, fragment);
		tran.addToBackStack(null);
		tran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		tran.commit();
	}
	
	/**
	 * 以动画方式打开菜单fragment
	 */
	public static void openMenu(FragmentTransaction tran,int res,Fragment fragment){
		tran.setCustomAnimations(R.anim.enter, 0,0,R.anim.out1);
		tran.add(res, fragment);
		tran.addToBackStack(null);
		tran.commit();
	}
}
