package com.lsylvanus.Evm;

import com.lsylvanus.model.Agent;
import com.lsylvanus.model.Star;

/**
 * ��绷����һ�㶼��ͨ�����������Ӵ�����
 * ���÷������ͨ�������˷�������
 * @author fx-pro
 *
 */
public class Environment {

	public static void main(String[] args) {
		// ����ǿ��һ���ɰ�/���ӵ�����
		Star baoqiang = new Star("����ǿ");
		// �и������˽��μ���
		Agent songJJ = new Agent(baoqiang, false);
		songJJ.attendTheShow();
		songJJ.loveWife();
		
		/**
		 * ���Կ����������Ҫ�����Ƿ�����ǿ���������ڲ������������������������޸ı����������Ϊ��
		 * ��������ϵͳ���
		 * ���������ͱ����������ھ�̬����
		 */
	}
}
