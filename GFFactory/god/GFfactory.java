package lsylvanus.god;

import lsylvanus.base.BaseGF;
import lsylvanus.sub.ChaoShanGF;
import lsylvanus.sub.GuangDongGF;
import lsylvanus.sub.ShenZhenGF;

/**
 * 神灯为我们创建女朋友的工厂
 * @author fx-pro
 *
 */
public class GFfactory {

	public static BaseGF createGF(GFType gfType) {
		switch (gfType) {
		case GUANG_DONG:
			return new GuangDongGF();
		case CHAO_SHAN:
			return new ChaoShanGF();
		default:
		case SHEN_ZHEN:
			return new ShenZhenGF();
		}
	}
}
