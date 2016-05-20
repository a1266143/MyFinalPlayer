package com.example.proxy;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.bean.HomeList;
import com.example.bean.Song;

public class AnaJson {
	/**
	 * 根据网络歌单类型解析json数据
	 * @param type
	 * @return
	 */
	public ArrayList<Song> anaJson(JSONObject jo,int type){
		ArrayList<Song> arr = null;
		switch (type) {
		// 新歌
		case NetWork.TYPE_NEWSONG:
			arr = realAnaNewSong(jo);
			break;
			//热歌
		case NetWork.TYPE_HOTSONG:

			break;
			//kty榜
		case NetWork.TYPE_KTV:

			break;
			//叱咤风云榜
		case NetWork.TYPE_WIND:

			break;
			//billboard榜
		case NetWork.TYPE_BILLBOARD:

			break;
			//摇滚榜
		case NetWork.TYPE_ROCK:

			break;
			//影视金曲榜
		case NetWork.TYPE_MOVIE:

			break;
			//hito榜
		case NetWork.TYPE_HITO:

			break;
			//华语金曲榜
		case NetWork.TYPE_CHINESE:

			break;
			//欧美金曲榜
		case NetWork.TYPE_EUROPE:

			break;
			//经典老歌
		case NetWork.TYPE_OLDSONG:
			
			break;
			//情歌对唱榜
		case NetWork.TYPE_LOVESONG:

			break;
			//网络歌曲榜
		case NetWork.TYPE_NETSONG:

			break;

		default:
			break;
		}
		return arr;
	}
	
	/**
	 * 解析新歌列表
	 * @param jsonobject
	 * @return
	 */
	public ArrayList<Song> realAnaNewSong(JSONObject jsonobject){
		ArrayList<Song> arr = null;
		try {
			arr = new ArrayList<Song>();
			JSONArray array = jsonobject.getJSONArray("song_list");
			for(int i=0;i<array.length();i++){
				JSONObject jo = array.getJSONObject(i);
				Song song = new Song();
				song.setArtistid(jo.getString("artist_id"));
				song.setLrclink(jo.getString("lrclink"));
				song.setHot(jo.getString("hot"));
				song.setSongid(jo.getString("song_id"));
				song.setTitle(jo.getString("title"));
				song.setTinguid(jo.getString("ting_uid"));
				song.setAuthor(jo.getString("author"));
				arr.add(song);
			}
			return arr;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
}
