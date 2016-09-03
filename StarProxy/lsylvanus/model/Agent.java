package com.lsylvanus.model;

import com.lsylvanus.inter.IStar;

/**
 * �����ˣ�������Ҫ�������ǣ�����Ҫ��������ͬ������Ϊ��ͬʱ�������ǵ�����
 * 
 * @author fx-pro
 *
 */
public class Agent implements IStar {

	/**
	 * �����˿��Դ���һ��������һЩ����
	 * 
	 * @param iStar
	 */
	IStar mIStar;
	boolean mIsHappy;

	public Agent(IStar iStar) {
		this.mIStar = iStar;
	}

	/**
	 * ���������һ�����������/�޸ı�����������Ϊ����������һ��"����"��״ֵ̬
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
			// �����������鲻��ʱ���ͻ�ɻ���
			System.out.println("������ �չ�����");
		}
	}
}
