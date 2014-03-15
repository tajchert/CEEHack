package com.android.ceehack.trust.data;

import android.graphics.Bitmap;
import android.graphics.Color;

public class Party {
	
	private String id; 
	private String name;
	private String shortName;
	private Bitmap logo;
	private Color backColor;
	private int nw;
	private int wns;
	private int ws;
	
	/**
	 * @param name
	 * @param shortName
	 * @param nw
	 * @param wns
	 * @param ws
	 */
	public Party(String name, String shortName, int nw, int wns, int ws) {
		super();
		this.name = name;
		this.shortName = shortName;
		this.nw = nw;
		this.wns = wns;
		this.ws = ws;
	}
	/**
	 * @param name
	 * @param shortName
	 */
	public Party(String name, String shortName) {
		super();
		this.name = name;
		this.shortName = shortName;
	}
	@Override
	public String toString() {
		return "Party [id=" + id + ", name=" + name + ", shortName="
				+ shortName + ", nw=" + nw + ", wns=" + wns + ", ws=" + ws
				+ "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public Bitmap getLogo() {
		return logo;
	}
	public void setLogo(Bitmap logo) {
		this.logo = logo;
	}
	public int getNw() {
		return nw;
	}
	public void setNw(int nw) {
		this.nw = nw;
	}
	public int getWns() {
		return wns;
	}
	public void setWns(int wns) {
		this.wns = wns;
	}
	public int getWs() {
		return ws;
	}
	public void setWs(int ws) {
		this.ws = ws;
	}
	public Color getBackColor() {
		return backColor;
	}
	public void setBackColor(Color backColor) {
		this.backColor = backColor;
	}
	
}
