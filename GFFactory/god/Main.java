package lsylvanus.god;

import lsylvanus.base.BaseGF;
import lsylvanus.base.IGFFactory;
import lsylvanus.base.IGFFather;
import lsylvanus.impl.LuoDingGFFactory;

/**
 * ���������ƵĴ���Ů���ѵĳ�����
 * @author fx-pro
 *
 */
public class Main {

	public static void main(String[] args) {
		BaseGF gdGirl = GFfactory.createGF(GFType.GUANG_DONG);
		gdGirl.eatFood();
		gdGirl.shopping();

		IGFFactory luoDingGFfactory = new LuoDingGFFactory();
		BaseGF luoDingGF = luoDingGFfactory.creatGF();
		luoDingGF.eatFood();
		luoDingGF.shopping();
		
		/**
		 * ����Ů����֮����������-_-
		 * 
		 * Eat Guangdong food...
		 * Go shopping every day...
		 * ը��ơ�ƣ��ӽ���
		 * Go shopping every day...
		 */
		
		// ������һ���ҵ�����ƣ������˰�
		IGFFather luoDingGFFather = luoDingGFfactory.createGFfather();
		luoDingGFFather.suggestionToGirl();
		
		/**
		 * �����������...
		 * 
		 * Eat Guangdong food...
		 * Go shopping every day...
		 * ը��ơ�ƣ��ӽ���
		 * Go shopping every day...
		 * Go to die...
		 */
	}
}
