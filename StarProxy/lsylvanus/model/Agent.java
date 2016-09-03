package com.lsylvanus.model;

import com.lsylvanus.inter.IStar;

/**
 * 经纪人，经纪人要代表明星，就需要和明星有同样的行为，同时持有明星的引用
 * 
 * @author fx-pro
 *
 */
public class Agent implements IStar {

	/**
	 * 经纪人可以代表一个明星做一些决定
	 * 
	 * @param iStar
	 */
	IStar mIStar;
	boolean mIsHappy;

	public Agent(IStar iStar) {
		this.mIStar = iStar;
	}

	/**
	 * 代理可以在一定情况下拦截/修改被代理对象的行为，这里设置一个"心情"的状态值
	 * 
	 * @param iStar
	 * @param isHappy
	 */
	public Agent(IStar iStar, boolean isHappy) {
		this.mIStar = iStar;
		this.mIsHappy = isHappy;
	}

	@Override
	public void attendTheShow() {
		mIStar.attendTheShow();
	}

	@Override
	public void loveWife() {
		if (mIsHappy) {
			mIStar.loveWife();
		} else {
			// 当经纪人心情不好时，就会干坏事
			System.out.println("经纪人 照顾妻子");
		}
	}
}
