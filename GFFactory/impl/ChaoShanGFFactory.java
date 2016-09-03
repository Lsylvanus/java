package lsylvanus.impl;

import lsylvanus.base.BaseGF;
import lsylvanus.base.IGFFactory;
import lsylvanus.base.IGFFather;
import lsylvanus.sub.ChaoShanGF;

/**
 * 创建潮汕妹子的工厂
 * 
 * @author fx-pro
 *
 */
public class ChaoShanGFFactory implements IGFFactory {

	@Override
	public BaseGF creatGF() {
		return new ChaoShanGF();
	}

	@Override
	public IGFFather createGFfather() {
		return new ChaoShanGFFather();
	}

}
