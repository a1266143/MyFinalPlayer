package com.example.bean;

public class Song extends SuperSong{
	//通过列表id获取关于这首歌的歌单
	private String artistid;
	private String hot;
	private String songid;
	//歌曲名称
	private String title;
	//歌手歌曲的ting_uid
	private String tinguid;
	//歌手
	private String author;
	//歌词地址
	private String lrclink;
	public String getArtistid() {
		return artistid;
	}
	public void setArtistid(String artistid) {
		this.artistid = artistid;
	}
	public String getHot() {
		return hot;
	}
	public void setHot(String hot) {
		this.hot = hot;
	}
	public String getSongid() {
		return songid;
	}
	public void setSongid(String songid) {
		this.songid = songid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTinguid() {
		return tinguid;
	}
	public void setTinguid(String tinguid) {
		this.tinguid = tinguid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLrclink() {
		return lrclink;
	}
	public void setLrclink(String lrclink) {
		this.lrclink = lrclink;
	}
	
	
}
