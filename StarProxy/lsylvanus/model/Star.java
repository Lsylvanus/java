package com.lsylvanus.model;

import com.lsylvanus.inter.IStar;

/**
 * ����ʵ���࣬ʵ�������ǽӿڵ���Ϊ
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
		System.out.println(this.mName + "�μ��ݳ�\n");
	}

	@Override
	public void loveWife() {
		System.out.println(this.mName + "�չ�������");
	}
}
