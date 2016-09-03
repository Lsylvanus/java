package com.lsylvanus.model;

import com.lsylvanus.inter.IStar;

/**
 * 明星实体类，实现了明星接口的行为
 * 
 * @author fx-pro
 *
 */
public class Star implements IStar {

	private String mName;

	public Star(String name) {
		this.mName = name;
	}

	@Override
	public void attendTheShow() {
		System.out.println(this.mName + "参加演出\n");
	}

	@Override
	public void loveWife() {
		System.out.println(this.mName + "照顾了妻子");
	}
}
