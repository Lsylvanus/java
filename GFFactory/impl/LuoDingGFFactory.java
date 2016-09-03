package lsylvanus.impl;

import lsylvanus.base.BaseGF;
import lsylvanus.base.IGFFactory;
import lsylvanus.base.IGFFather;
import lsylvanus.sub.LuoDingGF;

/**
 * 创建罗定妹子的工厂
 * @author fx-pro
 *
 */
public class LuoDingGFFactory implements IGFFactory{

	@Override
	public BaseGF creatGF() {
		// TODO Auto-generated method stub
		return new LuoDingGF();
	}

	@Override
	public IGFFather createGFfather() {
		return new LuoDingGFFather();
	}
}
