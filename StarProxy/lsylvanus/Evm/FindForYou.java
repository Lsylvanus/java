package com.lsylvanus.Evm;

/**
 * ��һֱ��Ѱ��
 * �ҵ�����
 * ���ҵ�����������
 * @author fx-pro
 *
 */
public class FindForYou {
	
	private static String me_met = "lsylvanus";
	private static String youself = "lsylvanus";

	public static void main(String[] args) {
		find_you();
	}
	
	public static void find_you() {
		while (true) {
			System.out.println("finding you...");
			if (me_met==youself) {
				System.out.println("Hello , world!");
				break;
			}
		}
	}
}
