package lsylvanus.god;

import lsylvanus.base.BaseGF;
import lsylvanus.base.IGFFactory;
import lsylvanus.base.IGFFather;
import lsylvanus.impl.LuoDingGFFactory;

/**
 * 这个就是神灯的创建女朋友的程序了
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
		 * 有了女朋友之后是这样的-_-
		 * 
		 * Eat Guangdong food...
		 * Go shopping every day...
		 * 炸鸡啤酒，杂酱面
		 * Go shopping every day...
		 */
		
		// 我们又一次找到了神灯，满意了吧
		IGFFather luoDingGFFather = luoDingGFfactory.createGFfather();
		luoDingGFFather.suggestionToGirl();
		
		/**
		 * 结果是这样滴...
		 * 
		 * Eat Guangdong food...
		 * Go shopping every day...
		 * 炸鸡啤酒，杂酱面
		 * Go shopping every day...
		 * Go to die...
		 */
	}
}
